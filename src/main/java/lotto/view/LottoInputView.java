package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Money;

public class LottoInputView {
    private static final String COMMA = ",";
    private static final String INPUT_SHOULD_NOT_CHARACTER = "문자는 입력할 수 없습니다";

    public Money getLottoPurchase() {
        try {
            int amount = Integer.parseInt(Console.readLine());
            return new Money(amount);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(INPUT_SHOULD_NOT_CHARACTER);
        }
    }

    public List<Integer> getWinningNumbers() {
        String userInput = Console.readLine();

        try {
            return Arrays.stream(userInput.split(COMMA))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(INPUT_SHOULD_NOT_CHARACTER);
        }
    }

}
