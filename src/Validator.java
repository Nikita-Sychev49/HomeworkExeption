import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Validator {

    private static final String ALLOWED_CHARS = "abcdefghijklmnopqrstuvwxyz0123456789_";

    public static void check(String login, String password, String confirmPassword) {
        if (login.length() > 20) {
            throw new WrongLoginExeption("Логин не может быть больше 20 символов");
        }
        if (!checkAlhabet(login)) {
            throw new WrongLoginExeption("Строка содержит недопустимые символы");
        }
        if (password.length() > 20) {
            throw new WrongPasswordExeption("Пароль не может быть больше 20 символов");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordExeption("Пароли не совпадают");
        }
        if (!checkAlhabet(password)) {
            throw new WrongPasswordExeption("Строка содержит недопустимые символы");
        }
    }

    private static boolean checkAlhabet(String str) {
        var lowerCase = str.toLowerCase();
        for (int i = 0; i < lowerCase.length(); i++) {
            var c = lowerCase.charAt(i);
                if (!ALLOWED_CHARS.contains(String.valueOf(c))) {
                    return false;
            }
        }
        return true;
    }
}
