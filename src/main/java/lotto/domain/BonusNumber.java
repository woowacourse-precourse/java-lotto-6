package lotto.domain;

public class BonusNumber {
    private final int number;

    public BonusNumber(String number) {
        verification(number);
        this.number = Integer.parseInt(number);
    }

    public boolean bonusNumberMatch(Lotto lotto) {
        return lotto.getNumbers().contains(number);
    }

    private void verification(String number) {
        isNullBonusNumber(number);
        isValidBonusNumber(number);
        isBonusNumberInRange(number);
    }

    private void isNullBonusNumber(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해 주세요.\n");
        }
    }

    private void isValidBonusNumber(String number) {
        if (number.matches(".*[^0-9].*")) {
            throw new IllegalArgumentException("[ERROR] 보너스 넘버는 숫자만 입력할 수 있습니다.\n");
        }
    }

    private void isBonusNumberInRange(String number) {
        if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 넘버는 1~45 사이의 숫자만 입력할 수 있습니다.\n");
        }
    }
}