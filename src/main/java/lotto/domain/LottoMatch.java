package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.LottoConfig;

public class LottoMatch {

    private final LottoConfig lottoConfig = new LottoConfig();
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int WINNING_MIN_COUNT = 3;
    private static final int PERCENTAGE = 100;
    private static final String VALIDATE_MESSAGE = "는 유효하지 않은 값입니다.";


    public Map<Rank, Integer> initializeLottoResult() {
        Map<Rank, Integer> lottoResult = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, ZERO);
        }
        return lottoResult;
    }

    public Map<Rank, Integer> scoreBoard(List<Lotto> lottoNumbers, WinningLotto winningLotto) {
        Map<Rank, Integer> lottoResult = initializeLottoResult();
        for (Lotto lotto : lottoNumbers) {
            Rank rank = lottoMatch(lotto, winningLotto);
            lottoResult.put(rank, lottoResult.get(rank) + ONE);
        }
        return lottoResult;
    }

    private Rank lottoMatch(Lotto lotto, WinningLotto winningLotto) {
        int countOfMatch = lotto.countMatch(winningLotto.lotto());
        boolean matchBonus = lotto.containNumber(winningLotto.bonusNumber());

        return matchCountCheck(countOfMatch, matchBonus);
    }

    private Rank matchCountCheck(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < WINNING_MIN_COUNT) {
            return Rank.MISS;
        }

        if (Rank.SECOND.matchCount(countOfMatch) && matchBonus) {
            return Rank.SECOND;
        }

        return Stream.of(Rank.values())
                .filter(rank -> rank.matchCount(countOfMatch) && rank != Rank.SECOND)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(countOfMatch + VALIDATE_MESSAGE));
    }

    public double earningRateMain(Map<Rank, Integer> lottoResult, int lottoAmount) {
        return lottoResult.keySet().stream()
                .mapToDouble(rank -> earningRateSub(lottoResult, lottoAmount, rank))
                .sum();
    }

    public double earningRateSub(Map<Rank, Integer> lottoResult, int lottoAmount, Rank rank) {
        return ((rank.getWinningMoney()) / (lottoAmount * lottoConfig.TICKET_PRICE)) * lottoResult.get(rank)
                * PERCENTAGE;
    }
}
