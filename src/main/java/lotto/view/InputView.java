package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_PURCHASE_AMOUNT = 1000;
    public static final int MAX_PURCHASE_AMOUNT = 1000000;
    public static final int MIN_INPUT_ANSWER_LENGTH = 11;
    public static final int MAX_INPUT_ANSWER_LENGTH = 17;
    public static final String VALIDATE_CONTAIN_WHITE_SPACE_MESSAGE = "[ERROR] 공백이 없는 값이어야 합니다.";
    public static final String VALIDATE_STRING_TO_INT_MESSAGE = "[ERROR] 입력 값은 유효한 범위의 숫자여야 합니다.";

    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public void validatePurchaseAmount(String purchaseAmount) {
        if (purchaseAmount.contains(" ")) {
            throw new IllegalArgumentException(VALIDATE_CONTAIN_WHITE_SPACE_MESSAGE);
        }
        try {
            if (Integer.parseInt(purchaseAmount) % MIN_PURCHASE_AMOUNT != 0) {
                throw new IllegalArgumentException("[ERROR] 입력 값은 1,000의 배수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALIDATE_STRING_TO_INT_MESSAGE);
        }
        int purchaseAmountNumber = Integer.parseInt(purchaseAmount);
        if (purchaseAmountNumber < MIN_PURCHASE_AMOUNT || purchaseAmountNumber > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 1,000이상, 1,000,000이하의 숫자여야 합니다.");
        }
    }

    public List<Integer> inputAnswerNumber() {
        String inputAnswer = Console.readLine();
        validateInputAnswer(inputAnswer);

        List<Integer> answerNumber = validateAnswerNumber(inputAnswer);
        validateAnswerNumberRange(answerNumber);

        Collections.sort(answerNumber);

        return answerNumber;
    }

    public void validateInputAnswer(String inputAnswer) {
        if (inputAnswer.contains(" ")) {
            throw new IllegalArgumentException(VALIDATE_CONTAIN_WHITE_SPACE_MESSAGE);
        }
        if (inputAnswer.startsWith(",") || inputAnswer.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 쉼표로 시작하거나 끝나면 안됩니다.");
        }
        if (inputAnswer.length() < MIN_INPUT_ANSWER_LENGTH || inputAnswer.length() > MAX_INPUT_ANSWER_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 잘못된 범위의 입력입니다.");
        }
        if (!inputAnswer.matches("^[^,]+(,[^,]+){5}$")) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
    }

    public List<Integer> validateAnswerNumber(String inputAnswer) {
        String[] inputAnswerPart = inputAnswer.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String part : inputAnswerPart) {
            try {
                int inputNumber = Integer.parseInt(part.trim());
                numbers.add(inputNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(VALIDATE_STRING_TO_INT_MESSAGE);
            }
        }

        return numbers;
    }

    public void validateAnswerNumberRange(List<Integer> answerNumber) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : answerNumber) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자입니다.");
            }
        }
    }

    public int inputBonusNumber(List<Integer> answerNumber) {
        String inputBonus = Console.readLine();
        validateBonusNumber(answerNumber, inputBonus);
        return Integer.parseInt(inputBonus);
    }

    public void validateBonusNumber(List<Integer> answerNumber, String inputBonus) {
        if (inputBonus.contains(" ")) {
            throw new IllegalArgumentException(VALIDATE_CONTAIN_WHITE_SPACE_MESSAGE);
        }
        try {
            int bonusNumber = Integer.parseInt(inputBonus);
            if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            Set<Integer> uniqueNumbers = new HashSet<>(answerNumber);
            if (!uniqueNumbers.add(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 숫자입니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALIDATE_STRING_TO_INT_MESSAGE);
        }
    }
}
