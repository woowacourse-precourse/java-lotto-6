package lotto.service;

import java.util.List;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.dto.StatisticsDto;

public class SummaryMatchingImpl implements SummaryMatching {
    private final List<Integer> matchResult;

    public SummaryMatchingImpl(List<Integer> matchResult) {
        this.matchResult = matchResult;
    }

    @Override
    public StatisticsDto toStatisticsDto() {
        int first = 0, second = 0, third = 0, forth = 0, fifth = 0;
        float ror = computeRoR();
        for (int result : matchResult) {
            if (isFifthPrize(result)) {
                fifth++;
            } else if (isForthPrize(result)) {
                forth++;
            } else if (isThirdPrize(result)) {
                third++;
            } else if (isSecondPrize(result)) {
                second++;
            } else if (isFirstPrize(result)) {
                first++;
            }
        }
        return new StatisticsDto.Builder()
                .first(first)
                .second(second)
                .third(third)
                .forth(forth)
                .fifth(fifth)
                .ror(ror)
                .build();
    }

    private float computeRoR() {
        int reward = 0;
        for (int result : matchResult) {
            if (isFifthPrize(result)) {
                reward += Prize.FIFTH.getReward();
            } else if (isForthPrize(result)) {
                reward += Prize.FORTH.getReward();
            } else if (isThirdPrize(result)) {
                reward += Prize.THIRD.getReward();
            } else if (isSecondPrize(result)) {
                reward += Prize.SECOND.getReward();
            } else if (isFirstPrize(result)) {
                reward += Prize.FIRST.getReward();
            }
        }
        return computeRoRFormula(reward, matchResult.size());
    }

    private float computeRoRFormula(int reward, int LottoCount) {
        return (float) reward / (LottoCount * Lottos.LOTTO_PRICE) * 100;
    }

    private boolean isFirstPrize(int result) {
        return result == Prize.FIRST.getThreshold();
    }

    private boolean isSecondPrize(int result) {
        return result == Prize.SECOND.getThreshold();
    }

    private boolean isThirdPrize(int result) {
        return result == Prize.THIRD.getThreshold();
    }

    private boolean isForthPrize(int result) {
        return result == Prize.FORTH.getThreshold();
    }

    private boolean isFifthPrize(int result) {
        return result == Prize.FIFTH.getThreshold();
    }

}
