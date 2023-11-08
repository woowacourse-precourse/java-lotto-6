package lotto.model.domain.result;

/**
 * 로또 당첨 결과를 나타내기 위한 클래스
 * <p>정답 개수와 상금 정보를 가진다.</p>
 */
public enum LottoResult {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(0, 0);

    private final int collectCount;
    private final int prize;

    LottoResult(int collectCount, int prize) {
        this.collectCount = collectCount;
        this.prize = prize;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public int getPrize() {
        return prize;
    }

}