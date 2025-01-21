package pages.modais;

import org.openqa.selenium.By;

import support.Esperas;
import support.Utils;

public class ModalCadastroUsuarioSucesso {
    private static final By SELETOR_MODAL_CADASTRO = By.xpath("//div[h2[text() = 'Cadastro realizado!']]");
    private static final By CAMPO_SAUDACAO_USUARIO = By.xpath("//div[h2[text() = 'Cadastro realizado!']]//div[contains(text(), 'Bem-vindo')]");
    private static final By BOTAO_OK = By.xpath("//div[h2[text() = 'Cadastro realizado!']]//button[text() = 'OK']");

    public static void esperarModalCadastroAbrir() throws Exception {
        Esperas.esperarElementoVisivel(SELETOR_MODAL_CADASTRO);
        Esperas.esperarElementoVisivel(CAMPO_SAUDACAO_USUARIO);
    }

    public static void validarSaudacao(String nomeUsuario) throws Exception {
        final String TEXTO_ESPERADO = "Bem-vindo ".concat(nomeUsuario);
        Utils.assertEquals(CAMPO_SAUDACAO_USUARIO, TEXTO_ESPERADO);
    }

    public static void clicarOk() throws Exception {
        Utils.clicarElemento(BOTAO_OK);
        Esperas.esperarElementoForaDom(SELETOR_MODAL_CADASTRO);
    }
}
