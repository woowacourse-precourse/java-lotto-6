package lotto.validator;

public class InputValidator {

    public void checkAmount(String amountInput) {
        checkAmountNum(amountInput);
    }

    //숫자인지 확인
    private void checkAmountNum(String amountInput) {
        for (int i = 0; i < amountInput.length(); i++) {
            char c = amountInput.charAt(i);
            if (!Character.isDigit(c)) {
                System.out.println("[ERROR] 로또 구입 금액은 숫자만 입력하세요.");
                throw new IllegalArgumentException();
            }
        }
    }
    //1000으로 나누어떨어지는지 확인

    //양수인지 확인



}
