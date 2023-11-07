package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import common.Convert;
import java.util.List;
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
}
