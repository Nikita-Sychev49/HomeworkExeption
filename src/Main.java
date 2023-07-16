public class Main {
    public static void main(String[] args) {
        try {
            Validator.check("ab23234324234", "123", "123");
        } catch (WrongLoginExeption | WrongPasswordExeption e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("Блок finally в любом случае выполняется");
        }
        System.out.println("Поздравляю, регистрация завершена!");
    }
}