package lotto.domain;

public class CompareLotto {
    private static final int NUMBER_FIVE = 5;
    public static Prize calculate(Lotto lotto, WinningLotto winningLotto, int bonusNumber){
        final int matchCount = lotto.countMatches(winningLotto);

        boolean bonus = false;
        if(matchCount == NUMBER_FIVE){
            bonus = lotto.contains(bonusNumber);
        }

        return Prize.getResult(matchCount, bonus);
    }
}