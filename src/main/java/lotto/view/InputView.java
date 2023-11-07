package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.Convert;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyAmount;

public class InputView {

    public static Integer getBuyAmount() {
        String inputAmountSrc = Console.readLine();
        int inputAmount = Convert.stringToInteger(inputAmountSrc);
        return LottoBuyAmount.getAmount(inputAmount);
    }

    public static List<Integer> getWinningNumber() {
        String winningString = Console.readLine();
        List<Integer> winningNumbers = Convert.splitByComma(winningString);
        Lotto winningNumber = new Lotto(winningNumbers);
        return winningNumbers;
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        String inputBonusNumber = Console.readLine();
        int bonusNumber = Convert.stringToInteger(inputBonusNumber);
        return BonusNumber.getBonusNumber(bonusNumber, winningNumbers);
    }
}
