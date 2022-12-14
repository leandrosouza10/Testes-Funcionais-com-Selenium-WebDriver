import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioEndCheckBox {

    WebDriver driver;
    @Before
    public void inicio(){
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("C:/seleniumAulas/testeGoogle/src/test/resources/formulario/componentes.html");
    }

    @Test
    public void deveInteragirComRadioButton() {
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
    }
    @Test
    public void deveInteragirComCheckBox() {
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        Assert.assertTrue(  driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
    }
    @After
    public void fim(){
        driver.quit();
    }
}
