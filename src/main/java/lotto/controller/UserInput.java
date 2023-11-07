package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoTicketMoney;
import lotto.view.ConsoleView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {
    private static final String DOUBLE_NUMBER = "보너스 숫자는 당첨 숫자에 포함될 수 없습니다.";

    public static LottoTicketMoney inputPrice() {
        while (true) {
            try {
                ConsoleView.printPriceExplanation();
                return new LottoTicketMoney(Integer.parseInt(readLine()));
            } catch (IllegalArgumentException illegalArgumentException) {
                ConsoleView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    public static Lotto inputWinningLotto() {
        while (true) {
            try {
                ConsoleView.printWinningNumberExplanation();
                return new Lotto(readLine());
            } catch (IllegalArgumentException illegalArgumentException) {
                ConsoleView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    public static BonusNumber inputBonusNumber(Lotto winningNumbers) {
        BonusNumber bonusNumber = validateBonusNumber(readLine());
        validateDoubledWinningNumbers(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static BonusNumber validateBonusNumber(String inputCommand) {
        ConsoleView.printBonusNumberExplanation();
        return new BonusNumber(inputCommand);
    }

    private static void validateDoubledWinningNumbers(BonusNumber bonusNumber, Lotto winningNumbers) {
        if (winningNumbers.isBonus(bonusNumber))
            throw new IllegalStateException(DOUBLE_NUMBER);
    }
}
