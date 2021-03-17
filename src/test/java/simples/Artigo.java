package simples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Artigo {
    String url;             // Endereço do site alvo
    WebDriver driver;       // Objeto do Selenium WebDriver

    @Before                // Antes do Teste
    public void iniciar(){
        url = "https:/pt.wikipedia.org/";
        // Onde está o Chrome Driver
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/88/chromedriver.exe");
        driver = new ChromeDriver();    // Instanciar o Selenium como Chrome Driver

        driver.manage().window().maximize();    // Maximizar a janela do navegador
        // Define uma espera implicita de 1 min, verificando o carregamento a cada segundo
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

    }

    @Test                   // Durante o Teste
    public void consultarArtigo(){
        // Abrir o site
        driver.get(url);

        // Pesquisar por "Ovo de Páscoa"
        driver.findElement(By.id("searchInput")).sendKeys("Ovo de Páscoa");
        //driver.findElement(By.id("searchButton")).click();
        driver.findElement(By.cssSelector("button.wvui-button")).click();

        // Validar o título da página de retorno
        //assertEquals("Ovo de Páscoa - Wikipédia, a enciclopédia livre", driver.getTitle());
        assertTrue(driver.getTitle().contains("Ovo de Páscoa"));


    }

    @After                  // Depois do Teste
    public void finalizar(){
        driver.quit();
    }

}
