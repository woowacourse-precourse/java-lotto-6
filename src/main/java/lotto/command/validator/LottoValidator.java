package lotto.command.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidator implements Validator {
    @Override
    public void validate(String input) {
        List<String> inputSplit = toList(input);

        inputSplit.forEach(this::validateIsNumber);

        List<Integer> numbers = inputSplit.stream().map(Integer::parseInt).toList();
        validateCount(numbers);
        validateUnique(numbers);
        validateOverNumber(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하세요");
        }
    }

    private List<String> toList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateIsNumber(String input) {
        if(isNotNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private boolean isNotNumeric(String str) {
        return !str.chars().allMatch(Character::isDigit);
    }

    private void validateUnique(List<Integer> numbers) {
        int uniqueCount = (int) numbers.stream().distinct().count();
        if(uniqueCount != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 번호만 입력 가능합니다.");
        }
    }

    private void validateOverNumber(List<Integer> numbers) {
        numbers.forEach(number -> {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        });
    }
}
