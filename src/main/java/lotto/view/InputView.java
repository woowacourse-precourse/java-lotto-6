package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.Util;
import lotto.util.validator.PurchaseValidator;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    public int inputPurchaseLotto() {
        try {
            System.out.print(Message.INPUT_PURCHASE_LOTTO.message);
            String input = Console.readLine();
            new PurchaseValidator().validate(input);
            return Util.convertStringToInt(input);
        } catch (IllegalArgumentException exception) {
            OutputView.getInstance().printExceptionMessage(exception);
            return inputPurchaseLotto();
        }
    }

    public List<Integer> inputWinningNumber() {
        System.out.print(Message.INPUT_WINNING_NUMBER.message);
        return Util.splitNumberByComma(Console.readLine());
    }

    public int inputBonusNumber() {
        System.out.print(Message.INPUT_BONUS_NUMBER.message);
        return Util.convertStringToInt(Console.readLine());
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
