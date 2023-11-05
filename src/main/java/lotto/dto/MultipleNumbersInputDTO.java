package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MultipleNumbersInputDTO {
    private List<Integer> numbers;

    public MultipleNumbersInputDTO(String numbers) {
        this.numbers = convertToIntegerListIfValid(numbers);
    }

    public List<Integer> getParsingNumbers() {
        return numbers;
    }

    private int convertToIntegerIfValid(String input) {
        checkNullOrEmpty(input);

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    private List<Integer> convertToIntegerListIfValid(String input) {
        checkNullOrEmpty(input);

        List<Integer> numbers = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input,","); // 토큰이 비어있을 경우 자동으로 생략

        while (tokenizer.hasMoreTokens()) {
            int number = convertToIntegerIfValid(tokenizer.nextToken());
            numbers.add(number);
        }
        return numbers;
    }

    private void checkNullOrEmpty(String input) {
        if (input == null || input.replaceAll("\\s","").length() == 0) {
            throw new IllegalArgumentException("[ERROR] 입력이 존재하지 않습니다.");
        }
    }
}
