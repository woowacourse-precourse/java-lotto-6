package lotto;

public class LottoNumber {

    private final static String IMPOSSIBLE_TO_CONVERT_TO_INTEGER_ERROR_MESSAGE = "[ERROR] 입력하신 번호는 정수로 변환할 수 없습니다";
    private final static String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final static Integer LOTTO_FIRST_NUMBER = 1;
    private final static Integer LOTTO_FINAL_NUMBER = 45;

    public LottoNumber(String[] winNumbers) {
        for(String winNumber : winNumbers) {
            validateInteger(winNumber);
            validateRange(Integer.parseInt(winNumber));
        }
    }

    public LottoNumber(String bonusNumber) {
        validateInteger(bonusNumber);
        validateRange(Integer.parseInt(bonusNumber));
    }

    private void validateInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IMPOSSIBLE_TO_CONVERT_TO_INTEGER_ERROR_MESSAGE);
        }
    }

    private void validateRange(Integer number) {
        if(!(LOTTO_FIRST_NUMBER <= number && number <= LOTTO_FINAL_NUMBER)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }
}
