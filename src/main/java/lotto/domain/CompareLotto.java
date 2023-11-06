package lotto.domain;

public class CompareLotto {
    public static Prize calculate(Lotto lotto, WinningLotto winningLotto, int bonusNumber){
        final int matchCount = lotto.countMatches(winningLotto);
        final boolean bonus = lotto.contains(bonusNumber);
        return Prize.getResult(matchCount, bonus);
    }
}