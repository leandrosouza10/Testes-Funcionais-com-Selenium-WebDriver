import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestAlert {

    WebDriver driver = new ChromeDriver();

    @Test
    public void deveInteragirComAlertSimples() {
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("C:/seleniumAulas/testeGoogle/src/test/resources/formulario/componentes.html");
        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Alert Simples", texto);
        alert.accept();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
        driver.quit();
    }


    @Test
    public void deveInteragirComAlertComfirm() {
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("C:/seleniumAulas/testeGoogle/src/test/resources/formulario/componentes.html");
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alert.getText());
        alert.accept();
        Assert.assertEquals("Confirmado", alert.getText());
        alert.accept();

        driver.findElement(By.id("confirm")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alert.getText());
        alert.dismiss();
        Assert.assertEquals("Negado", alert.getText());
        alert.dismiss(); //  para cancelar um pop-up

        driver.quit();
    }
}
