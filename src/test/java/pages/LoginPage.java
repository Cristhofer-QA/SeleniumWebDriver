package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import runner.DriverManager;
import support.Esperas;
import support.Utils;

public class LoginPage extends DriverManager {

    private static final By CAMPO_EMAIL = By.id("user");
    private static final By CAMPO_SENHA = By.id("password");
    private static final By BOTAO_LOGIN = By.id("btnLogin");
    private static final By SELETOR_CAMPO_INVALIDO = By.className("invalid_input");

    public static void esperarTelaLogin() throws Exception {
        Esperas.esperarElementoVisivel(CAMPO_EMAIL);
        Esperas.esperarPaginaCarregarCompletamente();
    }

    public static void preencherEmail(String email) throws Exception {
        Utils.preencherCampo(CAMPO_EMAIL, email);
    }

    public static void preencherSenha(String senha) throws Exception {
        Utils.preencherCampo(CAMPO_SENHA, senha);
    }

    public static void clicarLogin() throws Exception {
        Utils.clicarElemento(BOTAO_LOGIN);
    }

    public static void validarCampoInvalido(String mensagemCampoInvalido) throws Exception {
        final WebElement CAMPO_INVALIDO = Utils.retornarWebElement(SELETOR_CAMPO_INVALIDO);
        final String MENSAGEM_CAMPO_INVALIDO = Utils.retornarTextoElemento(CAMPO_INVALIDO);
        if (!mensagemCampoInvalido.equals(MENSAGEM_CAMPO_INVALIDO)) {
            throw new Exception(
                    "***** A mensagem do campo inválido não corresponde com a esperada. Mensagem esperada: '" + mensagemCampoInvalido
                    + "' e a encontrada foi: '" + MENSAGEM_CAMPO_INVALIDO + "'.");
        }
    }
}
