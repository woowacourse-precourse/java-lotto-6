package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class WinningNumber {
    private static final String LENGTH_ERROR_MESSAGE = "[ERROR]:6개의 번호를 입력해주세요";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR]:중복된 값을 입력하면 안됩니다";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR]:값이 1~45사이여야 합니다";
    private static final int LOTTO_GAME_START_NUMBER = 1;
    private static final int LOTTO_GAME_END_NUMBER = 45;
    //private Lotto lotto;
    private List<Integer> numbers;
    public WinningNumber(String inputNumbers) {
        validate(inputNumbers);
        this.numbers = convertStringListToIntegerList(convertStringToList(inputNumbers));
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    private List<Integer> convertStringListToIntegerList(List<String> inputNumbers) {
        return inputNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private void validate(String inputNumbers) {
        validateDuplicate(inputNumbers);
        validateLength(inputNumbers);
        validateRange(inputNumbers);
    }

    private void validateRange(String inputNumbers) {
        List<Integer> lottoNumber = convertStringListToIntegerList(convertStringToList(inputNumbers));
        if(!isBetweenLottoRange(lottoNumber)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicate(String randomNumbers) {
        boolean duplicated = randomNumbers.chars().distinct().count() != randomNumbers.length();
        if(duplicated) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
    private static void validateLength(String inputNumbers) {
        if (inputNumbers.length()!=0){
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }
    private boolean isBetweenLottoRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number ->
                number >= LOTTO_GAME_START_NUMBER && number <= LOTTO_GAME_END_NUMBER);
    }
    private List<String> convertStringToList(String numbers) {
        return List.of(numbers.split(","));
    }


}
