package lotto;

public enum Prize {  // 등수별 상금을 Enum화
    First(2000000000), Second(30000000), Third(1500000), Fourth(50000), Fifth(5000), None(0);
    private final int prize;

    // Enum 생생자
    Prize(int prize) {
        this.prize = prize;
    }

    // 각 상금 getter
    public int getPrize() {
        return prize;
    }
}