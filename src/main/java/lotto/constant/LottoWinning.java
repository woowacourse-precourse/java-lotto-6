package lotto.constant;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoWinning {
    FIRST_PLACE(1, 6, 0, "6개 일치 (2,000,000,000원)"),
    SECOND_PLACE(2, 5, 1, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_PLACE(3, 5, 0, "5개 일치 (1,500,000원)"),
    FOURTH_PLACE(4, 4, 0, "4개 일치 (50,000원)"),
    FIFTH_PLACE(5, 3, 0, "3개 일치 (5,000원)");

    private int rank;
    private int winningNumberCnt;
    private int bonusNumberCnt;
    private String winnings;

    LottoWinning(int rank, int winningNumberCnt, int bonusNumberCnt, String winnings) {
        this.rank = rank;
        this.winningNumberCnt = winningNumberCnt;
        this.bonusNumberCnt = bonusNumberCnt;
        this.winnings = winnings;
    }

    // 모든 상수에 대한 맵을 BY_RANK라는 private static final 맵으로 미리 만들어 놓음
    // 이 맵은 rank를 키로 하고 해당 열거형 상수를 값으로 가지고 있다
    private static final Map<Integer, LottoWinning> BY_RANK =
            Stream.of(values()).collect(Collectors.toMap(LottoWinning::getRank, e -> e));

    public static LottoWinning valueOfRank(int rank) {
        return BY_RANK.get(rank);
    }

    public int getRank() {
        return rank;
    }

    public int getWinningNumberCnt() {
        return winningNumberCnt;
    }

    public int getBonusNumberCnt() {
        return bonusNumberCnt;
    }

    public String getWinnings() {
        return winnings;
    }
}
