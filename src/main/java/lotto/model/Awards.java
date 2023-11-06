package lotto.model;

public enum Awards{
    FIFTH(5_000, "3개 일치 (5,000원) - ", 3),
    FOURTH(50_000, "4개 일치 (50,000원) - ", 4),
    THIRD(1_500_000, "5개 일치 (1,500,000원) - ", 5),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", -5),
    FIRST(2_000_000_000, "6개 일치 (2,000,000,000원) - ", 6);

    private int count;
    private final int award;
    private final String mark;
    private final int matching;

    Awards(int award, String mark, int matching) {
        this.award = award;
        this.mark = mark;
        this.matching = matching;
    }
    public void addCount() {
        this.count++;
    }

    public int getAward(){
        return this.award;
    }
    public int getCount() {
        return this.count;
    }
    public int getMatching(){//int result) {
        return this.matching;
    }
    public String getMark() {
        return this.mark;
    }

}
