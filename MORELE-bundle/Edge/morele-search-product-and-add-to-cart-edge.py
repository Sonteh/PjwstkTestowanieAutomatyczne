import logging

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from selenium.common.exceptions import TimeoutException

logging.basicConfig(filename='./TauMoreleTestAddToCartEdge.log', filemode='w', level=logging.DEBUG)
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

logger.info("Trying to insert search phrase in search bar")

try:
    temp = driver.find_element_by_xpath("//*[@id=\"header\"]/div[1]/div[1]/div/div/div[2]/div/div[1]/form/div/input")
    temp.clear()
    temp.send_keys("PS5")
    temp.send_keys(Keys.RETURN)
    logger.info("Searching for product")
except:
    logger.error("Unable to search product")

logger.info("Trying to add to cart first product")

try:
    xpath = "//*[@id=\"category\"]/div[2]/div/div[6]/div[1]/div[1]/div/div[2]/div[2]/div[5]/a"
    temp = driver.find_element_by_xpath(xpath)
    temp.click()
    logger.info("Added product to cart")
except:
    logger.error("Unable to add product to cart")

driver.close()