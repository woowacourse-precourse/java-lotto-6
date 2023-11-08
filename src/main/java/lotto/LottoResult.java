package lotto;

public class LottoResult {
    // 인덱스 0 사용 안 함, 1-6은 일반 일치 개수, 7은 5개 일치 + 보너스
    private final int[] matchCounts;

    public LottoResult() {
        this.matchCounts = new int[8];
    }

    public void addResult(int matchCount, boolean isBonus) {
        if (matchCount == 5 && isBonus) {
            matchCounts[7]++; // 5개 일치 + 보너스 번호
        } else {
            matchCounts[matchCount]++; // 그 외 일반 일치 개수
        }
    }

    public int getMatchCount(int matchCount) {
        return matchCounts[matchCount];
    }

    // 5개 일치 + 보너스 번호에 대한 개수를 반환하는 메소드
    public int getMatchCountWithBonus() {
        return matchCounts[7]; // 인덱스 7에 저장된 값을 반환
    }
}