package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import ulitility.Utility;

public class MenTest extends Utility {

    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {


            // Mouse Hover on Men Menu
            mouseHoverToElement(By.xpath("//a[@id='ui-id-5']//span[contains(text(),'Men')]"));
            //Mouse Hover on Bottoms
            mouseHoverToElement(By.xpath("//a[@id='ui-id-18']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
            //Click on Pants
            clickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
            //* Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
            mouseHoverToElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
            clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
            //Mouse Hover on product name‘Cronus Yoga Pant’ and click on colour Black.
            mouseHoverToElementAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
            //mouseHoverToElementAndClick(By.id("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
            //Mouse Hover on product name‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button
            mouseHoverToElementAndClick(By.xpath("(//span[text() ='Add to Cart'])[1]"));
            // Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
            //verifyFromElement(By.xpath("///div[@class='message-success success message']"),"You added Cronus Yoga Pant to your shopping cart.");
            verifyFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"),"You added Cronus Yoga Pant to your shopping cart.");
            //Click on ‘shopping cart’ Link into message
            clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
            Thread.sleep(1000);
            //Verify the text ‘Shopping Cart.’
            verifyFromElement(By.xpath("//span[@class='base']"), "Shopping Cart");
            //Verify the product name ‘Cronus Yoga Pant’
            verifyFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"), "Cronus Yoga Pant");
            // Verify the product size ‘32’
            verifyFromElement(By.xpath("//dd[contains(text(),'32')]"), "32");
            //Verify the product colour ‘Black’
            verifyFromElement(By.xpath("//dd[contains(text(),'Black')]"), "Black");
        }

        @After
        public void tearDown() {
              closeBrowser();


    }
}