import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestAlert {

    WebDriver driver;
    @Before
    public void inicio(){
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("C:/seleniumAulas/testeGoogle/src/test/resources/formulario/componentes.html");
    }
    @Test
    public void deveInteragirComAlertSimples() {
        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Alert Simples", texto);
        alert.accept();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
    }

    @Test
    public void deveInteragirComAlertComfirm() {
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alert.getText());
        alert.accept();
        Assert.assertEquals("Confirmado", alert.getText());
        alert.accept();

        driver.findElement(By.id("confirm")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alerta.getText());
        alerta.dismiss();
        Assert.assertEquals("Negado", alerta.getText());
        alerta.dismiss(); //  para cancelar um pop-up
    }

    @Test
    public void deveInteragirComAlertPrompt() {
        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero",alert.getText());
        alert.sendKeys("123456789");
        alert.accept();
        Assert.assertEquals("Era 123456789?",alert.getText());
        alert.accept();
        Assert.assertEquals(":D",alert.getText());
        alert.accept();

        //Caso não seja o esperado
        driver.findElement(By.id("prompt")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero",alerta.getText());
        alerta.sendKeys("123456789");
        alerta.accept();
        Assert.assertEquals("Era 123456789?",alerta.getText());
        alerta.dismiss();
        Assert.assertEquals(":(",alerta.getText());
        alerta.accept();
    }
    @After
    public void fim (){
        driver.quit();
    }
}
