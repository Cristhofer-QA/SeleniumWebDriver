package support;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import runner.DriverManager;

public class Esperas extends DriverManager {

    public static void esperarPaginaCarregarCompletamente() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(driver1 -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            System.err.println("***** A página não carregou em 30 segundos!");
            throw new Exception();
        }
    }

    public static void esperarElementoVisivel(By seletorElemento) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(seletorElemento));
        } catch (Exception e) {
            System.err.println("***** Elemento não ficou visível em 30 segundos! Elemento: " + seletorElemento);
            throw new Exception();
        }
    }

    public static void esperarElementoClicavel(By seletorElemento) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(seletorElemento));
        } catch (Exception e) {
            System.err.println("***** Elemento não ficou clicável em 30 segundos! Elemento: " + seletorElemento);
            throw new Exception();
        }
    }

    public static void esperarElementoClicavel(WebElement elemento) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(elemento));
        } catch (Exception e) {
            System.err.println("***** Elemento não ficou clicável em 30 segundos! Elemento: " + elemento);
            throw new Exception();
        }
    }

    public static void esperarElementoForaDom(By elemento) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(elemento));
        } catch (Exception e) {
            System.err.println("***** Elemento não ficou clicável em 30 segundos! Elemento: " + elemento);
            throw new Exception();
        }
    }

}
 