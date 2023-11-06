package lotto.view;

import java.util.List;

import lotto.exception.BonusNumException;

public class BonusWinningInput {

    public static void bonusWinningInput() {
        List<Integer> wins = WinningLottoInput.winnigLottoInput();
        System.out.println("");
        int bonus = inputBonus(wins);
    }

    public static int inputBonus(List<Integer> wins) {
        int bonus = BonusLottoInput.bonusLottoInput();
        validateBonusWins(wins, bonus);
        return bonus;
    }

    public static int validateBonusWins(List<Integer> wins, int bonus) {
        try {
            validateDup(bonus, wins);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + System.lineSeparator());
            return inputBonus(wins);
        }
        return bonus;
    }

    public static void validateDup(int num, List<Integer> wins) {
        if (wins.contains(num)) {
            BonusNumException.BonusDupException();
        }
    }


}
