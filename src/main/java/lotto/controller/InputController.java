package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoPurchasingAmount;

public class InputController {
    public LottoPurchasingAmount getLottoPurchasingAmountFromUser() {
        return new LottoPurchasingAmount(Console.readLine());
    }
}
