package lotto;

public class Application {
    public static void main(String[] args) {
        startLotto();
    }

    private static void startLotto() {
        User user = new User();
        int money = user.inputAmountOfMoney();
    }
}
