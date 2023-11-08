package domain;

public enum Coincide {
    FIRST(6, "6개 일치 (2,000,000,000원) - ", 2000000000),
    SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    THIRD(5, "5개 일치 (1,500,000원) - ", 1500000),
    FOUR(4, "4개 일치 (50,000원) - ", 50000),
    FIVE(3, "3개 일치 (5,000원) - ", 5000);

    private final int cnt; // 일치 하는 수
    private final String message; // 메세지
    private final int countOfMoney; // 얼마 인지

    Coincide(int cnt, String message, int countOfMoney) {
        this.cnt = cnt;
        this.message = message;
        this.countOfMoney = countOfMoney;
    }

    public int getCnt() {
        return cnt;
    }

    public String getMessage() {
        return message;
    }

    public int getCountOfMoney() {
        return countOfMoney;
    }

}
