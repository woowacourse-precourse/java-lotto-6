package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Lotto lottoGame;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoResult(Lotto lottoGame, Lotto winningLotto, int bonusNumber) {
        this.lottoGame = lottoGame;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchCount() {
        return (int) winningLotto.getNumbers().stream()
                .filter(lottoGame.getNumbers()::contains)
                .count();
    }

    private boolean hasBonus() {
        return getMatchCount() == 5 && lottoGame.containBonusNumber(bonusNumber);
    }

    public static void updateMatchNumberCount(Map<Prize, Integer> matchNumberCount, LottoResult lottoResult) {
        // 당첨번호의 개수와 보너스 번호의 일치 여부 알 수 있음
        Prize prize = Prize.findMatchingPrize(lottoResult.getMatchCount(), lottoResult.hasBonus());

        if (prize != Prize.NONE) {
            matchNumberCount.put(prize, matchNumberCount.getOrDefault(prize, 0) + 1);
        }
    }
}
