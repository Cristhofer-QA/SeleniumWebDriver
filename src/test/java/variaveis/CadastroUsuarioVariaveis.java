package variaveis;

import support.MassaDados;

public class CadastroUsuarioVariaveis {
    private static String nomeCorretoUsuario = "";
    private static String emailCorretoUsuario = "";
    private static String senhaCorretaUsuario = "";

    public static String getNomeCorretoUsuario() {
        if (nomeCorretoUsuario.isEmpty()) {
            nomeCorretoUsuario = MassaDados.gerarNomeCompleto();
        }
        return nomeCorretoUsuario;
    }

    public static String getEmailCorretoUsuario() {
        if (emailCorretoUsuario.isEmpty()) {
            emailCorretoUsuario = MassaDados.gerarEmail();
        }
        return emailCorretoUsuario;
    }

    public static String getSenhaCorretaUsuario() {
        if (senhaCorretaUsuario.isEmpty()) {
            senhaCorretaUsuario = MassaDados.gerarSenha();
        }
        return senhaCorretaUsuario;
    }
}
