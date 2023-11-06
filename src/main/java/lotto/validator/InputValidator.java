package lotto.validator;

public class InputValidator {
    private boolean isNotInteger(String number) {
        try {
            Integer.parseInt(number);
            return false;
        } catch (NumberFormatException ex) {
            return true;
        }
    }

    public void checkInteger(String number) {
        if(isNotInteger(number)) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력 해야 합니다.");
        }
    }

    //,로 구분됐는지

    //, 제외 숫자만 입력에 있는지

    // 중복이 있는지
}
