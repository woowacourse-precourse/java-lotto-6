package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.IntegerUtil;
import lotto.util.Parser;
import lotto.model.Lotto;

public class InputView {
    public int inputPurchaseAmount() {
        System.out.println(InputMessage.purchaseAmount);

        int result = Parser.stringToInt(Console.readLine());

        System.out.println();
        return result;
    }

    public Lotto inputWinningNumber() {
        System.out.println(InputMessage.WINNING_NUMBER);

        Lotto result = Parser.stringToLotto(Console.readLine());

        System.out.println();
        return result;
    }

    public int inputBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER);

        int result = Parser.stringToInt(Console.readLine());

        try {
            IntegerUtil.checkRange(result);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return -1;
        }

        System.out.println();
        return result;
    }
}
