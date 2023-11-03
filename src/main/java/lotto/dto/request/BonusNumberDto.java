package lotto.dto.request;

public class BonusNumberDto {
    private final int bonusNumber;

    public BonusNumberDto(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
