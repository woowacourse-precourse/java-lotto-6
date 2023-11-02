package lotto.validation;

public class Validation {
    public void validateNumber(String Input) {
        try {
            Integer.parseInt(Input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
    }

    public void validateUnit(String Input) {
        int payment = Integer.parseInt(Input);
        
        if(payment % 1000 != 0) {
            throw new IllegalArgumentException("입력값이 1,000원 단위가 아닙니다.");
        }
    }
}