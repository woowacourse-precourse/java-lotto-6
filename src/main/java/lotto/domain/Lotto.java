package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]:6개의 번호를 입력해주세요");
        }
        validateDuplicateInteger(numbers);
        validateRangeInteger(numbers);
    }

    private void validateRangeInteger(List<Integer> numbers) {
        if (!isBetweenLottoRange(numbers)) {
            throw new IllegalArgumentException("[ERROR]:값이 1~45사이여야 합니다");
        }
    }


    private void validateDuplicateInteger(List<Integer> numbers) {
        if (isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR]:중복된 값을 입력하면 안됩니다");
        }
    }


    private boolean isDuplicateNumber(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }
    // TODO: 추가 기능 구현

    public Lotto(String numbers) {
        numbers = numbers.replace(" ", "");
        validateString(numbers);
        this.numbers = convertStringListToIntegerList(convertStringToList(numbers));
    }


    public List<Integer> getLotto() {
        return numbers;
    }

    private List<Integer> convertStringListToIntegerList(List<String> inputNumbers) {
        return inputNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private void validateString(String inputNumbers) {
        validateDuplicate(inputNumbers);
        validateRange(inputNumbers);
    }

    private void validateRange(String inputNumbers) {
        List<Integer> lottoNumber = convertStringListToIntegerList(convertStringToList(inputNumbers));
        if (!isBetweenLottoRange(lottoNumber)) {
            throw new IllegalArgumentException("[ERROR]:값이 1~45사이여야 합니다");
        }
    }

    private void validateDuplicate(String randomNumbers) {
        List<Integer> lottoNumbers = convertStringListToIntegerList(convertStringToList(randomNumbers));
        boolean duplicated = lottoNumbers.stream().distinct().count() != lottoNumbers.size();
        if (duplicated) {
            throw new IllegalArgumentException("[ERROR]:중복된 값을 입력하면 안됩니다");
        }
    }

    private boolean isBetweenLottoRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number ->
                number >= 1 && number <= 45);
    }

    private List<String> convertStringToList(String numbers) {
        return List.of(numbers.split(","));
    }

}
