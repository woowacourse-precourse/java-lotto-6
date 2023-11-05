package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class PrizeResult {
    private final Map<Prize, Integer> prizeResult;

    public PrizeResult() {
        prizeResult = new EnumMap<>(Prize.class);
        Arrays.stream(Prize.values())
                .forEach(prize -> prizeResult.put(prize, 0));
    }

    public void getPrizeResult(WinningLotto winningLotto, UserLotto userLotto) {
        for (Lotto lotto : userLotto.getUserLottoNumber()) {
            Prize rank = Prize.getLottoResult(lotto.getMatchLottoNumber(winningLotto),
                    lotto.isContain(winningLotto.getBonusNumber()));
            updateRankCount(rank);
        }
    }

    private void updateRankCount(Prize prize) {
        prizeResult.put(prize, prizeResult.get(prize) + 1);
    }

    public double sumWinningPrize() {
        double totalWinningPrize = 0.0;
        for (Prize prize : Prize.values()) {
            totalWinningPrize += prizeResult.get(prize) * prize.getWinningPrize();
        }
        return totalWinningPrize;
    }

    // 이게 너무 보기싫다..
    private String prizeResult(Prize prize, int count) {
        int matchLottoNumber = prize.getMatchLottoNumber();
        String matchString = matchLottoNumber + "개 일치";
        if (prize == Prize.SECOND) {
            matchString += ", 보너스 볼 일치";
        }
        String prizeString = String.format("(%,d원)", prize.getWinningPrize());
        return matchString + " " + prizeString + " - " + count + "개" + '\n';
    }

    @Override
    public String toString() {
        String temp = "";
        for (Prize prize : Prize.values()) {
            if (prize != Prize.EMPTY) {
                temp += prizeResult(prize, prizeResult.get(prize));
            }
        }
        return temp.trim();
    }
}
