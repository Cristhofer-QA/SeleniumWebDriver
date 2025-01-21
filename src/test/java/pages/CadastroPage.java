package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import runner.DriverManager;
import support.Esperas;
import support.Utils;

public class CadastroPage extends DriverManager {

    private static final By CAMPO_NOME = By.id("user");
    private static final By CAMPO_EMAIL = By.id("email");
    private static final By CAMPO_SENHA = By.id("password");
    private static final By BOTAO_CADASTRAR = By.id("btnRegister");
    private static final By SELETOR_CAMPO_INVALIDO = By.className("errorLabel");
    private static final By TITULO_CADASTRAR_USUARIO = By.xpath("//*[@id='login_area']//h3[text() = 'Cadastro de usuário']");

    public static void esperarTelaCadastro() throws Exception {
        Esperas.esperarElementoVisivel(TITULO_CADASTRAR_USUARIO);
        Esperas.esperarPaginaCarregarCompletamente();
    }

    public static void preencherNome(String nome) throws Exception {
        Utils.preencherCampo(CAMPO_NOME, nome);
        final String VALOR_CAMPO_NOME = Utils.retornarValorElemento(CAMPO_NOME);
        Assert.assertEquals(nome, VALOR_CAMPO_NOME);
    }

    public static void preencherEmail(String email) throws Exception {
        Utils.preencherCampo(CAMPO_EMAIL, email);
        final String VALOR_CAMPO_EMAIL = Utils.retornarValorElemento(CAMPO_EMAIL);
        Assert.assertEquals(email, VALOR_CAMPO_EMAIL);
    }

    public static void preencherSenha(String senha) throws Exception {
        Utils.preencherCampo(CAMPO_SENHA, senha);
        final String VALOR_CAMPO_SENHA = Utils.retornarValorElemento(CAMPO_SENHA);
        Assert.assertEquals(senha, VALOR_CAMPO_SENHA);
    }

    public static void clicarCadastrar() throws Exception {
        Utils.clicarElemento(BOTAO_CADASTRAR);
    }

    public static void validarCadastroIncorreto(String mensagem) throws Exception {
        final String MENSAGEM_ENCONTRADA = Utils.retornarTextoElemento(SELETOR_CAMPO_INVALIDO);
        if (!MENSAGEM_ENCONTRADA.equals(mensagem)) {
            throw new Exception("***** A mensagem de campo inválido encontrada e a esperada não correspondem! Esperada '" + mensagem
                    + "' e a encontrada foi '" + MENSAGEM_ENCONTRADA + "'");
        }
    }
}
