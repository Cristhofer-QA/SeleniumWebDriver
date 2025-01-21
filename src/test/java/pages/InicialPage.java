package pages;

import org.openqa.selenium.By;

import support.Esperas;
import support.Utils;

public class InicialPage {
    private static final By BOTAO_LOGIN = By.xpath("//section[@id = 'top_header']//ul/li/a[contains(text(), 'Login')]");
    private static final By BOTAO_CADASTRAR_USUARIO = By.xpath("//section[@id = 'top_header']//ul/li/a[contains(text(), 'Cadastro')]");

    public static void clicarCadastro() throws Exception {
        Esperas.esperarElementoClicavel(BOTAO_CADASTRAR_USUARIO);
        Utils.clicarElemento(BOTAO_CADASTRAR_USUARIO);
    }

    public static void clicarLogin() throws Exception {
        Esperas.esperarElementoClicavel(BOTAO_LOGIN);
        Utils.clicarElemento(BOTAO_LOGIN);
    }
}
