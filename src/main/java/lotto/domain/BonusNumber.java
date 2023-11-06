package lotto.domain;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(String bonusNumber) {
        isInteger(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public void isInteger(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                System.out.println("[ERROR] 숫자만 입력해주시기 바랍니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
