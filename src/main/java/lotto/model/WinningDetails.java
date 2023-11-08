package lotto.model;

import lotto.constant.LotteryRank;

import java.util.Map;

public record WinningDetails(Map<LotteryRank, Integer> breakdown, double returnOnInvestment) {
}
