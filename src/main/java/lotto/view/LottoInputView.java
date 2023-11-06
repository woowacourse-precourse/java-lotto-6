package lotto.view;

import static lotto.util.RandomLottoNumberGenerator.LOTTO_LOWER_BOUND;
import static lotto.util.RandomLottoNumberGenerator.LOTTO_UPPER_BOUND;
import static lotto.view.LottoView.ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class LottoInputView {
    private static final String LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String COMMA = ",";
    private static final String INPUT_SHOULD_NOT_CHARACTER = "문자는 입력할 수 없습니다.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public Money getLottoPurchase() {
        System.out.println(LOTTO_PURCHASE_MESSAGE);
        try {
            int amount = Integer.parseInt(Console.readLine());
            return new Money(amount);
        } catch (NumberFormatException nfe) {
            System.out.println(ERROR + INPUT_SHOULD_NOT_CHARACTER);
            return null;
        } catch (IllegalArgumentException ie) {
            System.out.println(ERROR + ie.getMessage());
            return null;
        }
    }

    public List<Integer> getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        String userInput = Console.readLine();
        String[] splittedUserInput = userInput.split(COMMA);
        try {
            validateWinningNumbersInput(splittedUserInput);
            return Arrays.stream(splittedUserInput)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException nfe) {
            System.out.println(ERROR + INPUT_SHOULD_NOT_CHARACTER);
            return Collections.emptyList();
        } catch (IllegalArgumentException ie) {
            System.out.println(ERROR + ie.getMessage());
            return Collections.emptyList();
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
            System.out.println(ERROR + INPUT_SHOULD_NOT_CHARACTER);
            return 0;
        } catch (IllegalArgumentException ie) {
            System.out.println(ERROR + ie.getMessage());
            return 0;
        }
    }

    private void validateBonusInput(int input) {
        if (isNotValidLottoNumber(input)) {
            throw new IllegalArgumentException(Lotto.LOTTO_NUMBER_BOUNDARY_ERROR);
        }
    }

    private void validateWinningNumbersInput(String[] splittedUserInput) {
        boolean isValidNumbers = Arrays.stream(splittedUserInput)
                .map(Integer::parseInt)
                .noneMatch(this::isNotValidLottoNumber);

        if (!isValidNumbers) {
            throw new IllegalArgumentException(Lotto.LOTTO_NUMBER_BOUNDARY_ERROR);
        }
    }

    private boolean isNotValidLottoNumber(int input) {
        return input < LOTTO_LOWER_BOUND || LOTTO_UPPER_BOUND < input;
    }

}
