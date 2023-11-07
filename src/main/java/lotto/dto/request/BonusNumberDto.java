package lotto.dto.request;

public class BonusNumberDto {

    private final int bonus;

    private BonusNumberDto(int bonus) {
        this.bonus = bonus;
    }

    public static BonusNumberDto from(int bonus) {
        return new BonusNumberDto(bonus);
    }

    public int getBonus() {
        return bonus;
    }
}
