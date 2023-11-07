package lotto.view;

import static lotto.view.constants.ConstantMessage.NEW_LINE;
import static lotto.view.constants.ConstantMessage.REQUEST_BONUS_NUMBER;
import static lotto.view.constants.ConstantMessage.REQUEST_PURCHASE_AMOUNT;
import static lotto.view.constants.ConstantMessage.REQUEST_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.exception.LottoException;
import lotto.parser.Parser;
import lotto.view.constants.ConstantMessage;

public class InputView {
    public static int requestPurchaseAmount() {
        int ticketAmount;
        while (true) {
            try {
                ConstantMessage.printNotice(NEW_LINE);
                ConstantMessage.printNotice(REQUEST_PURCHASE_AMOUNT);
                String purchaseAmount = Console.readLine();
                ticketAmount = Parser.parsePurchaseAmount(purchaseAmount);
                break;
            } catch (LottoException e) {
                System.out.println(e.getMessage());
            }
        }
        return ticketAmount;
    }

    public static Lotto requestWinningNumbers() {
        Lotto winnigLotto;
        while (true) {
            try {
                ConstantMessage.printNotice(NEW_LINE);
                ConstantMessage.printNotice(REQUEST_WINNING_NUMBERS);
                String winningNumbers = Console.readLine();
                winnigLotto = Parser.parseWinningNumbers(winningNumbers);
                break;
            } catch (LottoException e) {
                System.out.println(e.getMessage());
            }
        }
        return winnigLotto;
    }

    public static int requestBonusNumber(Lotto winnigLotto) {
        int bonusLotto;
        while (true) {
            try {
                ConstantMessage.printNotice(NEW_LINE);
                ConstantMessage.printNotice(REQUEST_BONUS_NUMBER);
                String bonusNumber = Console.readLine();
                bonusLotto = Parser.parseBonusNumber(bonusNumber, winnigLotto);
                break;
            } catch (LottoException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusLotto;
    }
}
