

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Formulario {
    WebDriver driver = new ChromeDriver();

    @Test
    public void formularioTest() {
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("C:/seleniumAulas/testeGoogle/src/test/resources/formulario/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Fulano de tal");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sandman");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        driver.findElement((By.id("elementosForm:sugestoes"))).sendKeys("basvibapvibapsiubvpsb\nvpbspdjbvjhsbvjhbsvhb\nSJHVDVSHBVSHBVP");
        driver.quit();
    }
}
