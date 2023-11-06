package lotto.exception;

public class InputException {

    public void validateInputAmount(String amount) {
        if(!amount.matches("^[0-9]*$"))
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
    }

    public void validateUnit(String amount) {
        if(Integer.parseInt(amount)%1000!=0)
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
    }
}
