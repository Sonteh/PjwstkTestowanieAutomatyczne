import logging

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from selenium.common.exceptions import TimeoutException

logging.basicConfig(filename='./TauMoreleTestAlarmEdge.log', filemode='w', level=logging.DEBUG)
logger = logging.getLogger('Selenium TAU Lab2 - Morele')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

driver = webdriver.Edge(executable_path="C:\Program Files (x86)\Microsoft\Edge\Application\msedgedriver.exe")
timeout = 5

logger.info('Opening Morele.net site')
driver.get('https://www.morele.net/')
driver.maximize_window()

logger.info("Trying to access Alarm Cenowy")

try:
    xpath = '//*[@id="horizontal_navigation"]/ul/li[2]/a'
    temp = driver.find_element_by_xpath(xpath)
    driver.execute_script("arguments[0].click();", temp)
    logger.info("Going into Alarm Cenowy")
except:
    logger.error("Unable to reach Alarm Cenowy")

logger.info("Trying to get discount code")

try:
    temp = driver.find_element_by_id('code1')
    logger.info("Discount code: %s", temp.text)
except:
    logger.error("Unable to get discound code of the product")

logger.info("Trying to change sorting type")

try:
    temp = driver.find_element_by_xpath("//*[@id=\"productList\"]/div/div/div[2]/div[1]/div[3]/div/div[1]/button")
    driver.execute_script("arguments[0].click();", temp)
    temp = driver.find_element_by_xpath("//*[@id=\"productList\"]/div/div/div[2]/div[1]/div[3]/div/div[3]/ul/li[2]")
    driver.execute_script("arguments[0].click();", temp)
    logger.info("Changed sorting type")
except:
    logger.error("Unable to change sorting style")

driver.close()