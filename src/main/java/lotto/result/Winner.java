package lotto.result;

public enum Winner {
    FIFTH(5,"3개 일치 (5,000원)",5000,0),
    FOURTH(4,"4개 일치 (50,000원)",50_000L,1),
    THIRD(3,"5개 일치 (1,500,000원)",1_500_000L,2),
    SECOND(2,"5개 일치, 보너스 볼 일치 (30,000,000원)",30_000_000L,3),
    FIRST(1,"6개 일치 (2,000,000,000원)",2_000_000_000L,4);

    private final int grade;
    private final String text;
    private final long money;
    private final int idx;

    Winner(int grade, String text, long money, int idx) {
        this.grade = grade;
        this.text = text;
        this.money = money;
        this.idx = idx;
    }

    public int getGrade() {
        return grade;
    }

    public String getText() {
        return text;
    }

    public long getMoney() {
        return money;
    }

    public int getIdx() {
        return idx;
    }
}
