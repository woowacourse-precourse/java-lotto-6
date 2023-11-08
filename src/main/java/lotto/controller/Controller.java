package lotto.controller;

public class Controller {
    private boolean flag;
    private final User user;
    private final LottoCompany lottoCompany;

    public LottoController(User user, LottoCompany lottoCompany) {
        this.user = user;
        this.lottoCompany = lottoCompany;
    }

    private void inputMoney() {
        flag = false;
        while (!flag) {
            tryInputMoney();
        }
    }

    private void tryInputMoney() {
        try {
            input = InputView.inputMoney();
            int money = changeStringToInt(input);
            user.purchaseLotto(money);
            flag = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
