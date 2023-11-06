package lotto.domain;

import static lotto.domain.Rankings.decideRankings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;

public class LotteryOffice {

    private static final int FIVE_MATCHES = 5;

    private List<Lotto> issuedLotto;
    private Lotto winningTicket;
    private BonusNumber bonusNumber;

    public LotteryOffice(List<Lotto> issuedLotto, Lotto winningTicket, BonusNumber bonusNumber) {
        this.issuedLotto = issuedLotto;
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public void printResult() {
        List<Rankings> winningResult = determineWinning();
        Map<Rankings,Integer> finalResult = getFinalResult(winningResult);
    }

    public List<Rankings> determineWinning() {
        List<Rankings> winningResult = new ArrayList<>();
        for (Lotto lotto : issuedLotto) {
            winningResult.add(decideRankings(lotto, winningTicket, bonusNumber));
        }
        return winningResult;
    }

    public Map<Rankings,Integer> getFinalResult(List<Rankings> winningResult) {
        Map<Rankings,Integer> finalResult = initializedResult();
        for (Rankings rankings : winningResult) {
            finalResult.put(rankings, finalResult.get(rankings) + 1);
        }
        return finalResult;
    }

    private Map<Rankings,Integer> initializedResult() {
        Map<Rankings,Integer> result = new LinkedHashMap<>();
        for (Rankings rankings : Rankings.values()) {
            result.put(rankings, 0);
        }
        result.remove(Rankings.NONE);
        return result;
    }

}
