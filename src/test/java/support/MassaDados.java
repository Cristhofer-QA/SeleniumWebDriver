package support;

import com.github.javafaker.Faker;

public class MassaDados {
    private static final Faker FAKER = new Faker();

    public static String gerarNomeCompleto() {
        return FAKER.name().fullName();
    }

    public static String gerarEmail() {
        return FAKER.internet().emailAddress();
    }

    public static String gerarSenha() {
        return FAKER.internet().password(6, 15, true, true);
    }

}
