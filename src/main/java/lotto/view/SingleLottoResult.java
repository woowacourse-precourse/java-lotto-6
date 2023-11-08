package lotto.view;

import lotto.domain.Rank;

public record SingleLottoResult(Rank rank, int countOfMatch, String lotteryWinnings, Integer numberOfRanks) {
}
