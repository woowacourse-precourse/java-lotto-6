package Money;

public enum Winning {
    one(2000000000, "6개 일치 (2,000,000,000원) - "),
    two(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    three(1500000, "5개 일치 (1,500,000원) - "),
    four(50000, "4개 일치 (50,000원) - "),
    five(5000, "3개 일치 (5,000원) - ");
    private final int rank;
    private final String message;

    Winning(int rank, String message) {
        this.rank = rank;
        this.message = message;
    }

    public int getRank() {
        return rank;
    }

    public String getMessage() {
        return message;
    }
}
