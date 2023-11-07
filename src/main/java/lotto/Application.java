package lotto;

public class Application {
    public static void main(String[] args) {
        UserData userData = new UserData();

        userData.inputMoney();
        System.out.println(userData.money);
    }
}
