package is.ru.arnlaugsson.chuck_joke;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;

public class TestChuckWeb extends SeleniumTestWrapper {
    @Test
    public void titleMatches() {
        driver.get(baseUrl);
        assertEquals("Chuck Norris Jokes", driver.getTitle());
    }

    @Test
    public void assertUpdatingNameChangesSpecificJoke() {
        driver.get(baseUrl + "/config.html");

        String firstName = "Hilmar";
        String lastName = "Tryggvason";

		WebElement firstNameInputBox = driver.findElement(By.id("firstName"));
        firstNameInputBox.sendKeys(firstName);

        WebElement lastNameInputBox = driver.findElement(By.id("lastName"));
        lastNameInputBox.sendKeys(lastName);

        // Submit
        lastNameInputBox.sendKeys(Keys.ENTER);

        WebElement resultsBox = driver.findElement(By.id("results"));
        assertEquals("Name set as: " + firstName + " " + lastName + ".", resultsBox.getText());

        // Go to Specific jokes page
        driver.findElement(By.linkText("Get a specific joke!")).sendKeys(Keys.ENTER);

        WebElement numberBox = driver.findElement(By.id("number"));
        numberBox.sendKeys("5");

        // Submit
        numberBox.sendKeys(Keys.RETURN);

        resultsBox = driver.findElement(By.className("alert-success"));

        assertEquals(true, resultsBox.getText().contains(firstName + " " + lastName));
        /*
        1. Fill in some name (first name, last name)
        2. Submit form.
        3. Assert that form notifies of success ("Name set as: ...")
        4. Navigate to page to get specific Joke
        5. Enter a specific joke number
        6. Assert the name is used in the joke.
        */
    }
}
