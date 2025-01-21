package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import runner.DriverManager;

public class Utils extends DriverManager {

    public static WebElement retornarWebElement(By elemento) throws Exception {
        try {
            return driver.findElement(elemento);
        } catch (Exception e) {
            throw new Exception(
                    "\n***** Erro ao encontrar o elemento: " + elemento
                    + "\n***** Erro: " + e);
        }
    }

    public static void clicarElemento(By elemento) throws Exception {
        final WebElement ELEMENTO = retornarWebElement(elemento);
        clicarElemento(ELEMENTO);
    }

    public static void clicarElemento(WebElement elemento) throws Exception {
        try {
            elemento.click();
        } catch (Exception e) {
            throw new Exception(
                    "\n***** Erro ao clicar no elemento o elemento: " + elemento
                    + "\n***** Erro: " + e);
        }
    }

    public static void preencherCampo(By elemento, String texto) throws Exception {
        final WebElement ELEMENTO = retornarWebElement(elemento);
        preencherCampo(ELEMENTO, texto);
    }

    public static void preencherCampo(WebElement elemento, String texto) throws Exception {
        try {
            elemento.sendKeys(texto);
        } catch (Exception e) {
            throw new Exception(
                    "\n***** Erro ao preencher o campo: " + elemento
                    + "\n***** Erro: " + e);
        }
    }

    public static String retornarValorElemento(By elemento) throws Exception {
        final WebElement ELEMENTO = retornarWebElement(elemento);
        return retornarValorElemento(ELEMENTO);
    }

    public static String retornarValorElemento(WebElement elemento) throws Exception {
        try {
            return elemento.getAttribute("value");
        } catch (Exception e) {
            throw new Exception(
                    "\n***** Erro retornar o value do elemento: " + elemento
                    + "\n***** Erro: " + e);
        }
    }

    public static String retornarTextoElemento(By elemento) throws Exception {
        final WebElement ELEMENTO = retornarWebElement(elemento);
        return retornarTextoElemento(ELEMENTO);
    }

    public static String retornarTextoElemento(WebElement elemento) throws Exception {
        try {
            return elemento.getText();
        } catch (Exception e) {
            throw new Exception(
                    "\n***** Erro retornar o texto do elemento: " + elemento
                    + "\n***** Erro: " + e);
        }
    }

    public static void assertEquals(By elemento, String textoEsperado) throws Exception {
        final String TEXTO_ENCONTRADO = retornarWebElement(elemento).getText();
        try {
            Assert.assertEquals(textoEsperado, TEXTO_ENCONTRADO);
        } catch (AssertionError e) {
            throw new AssertionError(
                    "\n***** Erro ao realizar o assert do elemento " + elemento
                    + "\n***** Texto esperado: " + textoEsperado + ". Texto obtido: " + TEXTO_ENCONTRADO
                    + "\n***** " + e.getMessage());
        }
    }

    public static WebElement retornarWebElement(WebElement webElement, By seletor) throws Exception {
        try {
            return webElement.findElement(seletor);
        } catch (Exception e) {
            throw new Exception(
                    "\n***** Erro retornar o texto do elemento: " + seletor + " do WebElement: " + webElement
                    + "\n***** Erro: " + e);
        }
    }
}
