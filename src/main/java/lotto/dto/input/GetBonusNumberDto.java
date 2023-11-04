package lotto.dto.input;

public class GetBonusNumberDto {
    private final int bonusNumber;

    public int getBonusNumber() {
        return bonusNumber;
    }

    public GetBonusNumberDto(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

}
