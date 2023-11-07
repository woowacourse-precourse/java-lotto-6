package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;

public class LotteryOffice {

    private static final int INITIALIZING_NUM = 0;
    private static final int INCREMENT = 1;
    private final List<Lotto> issuedLotto;
    private final WinningNumbers winningNumbers;

    public LotteryOffice(List<Lotto> issuedLotto, WinningNumbers winningNumbers) {
        this.issuedLotto = issuedLotto;
        this.winningNumbers = winningNumbers;
    }

    public Map<Rankings, Integer> getWinningsAndCounts() {
        List<Rankings> winningResult = determineWinning();
        return getFinalResult(winningResult);
    }

    private List<Rankings> determineWinning() {
        List<Rankings> winningResult = new ArrayList<>();
        for (Lotto lotto : issuedLotto) {
            winningResult.add(winningNumbers.assignRankings(lotto));
        }
        return winningResult;
    }

    private Map<Rankings, Integer> getFinalResult(List<Rankings> winningResult) {
        Map<Rankings, Integer> finalResult = initializeResult();
        for (Rankings rankings : winningResult) {
            finalResult.put(rankings, finalResult.get(rankings) + INCREMENT);
        }
        finalResult.remove(Rankings.NONE);
        return finalResult;
    }

    private Map<Rankings, Integer> initializeResult() {
        Map<Rankings, Integer> result = new LinkedHashMap<>();
        for (Rankings rankings : Rankings.values()) {
            result.put(rankings, INITIALIZING_NUM);
        }
        return result;
    }

}
