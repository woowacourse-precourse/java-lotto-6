package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoTicketMoney;
import lotto.view.ConsoleView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {
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

    public static BonusNumber inputBonusNumber() {
        while (true) {
            try {
                ConsoleView.printBonusNumberExplanation();
                return new BonusNumber(readLine());
            } catch (IllegalArgumentException illegalArgumentException) {
                ConsoleView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }
}
