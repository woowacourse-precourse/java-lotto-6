package lotto.controller;

import lotto.message.ErrorMessage;
import lotto.model.GameMoney;
import lotto.view.InputView;

public class GetBuyNumberImpl implements GetBuyNumber {

    private final InputView inputView;

    public GetBuyNumberImpl(InputView inputView) {
        this.inputView = inputView;
    }

    public GameMoney getBuyNumber() {
        boolean validInput = false;
        GameMoney gameMoney;
        do {
            try {
                String money = inputView.inputMoney();
                gameMoney = getValid(money);
                validInput = true;
                return gameMoney;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!validInput);

        return null;
    }

    public GameMoney getValid(String money) {
        int moneyNum;

        try {
            moneyNum = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.toString());
        }
        if (moneyNum <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NATURAL_NUM.toString());
        }
        if (moneyNum % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_THOUSANDS_UNIT.toString());
        }
        return new GameMoney(moneyNum);
    }

}
