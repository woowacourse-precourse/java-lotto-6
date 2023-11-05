package lotto.domain;

import lotto.ui.InputView;

import java.util.List;

public class UserInput {
    private int amount;
    private List<Integer> prizeLotto;
    public UserInput() {
    }

    public void setAmount() {
        try {
            String cost = InputView.readCost();
            Validator validator = new Validator();
            validator.validateCost(cost);
            amount = Integer.parseInt(cost) / 1000;
        } catch (IllegalArgumentException illegalArgumentException) {
            setAmount();
        }
    }

    public int getAmount() {
        return amount;
    }

    public void setPrizeLotto() {
        try{
            String numbers = InputView.readNumbers();
            String bonusNumber = InputView.readBonusNumber();
            // 검증
        } catch (IllegalArgumentException illegalArgumentException) {
            setPrizeLotto();
        }
    }
    public List<Integer> getPrizeLotto() {
        return this.prizeLotto;
    }
}
