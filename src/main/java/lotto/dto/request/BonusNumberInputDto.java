package lotto.dto.request;

public class BonusNumberInputDto {

    private final int bonus;

    private BonusNumberInputDto(int bonus) {
        this.bonus = bonus;
    }

    public static BonusNumberInputDto from(int bonus) {
        return new BonusNumberInputDto(bonus);
    }

    public int getBonus() {
        return bonus;
    }
}
