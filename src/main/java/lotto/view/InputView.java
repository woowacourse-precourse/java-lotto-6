package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.util.StringUtils;

public class InputView {
    private InputView() {

    }

    public static Money inputMoney() {
        while (true) {
            try {
                OutputView.printLottoPurchaseMessage();
                String inputMoney = Console.readLine();
                StringUtils.validateBlank(inputMoney);
                OutputView.printLineSeparator();

                return new Money(inputMoney);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    public static Lotto inputWinningLottoNumbers() {
        while (true) {
            try {
                OutputView.printWinningNumberMessage();
                String inputLottoNumbers = Console.readLine();
                StringUtils.validateBlank(inputLottoNumbers);
                OutputView.printLineSeparator();

                return new Lotto(StringUtils.convertNumbersStringToList(inputLottoNumbers));
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    public static BonusNumber inputBonusNumber() {
        while (true) {
            try {
                OutputView.printBonusNumberMessage();
                String inputBonusNumber = Console.readLine();
                StringUtils.validateBlank(inputBonusNumber);
                OutputView.printLineSeparator();

                return new BonusNumber(inputBonusNumber);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    public static void close() {
        Console.close();
    }
}
