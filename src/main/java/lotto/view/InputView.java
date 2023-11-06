package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.UserAmount;
import lotto.domain.WinningBundle;
import lotto.domain.WinningNumber;
import lotto.utils.Split;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_BUNDLE_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static UserAmount getUserAmount() {
        String input = input(INPUT_PURCHASE_PRICE_MESSAGE);
        try {
            UserAmount userAmount = UserAmount.from(input);
            return userAmount;
        } catch (IllegalArgumentException ex) {
            OutputView.printError(ex.getMessage());
            return getUserAmount();
        }
    }

    public static WinningBundle getWinningBundle() {
        String input = input(INPUT_WINNING_BUNDLE_MESSAGE);
        List<String> splitInput = new Split(input).getListValue();

        try {
            List<WinningNumber> winningNumbers = splitInput.stream()
                    .map(s -> WinningNumber.from(s))
                    .toList();
            return WinningBundle.from(winningNumbers);
        } catch (RuntimeException ex) {
            OutputView.printError(ex.getMessage());
            return getWinningBundle();
        }

    }

    public static String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
