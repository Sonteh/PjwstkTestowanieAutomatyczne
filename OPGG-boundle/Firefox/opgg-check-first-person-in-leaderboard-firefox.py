import logging

from selenium import webdriver
from selenium.webdriver.common.keys import Keys

logging.basicConfig(filename='./TauOpggTestLeaderboardFirefox.log', filemode='w', level=logging.DEBUG)
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

logger.info("Trying to click on Leaderboards")

try:
    xpath = "/html/body/div[3]/div[1]/ul/li[4]/a"
    element = driver.find_element_by_xpath(xpath)
    driver.execute_script("arguments[0].click();", element)
    logger.info("Going into Leaderboards")
except:
    logger.error("Unable to get to Leaderboards tab")

logger.info("Trying to get first place summoner name")

try:
    temp = driver.find_element_by_class_name("ranking-highest__name")
    logger.info("First place summoner name: %s", temp.text)
except:
    logger.error("Unable to get first place summoner name")

try:
    xpath = "//*[@id=\"summoner-22325769\"]/div[4]/b"
    temp = driver.find_element_by_xpath(xpath)
    logger.info("Points: %s", temp.text)
except:
    logger.error("Unable to get first place summoner points")

driver.close()
