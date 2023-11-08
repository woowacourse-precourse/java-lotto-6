package lotto;

public class ThrowNewException {
    private String error = "[ERROR] ";
    private String amountError = "구입 금액은 1,000원 단위로 입력해야 합니다.";
    private String sizeError = "당첨 번호는 6자리로 입력해야 합니다.";
    private String rangeError = "숫자 범위는 1~45까지 입니다.";
    private String overlapError = "중복되지않는 숫자를 입력해야 합니다.";

    public void amountException(){
        throw new IllegalArgumentException(error+amountError);
    }

    public void sizeException(){
        throw new IllegalArgumentException(error+sizeError);
    }

    public void rangeException(){
        throw new IllegalArgumentException(error+rangeError);
    }

    public void overlapException(){
        throw new IllegalArgumentException(error+overlapError);
    }
}
