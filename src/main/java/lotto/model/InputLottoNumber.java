package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputLottoNumber {

    private final List<Integer> inputNumber;

    public InputLottoNumber(String inputNumber) {
        validate(inputNumber);
        this.inputNumber = parseInputNumberToList(inputNumber);
    }

    public List<Integer> getInputNumber() {
        return inputNumber;
    }

    private void validate(String inputNumber) {
        if (inputNumber == null || inputNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 아무것도 입력하지 않았습니다.");
        }

        String[] numbersStr = inputNumber.split(",");
        if (numbersStr.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
        }

        Set<Integer> numbersSet = new HashSet<>();
        for (String numberStr : numbersStr) {
            int number;
            try {
                number = Integer.parseInt(numberStr.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자 외 문자를 입력하였습니다.");
            }

            // 1부터 45 사이의 숫자인지 확인합니다.
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1에서 45 사이여야 합니다.");
            }

            if (!numbersSet.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력하였습니다.");
            }
        }
    }

    private List<Integer> parseInputNumberToList(String inputNumber) {
        return Arrays.stream(inputNumber.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
