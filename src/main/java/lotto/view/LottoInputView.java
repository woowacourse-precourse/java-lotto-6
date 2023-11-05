package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class LottoInputView {
    private static final String COMMA = ",";
    private static final String INPUT_SHOULD_NOT_CHARACTER = "문자는 입력할 수 없습니다";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public Money getLottoPurchase() {
        try {
            int amount = Integer.parseInt(Console.readLine());
            return new Money(amount);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(INPUT_SHOULD_NOT_CHARACTER);
        }
    }

    public List<Integer> getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        String userInput = Console.readLine();

        try {
            return Arrays.stream(userInput.split(COMMA))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(INPUT_SHOULD_NOT_CHARACTER);
        }
    }

    public int getBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String userInput = Console.readLine();

        try {
            int parsedInput = Integer.parseInt(userInput);
            validateBonusInput(parsedInput);
            return parsedInput;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(INPUT_SHOULD_NOT_CHARACTER);
        }
    }

    private void validateBonusInput(int input) {
        if (input < Lotto.LOTTO_LOWER_BOUND || Lotto.LOTTO_UPPER_BOUND < input) {
            throw new IllegalArgumentException(Lotto.LOTTO_NUMBER_BOUNDARY_ERROR);
        }
    }

}
