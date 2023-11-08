package lotto.controller;

import java.util.ArrayList;
import java.util.List;

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

    private void inputPrizeNumbers() {
        flag = false;
        while (!flag) {
            tryInputPrizeNumbers();
        }
    }

    private void tryInputPrizeNumbers() {
        try {
            input = InputView.inputPrizeNumber();
            setPrizeNumbers(input);
            flag = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setPrizeNumbers(String input) {
        List<String> splitString = StringUtil.splitWithComma(input);
        List<Integer> prizeNumbers = new ArrayList<Integer>();
        for (String string : splitString) {
            prizeNumbers.add(changeStringToInt(string));
        }
        lottoCompany.setPrizeNumbers(prizeNumbers);
    }
}
