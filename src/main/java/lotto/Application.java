package lotto;

public class Application {
    public static void main(String[] args) {
        startLotto();
    }

    private static void startLotto() {
        User user = new User();
        Global global = new Global();

        int money = user.inputAmountOfMoney();
        int lottoCount = global.getLottoCount(money);
        global.getIssuedLottoList(lottoCount);
        global.printIssuedLottoCountAndList();
    }
}
