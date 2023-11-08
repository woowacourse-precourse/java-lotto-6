package lotto;

public class ThrowNewException {
    private String amountError = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";

    public void amountException(){
        throw new IllegalArgumentException(amountError);
    }
}
