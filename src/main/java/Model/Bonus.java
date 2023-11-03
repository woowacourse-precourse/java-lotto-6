package Model;

import Config.ErrorMessage;
import Config.GameConfig;

import java.util.List;

public class Bonus {

    private final int bonus;

    public Bonus(String inputBonus, Winning winning){
        int bonus = validateNumeric(inputBonus);
        validateRange(bonus);
        validateDuplicateWinning(winning, bonus);
        this.bonus = bonus;
    }

    public boolean matchBonus(List<Integer> numbers){
        return numbers.contains(bonus);
    }

    private int validateNumeric(String bonus){
        try {
            return Integer.parseInt(bonus);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC.getErrorMessage());
        }
    }

    private void validateRange(int bonus) {
        if (bonus < GameConfig.MIN_LOTTO || bonus > GameConfig.MAX_LOTTO) {
            throw new IllegalArgumentException(String.format(ErrorMessage.NOT_IN_RANGE.getErrorMessage(), GameConfig.MIN_LOTTO, GameConfig.MAX_LOTTO));
        }
    }

    private void validateDuplicateWinning(Winning winning, int bonus){
        if (winning.isContain(bonus)){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS.getErrorMessage());
        }
    }
}
