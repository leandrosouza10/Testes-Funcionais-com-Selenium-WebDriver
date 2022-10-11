
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Formulario {
    WebDriver driver;
    @Before
    public void inicio() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("C:/seleniumAulas/testeGoogle/src/test/resources/formulario/componentes.html");
    }

    @Test
    public void formularioTest() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Fulano de tal");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sandman");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        driver.findElement((By.id("elementosForm:sugestoes"))).sendKeys("basvibapvibapsiubvpsb\nvpbspdjbvjhsbvjhbsvhb\nSJHVDVSHBVSHBVP");
    }

    @After
    public void fim() {
        driver.quit();
    }
}
