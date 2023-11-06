package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.Util;
import lotto.util.validator.BonusNumberValidator;
import lotto.util.validator.LottoValidator;
import lotto.util.validator.PurchaseLottoValidator;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    public int inputPurchaseLotto() {
        try {
            System.out.print(Message.INPUT_PURCHASE_LOTTO.message);
            String input = Console.readLine();
            new PurchaseLottoValidator().validate(input);
            return Util.convertStringToInt(input);
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception);
            return inputPurchaseLotto();
        }
    }

    public List<Integer> inputWinningNumber() {
        try {
            System.out.print(Message.INPUT_WINNING_NUMBER.message);
            String input = Console.readLine();
            new LottoValidator().validate(input);
            return Util.splitNumberByComma(input);
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception);
            return inputWinningNumber();
        }
    }

    public int inputBonusNumber() {
        try {
            System.out.print(Message.INPUT_BONUS_NUMBER.message);
            String input = Console.readLine();
            new BonusNumberValidator().validate(input);
            return Util.convertStringToInt(input);
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
