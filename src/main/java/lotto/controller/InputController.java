package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoPurchasingAmount;
import lotto.view.OutputView;

public class InputController {
    public LottoPurchasingAmount getLottoPurchasingAmountFromUser() {
        OutputView.askLottoPurchasingAmount();
        try {
            return new LottoPurchasingAmount(Console.readLine());
        } catch (IllegalArgumentException e) {
            return getLottoPurchasingAmountFromUser();
        }
    }
}
