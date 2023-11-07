package lotto.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoWinningValue {
    FIRST_PLACE(1, 6, 0, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND_PLACE(2, 5, 1, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_PLACE(3, 5, 0, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH_PLACE(4, 4, 0, 50000, "4개 일치 (50,000원)"),
    FIFTH_PLACE(5, 3, 0, 5000, "3개 일치 (5,000원)");

    private int rank;
    private int winningNumCnt;
    private int bonusNumCnt;
    private int winningAmount;
    private String winningPhrase;

    // 모든 상수에 대한 맵을 BY_RANK라는 private static final 맵으로 미리 만들어 놓음
    // 이 맵은 rank를 키로 하고 해당 열거형 상수를 값으로 가지고 있다
    private static final Map<Integer, LottoWinningValue> BY_RANK =
            Stream.of(values()).collect(Collectors.toMap(LottoWinningValue::getRank, e -> e));
    // 당첨 번호 개수 + 보너스 개수를 키로 하고 해당 열거형 상수를 값으로 가지는 맵
    private static final Map<String, LottoWinningValue> BY_WINNING_MATCH_CNT = new HashMap<>();

    static {
        for (LottoWinningValue enumValue : LottoWinningValue.values()) {
            BY_WINNING_MATCH_CNT.put(enumValue.getWinningNumCnt() + "+" + enumValue.getBonusNumCnt(), enumValue);
        }
    }

    LottoWinningValue(int rank, int winningNumCnt, int bonusNumCnt, int winningAmount, String winningPhrase) {
        this.rank = rank;
        this.winningNumCnt = winningNumCnt;
        this.bonusNumCnt = bonusNumCnt;
        this.winningAmount = winningAmount;
        this.winningPhrase = winningPhrase;
    }

    public static LottoWinningValue valueOfRank(int rank) {
        return BY_RANK.get(rank);
    }


    public static LottoWinningValue valueOfWinningMatchCnt(int winningNumMatchCnt, int bonusNumMatchCnt) {
        return BY_WINNING_MATCH_CNT.get(winningNumMatchCnt + "+" + bonusNumMatchCnt);
    }

    public int getRank() {
        return rank;
    }

    public int getWinningNumCnt() {
        return winningNumCnt;
    }

    public int getBonusNumCnt() {
        return bonusNumCnt;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public String getWinningsPhrase() {
        return winningPhrase;
    }
}
