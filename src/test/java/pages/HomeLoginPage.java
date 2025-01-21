package pages;

import org.openqa.selenium.By;

import support.Esperas;
import support.Utils;

public class HomeLoginPage {

    private static final By CAMPO_USUARIO_LOGADO = By.id("userLogged");

    public static void validarUsuarioLogado(String email) throws Exception {
        final String EMAIL_USUARIO_LOGADO = Utils.retornarTextoElemento(CAMPO_USUARIO_LOGADO);
        if (!EMAIL_USUARIO_LOGADO.equals(email)) {
            throw new Exception("***** O usuário logado não corresponde com o esperado no campo de usuário logado. Usuário esperado: '" + email
                    + "' e o usuário encontrado foi: '" + EMAIL_USUARIO_LOGADO + "'");
        }
    }

    public static void esperarCampoUsuarioLogado() throws Exception {
        Esperas.esperarElementoVisivel(CAMPO_USUARIO_LOGADO);
    }
}
