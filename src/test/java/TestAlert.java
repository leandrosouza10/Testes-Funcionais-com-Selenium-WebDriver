import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestAlert {

    WebDriver driver  = new ChromeDriver();

    @Test
    public void deveInteragirComAlertSimples(){
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("C:/seleniumAulas/testeGoogle/src/test/resources/formulario/componentes.html");
        driver.findElement(By.id("elementosForm")).click();


        driver.quit();

    }


}
