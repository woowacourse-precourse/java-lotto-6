package lotto.service;

import java.util.HashMap;
import java.util.List;
import lotto.constants.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoScoreChecker;
import lotto.domain.LottoSeller;
import lotto.utils.StringChanger;

public class LottoService {
    private static final int NOTHING = 0;
    private static final int COUNT_ONE = 1;
    private static final int TO_RATIO = 100;

    private final LottoSeller lottoSeller = new LottoSeller();
    private final LottoScoreChecker lottoScoreChecker = new LottoScoreChecker();
    private final HashMap<Integer, Integer> rankCounts = new HashMap<>();
    private long winnings = NOTHING;

    public void setAmount(String userInput) {
        userInput = StringChanger.toTrimmedString(userInput);
        lottoSeller.setAmount(userInput);
    }

    public List<Lotto> getUserLotto() {
        return lottoSeller.giveLotto();
    }

    public void setFirstRankNumbers(String userInput) {
        List<String> inputNumbers = StringChanger.toTrimmedStringList(userInput);
        lottoScoreChecker.setFirstRankNumbers(inputNumbers);
    }

    public void setBonusNumber(String userInput) {
        userInput = StringChanger.toTrimmedString(userInput);
        lottoScoreChecker.setBonusNumber(userInput);
    }

    public void checkScore(Lotto lotto) {
        Rank rank = lottoScoreChecker.getRank(lotto);
        recordLottoBy(rank.getRank());
        sumUpWinningsBy(rank.getAmount());
    }

    public int getCountOf(Rank rank) {
        int rankNumber = rank.getRank();
        if (rankCounts.containsKey(rankNumber)) {
            return rankCounts.get(rankNumber);
        }
        return NOTHING;
    }

    public double getProfitRatio() {
        return (double) winnings / lottoSeller.getAmount() * TO_RATIO;
    }

    private void recordLottoBy(int rank) {
        if (!rankCounts.containsKey(rank)) {
            rankCounts.put(rank, COUNT_ONE);
            return;
        }
        rankCounts.put(rank, rankCounts.get(rank) + COUNT_ONE);
    }

    private void sumUpWinningsBy(long amount) {
        winnings += amount;
    }
}
