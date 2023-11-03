package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;
import lotto.domain.Amount;
import lotto.domain.Number;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static final String NUMBERS_DELIMITER = ",";

    public static Amount inputAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.\n");
            int amount = Integer.parseInt(Console.readLine());
            return new Amount(amount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER.message());
        }
    }

    public static WinningLotto inputWinningLotto() {
        try {
            List<Number> numbers = inputWinningNumbers();
            Number bonus = inputBonusNumber();
            return new WinningLotto(numbers, bonus);

        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER.message());
        }
    }

    private static List<Number> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.\n");
        String numbers = Console.readLine();
        return Arrays.stream(numbers.split(NUMBERS_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Number::from)
                .toList();
    }

    private static Number inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.\n");
        String bonus = Console.readLine();
        return Number.from(Integer.parseInt(bonus));
    }
}
