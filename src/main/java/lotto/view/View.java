package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.LottoGame;
import lotto.model.Validator;

public class View {

    public enum ErrorMessage {
        INVALID_NUMBER("유효한 숫자를 입력해주세요."),
        NOT_POSITIVE("양의 정수를 입력해주세요"),
        BELOW_MINIMUM_AMOUNT("로또 가격보다 큰 값을 입력해주세요"),
        INVALID_FORMAT("올바른 방식으로 입력해주세요"),
        INCORRECT_NUMBER_COUNT("6개의 수를 입력해주세요"),
        INVALID_RANGE("1~45 사이의 숫자만 입력해주세요."),
        DUPLICATE_NUMBER("중복된 숫자는 입력할 수 없습니다."),
        BONUS_INCORRECT_COUNT("1개의 수만 입력해주세요");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private static final String ERROR_PREFIX = "[ERROR] ";

    public static int getPurchaseAmount() {
        while (true) {
            try {
                return LottoGame.attemptToGetPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                return LottoGame.attempToGetWinningNumbers();
            } catch (IllegalArgumentException e) {
                printErrorMessage(ErrorMessage.valueOf(e.getMessage()));
            }
        }
    }


    public static int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                return LottoGame.attemptToGetBonusNumber(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }





    private static void validateWinningNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.name());
        }
    }


    private static void validateBonusNumber(int number, Set<Integer> winningNumbers) {
        validateWinningNumber(number); // Reuse the validation for winning numbers
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.name());
        }
    }

    private static void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE.name());
        }
        if (amount < 1000) { // 로또 가격이 1000원이라고 가정
            throw new IllegalArgumentException(ErrorMessage.BELOW_MINIMUM_AMOUNT.name());
        }
    }


    private static void printErrorMessage(ErrorMessage errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage.getMessage());
    }

}
