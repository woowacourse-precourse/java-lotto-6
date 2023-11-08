package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoData {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 30_000_000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000),
    BLANK(2, 0);

    private int matchNumber;
    private int prize;

    LottoData(int matchNumber, int prize) {
        this.matchNumber = matchNumber;
        this.prize = prize;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getPrize() {
        return prize;
    }

    public static List<LottoData> getValues() {
        List<LottoData> LottoDataValues = Stream.of(LottoData.values())
                .filter(matchCount -> matchCount.matchNumber >= 3)
                .collect(Collectors.toList());
        Collections.reverse(LottoDataValues);
        return LottoDataValues;
    }

    public static LottoData getLottoDataType(int matchNumber, boolean matchBonus) {
        return Arrays.stream(LottoData.values())
                .filter(rankData -> rankData.isRankData(rankData, matchNumber, matchBonus))
                .findAny().orElse(BLANK);
    }

    private boolean isFirstPrize(LottoData rankData) {
        return rankData == FIRST_PRIZE;
    }
    private boolean isSecondPrize(LottoData rankData) {
        return rankData == SECOND_PRIZE;
    }

    private boolean isThirdPrize(LottoData rankData) {
        return rankData == THIRD_PRIZE;
    }

    private boolean isFourthPrize(LottoData rankData) {
        return rankData == FOURTH_PRIZE;
    }

    private boolean isFifthPrize(LottoData rankData) {
        return rankData == FIFTH_PRIZE;
    }

    private boolean isRankData(LottoData rankData, int matchNumber, boolean matchBonus){
        if (isFirstPrize(rankData) && !matchBonus){
            return isMatchNumber(rankData.matchNumber, matchNumber);
        } else if (isSecondPrize(rankData) && matchBonus) {
            return isMatchNumber(rankData.matchNumber, matchNumber);
        } else if (isThirdPrize(rankData) && !matchBonus) {
            return isMatchNumber(rankData.matchNumber, matchNumber);
        } else if (isFourthPrize(rankData) && !matchBonus) {
            return isMatchNumber(rankData.matchNumber, matchNumber);
        } else if (isFifthPrize(rankData) && !matchBonus) {
            return isMatchNumber(rankData.matchNumber, matchNumber);
        }
        return false;
    }

    private boolean isMatchNumber(int rankMatchNumbers, int matchNumbers) {
        return rankMatchNumbers == matchNumbers;
    }

    public String getStaticsMessage(int count) {
        if (isSecondPrize(matchNumber, prize)) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", matchNumber, prize, count);
        }

        return String.format("%d개 일치 (%,d원) - %,d개", matchNumber, prize, count);
    }

    private boolean isSecondPrize(int matchNumbers, int prizeMoney) {
        return matchNumbers == SECOND_PRIZE.getMatchNumber() && prizeMoney == SECOND_PRIZE.getPrize();
    }
}


