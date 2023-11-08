package lotto.domain;

public class NotValidBonusNumberSizeException extends IllegalArgumentException {

    public NotValidBonusNumberSizeException() {
        super("[ERROR] 보너스 번호는 1개를 입력해야 합니다.\n");
    }
}
