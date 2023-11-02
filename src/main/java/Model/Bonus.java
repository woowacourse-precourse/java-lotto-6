package Model;

import Config.ErrorMessage;
import Config.GameConfig;

public class Bonus {

    private final int bonus;

    public Bonus(String inputBonus){
        int bonus = validateNumeric(inputBonus);
        validateRange(bonus);
        this.bonus = bonus;
    }

    public int getBonus(){
        return bonus;
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
}
