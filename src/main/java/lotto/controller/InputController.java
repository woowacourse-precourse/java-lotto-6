package lotto.controller;

import java.util.List;
import lotto.model.Input;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.view.InputView;

public class InputController {

    public Money readMoney() {
        Money money;
        try {
            Input input = new Input(InputView.readMoney());
            money = input.ofMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            money = readMoney();
        }
        return money;
    }

    public Lotto readLotto() {
        Lotto lotto;
        try {
            Input input = new Input(InputView.readLotto());
            lotto = new Lotto(input.ofNums());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lotto = readLotto();
        }
        return lotto;
    }

    public Integer readBonus(List<Integer> nums) {
        int bonus;
        try {
            Input input = new Input(InputView.readBonus());
            bonus = input.ofBonus(nums);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonus = readBonus(nums);
        }
        return bonus;
    }
}
