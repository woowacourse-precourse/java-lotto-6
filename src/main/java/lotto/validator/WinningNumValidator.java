package lotto.validator;

import java.util.List;

public class WinningNumValidator {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String ERROR = "[ERROR]";
    private static final String NOT_BLANK_ERROR_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자만 입력해 주세요.";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 숫자를 적으면 안 됩니다.";
    private static final String SIZE_OVER_MESSAGE = "6개의 번호를 입력해 주세요.";
    private static final String RANGE_OVER_MESSAGE = "1~45사이의 번호를 입력해 주세요.";
    private static final String IS_DIVISION_COMMA_MESSAGE = "숫자는 쉼표(,) 단위로 나눠주세요";

    public WinningNumValidator(String input){
        isNull(input);
        isDivisionComma(input);
        for(String number : input.split(",")) {
            isNumError(number);
        }
    }

    public WinningNumValidator(List<Integer> numbers){
        isDuplicate(numbers);
        isSizeError(numbers);
        isRangeOver(numbers);
    }

    public void isNull(String number){
        if (number.equals("")) {
            throw new IllegalArgumentException(ERROR + NOT_BLANK_ERROR_MESSAGE);
        }
    }

    public void isDivisionComma(String number) {
        for (char c : number.toCharArray()) {
            if (!(Character.isLetterOrDigit(c) || c == ',')) {
                throw new IllegalArgumentException(ERROR + IS_DIVISION_COMMA_MESSAGE);
            }
        }
    }

    public void isNumError(String number){
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public void isSizeError(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR + SIZE_OVER_MESSAGE);
        }
    }

    public void isRangeOver(List<Integer> numbers) {
        for(Integer number : numbers){
            if (number>MAX_NUM || number<MIN_NUM){
                throw new IllegalArgumentException(ERROR + RANGE_OVER_MESSAGE);
            }
        }
    }

    public void isDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()){
            throw new IllegalArgumentException(ERROR + DUPLICATE_ERROR_MESSAGE);
        }
    }
}
