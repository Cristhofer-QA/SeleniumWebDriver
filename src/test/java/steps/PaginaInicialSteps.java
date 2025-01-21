package steps;

import io.cucumber.java.en.Given;
import pages.CadastroPage;
import pages.InicialPage;
import pages.LoginPage;

public class PaginaInicialSteps {

    @Given("que esteja na tela de cadastro de usuários")
    public void acessarTelaCadastroUsuario() throws Exception {
        InicialPage.clicarCadastro();
        CadastroPage.esperarTelaCadastro();
    }

    @Given("que esteja na página de login do sistema")
    public void acessarTelaLogin() throws Exception {
        InicialPage.clicarLogin();
        LoginPage.esperarTelaLogin();
    }
}
