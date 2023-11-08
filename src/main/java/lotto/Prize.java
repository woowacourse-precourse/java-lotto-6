package lotto;

public enum Prize {  // 등수별 상금을 Enum화
    None(0, "해당 없음"),
    Fifth(5000, "3개 일치"),
    Fourth(50000, "4개 일치"),
    Third(1500000, "5개 일치"),
    Second(30000000, "5개 일치, 보너스 볼 일치"),
    First(2000000000, "6개 일치");

    private final int prize;
    private final String message;

    // Enum 생생자
    Prize(int prize, String message) {
        this.prize = prize;
        this.message = message;
    }

    // 각 상금 getter
    public int getPrize() {
        return prize;
    }

    // 각 메세지 getter
    public String getMessage() {
        return message;
    }
}