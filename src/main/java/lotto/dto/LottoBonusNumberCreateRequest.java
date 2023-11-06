package lotto.dto;

public class LottoBonusNumberCreateRequest {
    private int bonusNumber;

    public LottoBonusNumberCreateRequest(String bonusNumber) {
        try {
            this.bonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
