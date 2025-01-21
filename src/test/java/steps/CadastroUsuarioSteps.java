package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CadastroPage;
import pages.modais.ModalCadastroUsuarioSucesso;
import variaveis.CadastroUsuarioVariaveis;

public class CadastroUsuarioSteps {

    @When("eu preencho o nome, email e senha com valores válidos")
    public void preencherNomeEmailSenhaValidos() throws Exception {
        final String NOME = CadastroUsuarioVariaveis.getNomeCorretoUsuario();
        final String EMAIL = CadastroUsuarioVariaveis.getEmailCorretoUsuario();
        final String SENHA = CadastroUsuarioVariaveis.getSenhaCorretaUsuario();
        CadastroPage.preencherNome(NOME);
        CadastroPage.preencherEmail(EMAIL);
        CadastroPage.preencherSenha(SENHA);
    }

    @When("eu preencho o nome {string}, email {string} e senha {string}")
    public void preencherNomeEmailSenha(String nome, String email, String senha) throws Exception {
        CadastroPage.preencherNome(nome);
        CadastroPage.preencherEmail(email);
        CadastroPage.preencherSenha(senha);
    }

    @And("clico em cadastrar")
    public void clicarCadastrar() throws Exception {
        CadastroPage.clicarCadastrar();
    }

    @Then("vejo a mensagem de cadastro com sucesso")
    public void validarMensagemCadastroSucesso() throws Exception {
        final String NOME = CadastroUsuarioVariaveis.getNomeCorretoUsuario();
        ModalCadastroUsuarioSucesso.esperarModalCadastroAbrir();
        ModalCadastroUsuarioSucesso.validarSaudacao(NOME);
        ModalCadastroUsuarioSucesso.clicarOk();
    }

    @Then("vejo a mensagem {string}")
    public void validarMensagemCadastroIncorreto(String mensagem) throws Exception {
        CadastroPage.validarCadastroIncorreto(mensagem);
    }
}
