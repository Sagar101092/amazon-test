package TestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Amazon extends Utility {

    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {
        // Open browser and launch Url
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        // Close all open tabs
        closeBrowser();
    }

    @Test
    public void searchDelLaptop() throws InterruptedException {
        clickOnElement(By.xpath("//input[@class='a-button-input celwidget']"));
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));
        selectCheckBox(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));
        Thread.sleep(2000);
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//h2//a"));
        int expectedMessage = 30;
        int actualMessage = products.size();
        verifyTwoTextMessage(expectedMessage, actualMessage);

        Thread.sleep(2000);
//        while (true) {
//
//            boolean eleSelected =  driver.findElement(By.xpath("(//a[@href='/LATITUDE-LAPTOP-8365u-250GB-TOUCH/dp/B07YPS1G7H/ref=sr_1_54?crid=3AIMLJ7BCT0UL&keywords=Dell+Laptop&qid=1682588299&refinements=p_89%3ADell&rnid=1632651031&s=computers&sprefix=dell+laptop%2Caps%2C79&sr=1-54'])[2]")).isDisplayed();
//           // boolean eleSelected = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//h2//a[contains(normalize-space(.),'Dell LATITUDE 5300 LAPTOP CORE I5 8365u 8GB 250GB SSD 13.3')]")).isDisplayed();
//            if (eleSelected) {
//                clickOnElement(By.xpath("//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//h2//a[contains(normalize-space(.), \"Dell LATITUDE 5300 LAPTOP CORE I5 8365u 8GB 250GB SSD 13.3\")]"));
//                break;
//            } else {
//                clickOnElement(By.xpath("//a[normalize-space()='Next']"));
//            }
//        }
        // clickOnElement(By.xpath("//a[normalize-space()='Next']"));

        findLaptop("Dell Inspiron 16 Plus-7620 Laptop i7-12700H");
        Thread.sleep(2000);
        String expectedMessage1 = "Dell Inspiron 16 Plus-7620 Laptop i7-12700H";

        String actualMessage1 = getTextFromElement(By.xpath("//span[@id='productTitle']"));
        String[] actMessage = actualMessage1.split(",");
        verifyTwoTextMessage(expectedMessage1, actMessage[0]);

    }

    public void findLaptop(String value) throws InterruptedException {
        Thread.sleep(1000);
        boolean flag = true;
        while (flag) {
            //   boolean flag=true;
            List<WebElement> products1 = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//h2//a"));

            // String value = "Dell Inspiron 16 Plus-7620 Laptop i7-12700H";
            //  while (true) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (WebElement e : products1) {
                String productname = e.getText();
                String[] laptopNames = productname.split(",");
                arrayList.addAll(Arrays.asList(laptopNames[0]));
            }

            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println(arrayList.get(i));
                if (arrayList.get(i).equalsIgnoreCase(value)) {
                    clickOnElement(By.xpath("//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//h2//a[contains(normalize-space(.), '" + value + "')]"));
                    // break;
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("==================================================================");
                clickOnElement(By.xpath("//a[normalize-space()='Next']"));
            }
        }
    }
}
