package lotto;

import java.io.Flushable;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_GAME_NUMBERS_SIZE = 6;
    private static final int LOTTO_GAME_START_NUMBER = 1;
    private static final int LOTTO_GAME_END_NUMBER = 45;
    private static final String SPACE = " ";
    private static final String NULL = "";
    private static final String COMMA = ",";
    private static final String LOTTO_WRONG_NUMBER_OF_VALUE = "[ERROR] 6개의 값을 쉼표로 구분하여 입력해주어야 합니다.";
    private static final String LOTTO_NEED_INPUT_NUMBER = "[ERROR] 1~45 사이의 숫자를 입력하셔야 합니다.";
    private static final String LOTTO_OUT_OF_RANGE = "[ERROR] 1~45 사이의 값을 입력해주십시오.";
    private static final String LOTTO_DUPLICATE_NUMVER = "[ERROR] 서로 다른 값을 입력해야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isSixNumber(numbers)) {
            throw new IllegalArgumentException(LOTTO_WRONG_NUMBER_OF_VALUE);
        } else if (!isRangeLotto(numbers)) {
            throw new IllegalArgumentException(LOTTO_OUT_OF_RANGE);
        } else if (isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_NUMVER);
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    //문자열에 있는 공백을 제거하고, 문자열을 검증하는 메서드
    public Lotto(String numbers){
        numbers = numbers.replace(SPACE,NULL);
        validateInputString(numbers);
        this.numbers = convetStringToIntegerList(splitComma(numbers));
    }

    // 문자열을 입력받았을때 유효성을 검증하여 오류가 있는지 확인하는 메서드
    private void validateInputString(String numbers){
        if (isStringEmpty(numbers)){
            throw new IllegalArgumentException(LOTTO_WRONG_NUMBER_OF_VALUE);
        } else if (!isDigit(splitComma(numbers))) {
            throw new IllegalArgumentException(LOTTO_NEED_INPUT_NUMBER);
        }

        validate(convetStringToIntegerList(splitComma(numbers)));
    }
    
    
    
    //입력값이 비어있는지 확인
    private boolean isStringEmpty(String numbers){
        return numbers == null || numbers.isBlank();
    }

    //모든 입력값이 숫자인지 확인
    private boolean isDigit(List<String> numbers){
        return numbers.stream().allMatch(number -> number.chars().allMatch(Character :: isDigit));
    }

    //선택한 숫자의 개수가 6개인지 확인
    private boolean isSixNumber(List<Integer>  numbers){
        return numbers.size() == LOTTO_GAME_NUMBERS_SIZE;
    }

    //쉼표(,)를 기준으로 입력된 숫자에서 심표(,)를 기준으로 나누어 리스트에 저장
    private List<String> splitComma(String numbers){
        return List.of(numbers.split(COMMA));
    }

    //쉼표를 제거한 문자열 리스트를 정수형 리스트로 변환하여 저장
    private List<Integer> convetStringToIntegerList(List<String> numbers){
        return numbers.stream().map(Integer :: parseInt).collect(Collectors.toList());
    }

    //1~45 사이의 숫자로 이루어져 있는지 확인
    private boolean isRangeLotto(List<Integer>  numbers){
        return numbers.stream().allMatch(number -> number >= LOTTO_GAME_START_NUMBER && number <= LOTTO_GAME_END_NUMBER);
    }

    //중복된 수가 없는지 확인 : 중복된 값들을 제거하고 카운트를 했을 때, 정해진 값과 개수가 맞는지 확인
    private boolean isDuplicateNumber(List<Integer> numbers){
        return numbers.size() != numbers.stream().distinct().count();
    }
}
