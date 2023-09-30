package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DestinationSearchTest {
    public static void main(String[] args){
        try {
            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            //to maximize the window
            driver.manage().window().maximize();
            // to open the url
            driver.get("https://qadest.ccbp.tech");
            // count the display images
            List<WebElement> countElements=driver.findElements(By.xpath("//li[contains(@class,'destination-item')]"));
            // check condition
            if(countElements.size()==12){
                System.out.println("Destinations 12 count is correct");
            }else{
                System.out.println("Destinations count is incorrect: ");
            }
            // search on input page
            WebElement searchOnInput=driver.findElement(By.xpath("//input[contains(@class,'search-input')]"));
            searchOnInput.sendKeys("io");

            // to check the visible images
            List<WebElement>secondCheckElements=driver.findElements(By.xpath("//li[contains(@class,'destination-item')]"));
            // check the condition
            if(secondCheckElements.size()==4){
                System.out.println("Destinations 4 count is correct");
            }else{
                System.out.println("Destinations count is incorrect");
            }
            boolean allContainIo = true;

                 // Loop through each destination element
            for (WebElement destination :secondCheckElements ) {
                // Get the text of the destination name
                String name = destination.getText();

                // If the name does not contain 'io', set the boolean variable to false and break the loop
                if (!name.contains("io")) {
                    allContainIo = false;
                    break;
                }
            }

            // If all the destinations contain 'io', print "All destinations contain 'io' in their names"
            if (allContainIo) {
                System.out.println("All destinations contain 'io' in their names");
            }
            // Else, print "Search functionality is not as expected"
            else {
                System.out.println("Search functionality is not as expected");
            }

            searchOnInput.clear();
            // enter the second input

            WebElement searchOnInput1=driver.findElement(By.xpath("//input[contains(@class,'search-input')]"));
            searchOnInput1.sendKeys("ion");

            List<WebElement>thirdCheckElements=driver.findElements(By.xpath("//li[starts-with(@class,'destination-')]"));

            // to check the elements
            if(thirdCheckElements.size()==3){
                System.out.println("Destinations count is correct");
            }else{
                System.out.println("Destinations count is incorrect");
            }
            boolean allContainIo1 = true;

            // Loop through each destination element
            for (WebElement destination :thirdCheckElements ) {
                // Get the text of the destination name
                String name = destination.getText();

                // If the name does not contain 'io', set the boolean variable to false and break the loop
                if (!name.contains("ion")) {
                    allContainIo1 = false;
                    break;
                }
            }

            // If all the destinations contain 'io', print "All destinations contain 'io' in their names"
            if (allContainIo) {
                System.out.println("All destinations contain 'ion' in their names");
            }
            // Else, print "Search functionality is not as expected"
            else {
                System.out.println("Search functionality is not as expected");
            }
            driver.quit();




        }catch (Exception e){
            System.out.println("Hi venkatesh we got an syntax error: "+e.getMessage());
        }
    }
}
