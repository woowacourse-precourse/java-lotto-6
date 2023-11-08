package lotto.exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoException {
    private final static int PERMITTED_LOTTO_LENGTH = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;

    public void validateCorrectNumbers(String input) {
        validateSizeIsCorrect(input);
        validateCorrectNumberPermitted(input);
        validateOverlap(input);
    }

    public void validateBonusNumber(String input, List<Integer> numbers) {
        validateBonusNumberIsNumber(input);
        validateIsBonusNumberPermittedRange(input);
        validateIsOverlapInCorrectNumbers(input, numbers);
    }

    public void validateBonusNumberIsNumber(String input) {
        for(int i=0; i<input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))) {
                exception("숫자로만 이뤄져야합니다.");
            }
        }
    }

    public void validateIsBonusNumberPermittedRange(String input) {
        int bonusNumber = Integer.parseInt(input);
        if(!(bonusNumber >= MIN_LOTTO_NUMBER && bonusNumber <= MAX_LOTTO_NUMBER)) {
            exception("1~45의 수를 입력해주세요.");
        }
    }

    public void validateIsOverlapInCorrectNumbers(String input, List<Integer> numbers) {
        int bonusNumber = Integer.parseInt(input);
        if(numbers.contains(bonusNumber)) {
            exception("보너스 번호가 중복됩니다.");
        }
    }

    private void validateSizeIsCorrect(String input) {
        if (input.split(",").length != PERMITTED_LOTTO_LENGTH) {
            exception("로또의 번호는 6개입니다.");
        }
    }

    private void validateCorrectNumberPermitted(String input) {
        String[] numbers = input.split(",");
        for (String number : numbers) {
            checkIsContainedOnlyNumber(number);
            checkIsNumberPermittedRange(number);
        }
    }

    private void checkIsContainedOnlyNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                exception("숫자로만 이뤄져야합니다.");
            }
        }
    }

    private void validateOverlap(String input) {
        String[] numbers = input.split(",");
        Set<String> overlap = new HashSet<>();
        Arrays.stream(numbers).map(number -> overlap.add(number)).collect(Collectors.toList());
        if(overlap.size() != PERMITTED_LOTTO_LENGTH) {
            exception("중복된 수가 있으면 안됩니다.");
        }
    }

    private void checkIsNumberPermittedRange(String number) {
        int num = Integer.valueOf(number);
        if (!(num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER)) {
            exception("1~45의 수로 이뤄져야 합니다.");
        }
    }

    private void exception(String message) {
        throw new IllegalArgumentException(message);
    }
}
