package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomeLoginPage;
import pages.LoginPage;
import pages.modais.ModalLoginSucesso;

public class LoginSteps {
    @When("preencher o usuário {string} e a senha {string}")
    public static void preencherUsuarioSenha(String email, String senha) throws Exception {
        LoginPage.preencherEmail(email);
        LoginPage.preencherSenha(senha);
    }

    @When("clicar em login")
    public static void clicarLogin() throws Exception {
        LoginPage.clicarLogin();
    }

    @Then("deve aparecer uma mensagem de boas vindas para o usuário {string}")
    public static void validarLoginUsuario(String email) throws Exception {
        ModalLoginSucesso.esperarModalLoginSucesso();
        ModalLoginSucesso.validarMensagemSaudacao(email);
        ModalLoginSucesso.clicarOk();
        ModalLoginSucesso.esperarModalLoginSucessoFechar();
    }

    @Then("{string} deve ser direcionado para a tela inicial do usuário")
    public static void validarUsuarioLogado(String email) throws Exception {
        HomeLoginPage.esperarCampoUsuarioLogado();
        HomeLoginPage.validarUsuarioLogado(email);
    }

    @Then("deve aparecer a mensagem de {string} e login não deverá ser realizado")
    public static void validarLoginIncorreto(String mensagem) throws Exception {
        LoginPage.validarCampoInvalido(mensagem);
    }

}
