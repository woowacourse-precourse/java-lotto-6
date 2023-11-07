package lotto;

import java.util.HashMap;
import java.util.Map;

public class Match {

    private final InputLottoNumber inputLottoNumber;
    private final InputBonusNumber inputBonusNumber;
    private final Lotto lotto;

    private static final Map<MatchResult, Integer> PRIZE_MONEY = new HashMap<>();

    static {
        PRIZE_MONEY.put(new MatchResult(3, false), 5_000);
        PRIZE_MONEY.put(new MatchResult(4, false), 50_000);
        PRIZE_MONEY.put(new MatchResult(5, false), 1_500_000);
        PRIZE_MONEY.put(new MatchResult(5, true), 30_000_000);
        PRIZE_MONEY.put(new MatchResult(6, false), 2_000_000_000);
    }

    public Match(InputLottoNumber inputLottoNumber, InputBonusNumber inputBonusNumber,
        Lotto lotto) {
        this.inputLottoNumber = inputLottoNumber;
        this.inputBonusNumber = inputBonusNumber;
        this.lotto = lotto;
    }

    public MatchResult calculate() {
        Map<MatchResult, Integer> matchCounts = new HashMap<>();
        PRIZE_MONEY.keySet().forEach(key -> matchCounts.put(key, 0));

        int matchCount = countLotto();
        boolean bonusMatch = isBonusNumberContained();
        MatchResult matchResult = new MatchResult(matchCount, bonusMatch);
        System.out.println("matchResult = " + matchResult);
        return matchResult;
    }

    private int countLotto() {
        return (int) lotto.getNumbers().stream()
            .filter(inputLottoNumber.getInputNumber()::contains)
            .count();
    }

    private boolean isBonusNumberContained() {
        return lotto.getNumbers().contains(inputBonusNumber.getNumber());
    }
}