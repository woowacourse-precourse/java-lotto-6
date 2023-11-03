package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.view.Input;

public class Game {
    public void start() {
        int amount = Input.readAmount();
        System.out.println(amount);
    }
}
