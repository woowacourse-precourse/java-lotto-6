package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputPurchaseAmount() {
        String userLottoPurchaseAmount = Console.readLine();
        return userLottoPurchaseAmount;
    }

    public String inputWinningNumbers() {
        String lottoWinningNumbers = Console.readLine();
        return lottoWinningNumbers;
    }

    public String inputBonusNumber() {
        String lottoWinningBonusNumber = Console.readLine();
        return lottoWinningBonusNumber;
    }
}
