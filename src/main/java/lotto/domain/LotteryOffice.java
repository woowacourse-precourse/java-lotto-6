package lotto.domain;

import static lotto.domain.Rankings.decideRankings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;

public class LotteryOffice {

    private static final int INITIALIZING_NUM = 0;
    private static final int INCREMENT = 1;
    private List<Lotto> issuedLotto;
    private Lotto winningTicket;
    private BonusNumber bonusNumber;

    public LotteryOffice(List<Lotto> issuedLotto, Lotto winningTicket, BonusNumber bonusNumber) {
        this.issuedLotto = issuedLotto;
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public Map<Rankings, Integer> getWinningsAndCounts() {
        List<Rankings> winningResult = determineWinning();
        return getFinalResult(winningResult);
    }

    private List<Rankings> determineWinning() {
        List<Rankings> winningResult = new ArrayList<>();
        for (Lotto lotto : issuedLotto) {
            winningResult.add(decideRankings(lotto, winningTicket, bonusNumber));
        }
        return winningResult;
    }

    private Map<Rankings,Integer> getFinalResult(List<Rankings> winningResult) {
        Map<Rankings,Integer> finalResult = initializeResult();
        for (Rankings rankings : winningResult) {
            finalResult.put(rankings, finalResult.get(rankings) + INCREMENT);
        }
        return finalResult;
    }

    private Map<Rankings,Integer> initializeResult() {
        Map<Rankings,Integer> result = new LinkedHashMap<>();
        for (Rankings rankings : Rankings.values()) {
            result.put(rankings, INITIALIZING_NUM);
        }
        return result;
    }

}
