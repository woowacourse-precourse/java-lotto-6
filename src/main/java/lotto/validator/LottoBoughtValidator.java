package lotto.validator;

public class LottoBoughtValidator implements BasicValidator<String>{
    @Override
    public void validate(String input) {
        isInputEmpty(input);
        isThousandMul(input);
    }

    public void isInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
    }

    public void isThousandMul(String input) {
        int lottoBought1000 = Integer.parseInt(input) % 1000;
        if (lottoBought1000 != 0) {
            throw new IllegalArgumentException("1,000원 단위로 입력해 주세요.");
        }
    }
}
