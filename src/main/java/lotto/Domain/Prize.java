package lotto.Domain;

public enum Prize {
    FIRST_PLACE("6개 일치 (2,000,000,000원)", 2000000000,0),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000,0),
    THIRD_PLACE("5개 일치 (1,500,000원)", 1500000, 0),
    FOURTH_PLACE("4개 일치 (50,000원)", 50000, 0),
    FIFTH_PLACE("3개 일치 (5,000원)", 5000, 0);

    private final String message;
    private final int prizeMoney;
    private int count;

    private Prize(String message, int prizeMoney, int count) {
        this.message = message;
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public void plusCount(int count){
        this.count += count;
    }
    public int getCount(){
        return count;
    }

}
