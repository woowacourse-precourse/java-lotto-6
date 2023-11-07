package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    private final InputController inputController = new InputController();

    public Integer getPurchaseQuantity(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return money / 1000;
    }

    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }
}
