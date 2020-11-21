import logging

from selenium import webdriver
from selenium.webdriver.common.keys import Keys

logging.basicConfig(filename='./TauOpggTestFirefox.log', filemode='w', level=logging.DEBUG)
logger = logging.getLogger('Selenium TAU Lab2 - OPGG')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

driver = webdriver.Firefox(executable_path="C:\Program Files\Mozilla Firefox\geckodriver.exe")
driver.maximize_window()
driver.implicitly_wait(20)

logger.info('Opening OP.GG site on european server')
driver.get('https://eune.op.gg/')

logger.info("Trying to insert summoner name 'nVis Sonteh' into search bar")

temp = driver.find_element_by_class_name("summoner-search-form__text")
temp.clear()
temp.send_keys("nVis Sonteh")

logger.info("Trying to go to searched summoner profile.")
temp.send_keys(Keys.RETURN)

try:
    summoner = driver.find_element_by_class_name("Name")
    logger.info("Summoner name on searched profile is: %s", summoner.text)
except:
    no_summoner = driver.find_element_by_class_name('Title')
    logger.error("Unable to find summoner 'nVis Sonteh'")

logger.info("Trying to get your KDA from your last game")

try:
    xpath = "//*[@id=\"SummonerLayoutContent\"]/div[2]/div[2]/div/div[2]/div[3]/div[1]/div/div[1]/div[3]/div[1]"
    KDA_last_game = driver.find_element_by_xpath(xpath)
    kill = KDA_last_game.find_element_by_class_name("Kill")
    death = KDA_last_game.find_element_by_class_name("Death")
    assist = KDA_last_game.find_element_by_class_name("Assist")

    logger.info("Your kills %s, deaths %s, assists %s in your last game", kill.text, death.text, assist.text)
except:
    logger.error("Unable to find your last game")

driver.close()
