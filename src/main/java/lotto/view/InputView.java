package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.validator.PurchaseLottoValidator;
import lotto.util.Util;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    public int inputPurchaseLotto() {
        try {
            System.out.print(Message.INPUT_PURCHASE_LOTTO.message);
            int purchase = Util.convertStringToInt(Console.readLine());
            new PurchaseLottoValidator().validate(purchase);
            return purchase;
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception);
            return inputPurchaseLotto();
        }
    }

    public List<Integer> inputWinningNumber() {
        try {
            System.out.print(Message.INPUT_WINNING_NUMBER.message);
            List<Integer> winnings = Util.splitNumberByComma(Console.readLine());
            return winnings;
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception);
            return inputWinningNumber();
        }
    }

    public int inputBonusNumber() {
        try {
            System.out.print(Message.INPUT_BONUS_NUMBER.message);
            int bonus = Util.convertStringToInt(Console.readLine());
            return bonus;
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception);
            return inputBonusNumber();
        }
    }

    private void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    private enum Message {
        INPUT_PURCHASE_LOTTO("구입금액을 입력해 주세요.\n"),
        INPUT_WINNING_NUMBER("\n당첨 번호를 입력해 주세요.\n"),
        INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.\n");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
