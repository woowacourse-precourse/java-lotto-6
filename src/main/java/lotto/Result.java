package lotto;

public enum Result {
    THREE(3, 5000, 0, "3개 일치 (5,000원) - "),
    FOUR(4, 50000, 0, "4개 일치 (50,000원) - "),
    FIVE(5, 1500000, 0, "5개 일치 (1,500,000원) - "),
    FIVE_BONUS(5, 30000000, 0, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(6, 2000000000, 0, "6개 일치 (2,000,000,000원) - ");

    private int num;
    private long prize;
    private int count;
    private String text;

    Result(int num, long prize, int count, String text) {
        this.num = num;
        this.prize = prize;
        this.count = count;
        this.text = text;
    }

    public int getNum() {
        return num;
    }


    public long getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public String getText() {
        return text;
    }

    public void increaseCount() {
        count++;
    }

    public void decreaseCount() {
        count--;
    }

    public static Result getResult(int count) {
        for (Result result : Result.values()) {
            if (result.num == count) {
                return result;
            }
        }
        return null;
    }
}
