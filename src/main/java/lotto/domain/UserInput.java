package lotto.domain;

import lotto.ui.InputView;

import java.util.List;

public class UserInput {
    private String cost;
    private int amount;
    private List<Integer> prizeLotto;
    public UserInput() {
    }

    public void setAmount() {
        try {
            this.cost = InputView.readCost();
            Validator validator = new Validator();
            this.amount = validator.validateCost(this.cost);
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
