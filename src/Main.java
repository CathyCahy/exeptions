public class Main {
    public static void checkAuthorizing(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        String regex = "^[a-zA-Z0-9_]*$";
        if (login.length() > 20) {
            throw new WrongLoginException();
        }

        if (!login.matches(regex)) {
            throw new WrongLoginException();
        }
        if (password.length() > 20) {
            throw new WrongPasswordException();
        }
        if (!password.matches(regex)) {
            throw new WrongPasswordException();
        }
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException();
        }

    }

    public static void main(String[] args) {
        String login1 = "abcd123";
        String pass1 = "123456";
        String pass2 = "123457";
        try {
            checkAuthorizing(login1, pass1, pass2);
            System.out.println("Проверка пройдена!");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Проверка не пройдена!");
        }

    }
}