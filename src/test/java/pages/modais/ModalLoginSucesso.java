package pages.modais;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import support.Esperas;
import support.Utils;

public class ModalLoginSucesso {

    private static final By SELETOR_BOTAO_OK = By.xpath(".//button[text() = 'OK']");
    private static final By SELETOR_SAUDACAO_USUARIO = By.xpath("./div[preceding-sibling::h2][1]");
    private static final By SELETOR_MODAL_LOGIN_SUCESSO = By.xpath("//div[h2[text() = 'Login realizado'] and div[button[text() = 'OK']]]");

    public static void esperarModalLoginSucesso() throws Exception {
        Esperas.esperarElementoVisivel(SELETOR_MODAL_LOGIN_SUCESSO);
    }

    public static void esperarModalLoginSucessoFechar() throws Exception {
        Esperas.esperarElementoForaDom(SELETOR_MODAL_LOGIN_SUCESSO);
    }

    public static void validarMensagemSaudacao(String emailUsuario) throws Exception {
        final WebElement MODAL_LOGIN_SUCESSO = retornarModalLoginSucesso();
        final WebElement CAMPO_SAUDACAO = Utils.retornarWebElement(MODAL_LOGIN_SUCESSO, SELETOR_SAUDACAO_USUARIO);
        final String SAUDACAO_USUARIO_ESPERADA = "Olá, " + emailUsuario;
        final String SAUDACAO_USUARIO_ENCONTRADA = Utils.retornarTextoElemento(CAMPO_SAUDACAO);
        if(!SAUDACAO_USUARIO_ESPERADA.equals(SAUDACAO_USUARIO_ENCONTRADA)) {
            throw new Exception("***** A saudação esperada e a encontrada não correspondem! Esperada: '" + SAUDACAO_USUARIO_ESPERADA + "' e a encontrada foi: '" + SAUDACAO_USUARIO_ENCONTRADA + "'.");
        }
    }

    public static void clicarOk() throws Exception {
        final WebElement MODAL_LOGIN_SUCESSO = retornarModalLoginSucesso();
        final WebElement BOTAO_OK = Utils.retornarWebElement(MODAL_LOGIN_SUCESSO, SELETOR_BOTAO_OK);
        Utils.clicarElemento(BOTAO_OK);
    }

    private static WebElement retornarModalLoginSucesso() throws Exception {
        return Utils.retornarWebElement(SELETOR_MODAL_LOGIN_SUCESSO);
    }
}
