package lotto;

public enum Prize {
    fifth("3개 일치 (5,000원) - ", 5_000, 3, 5),
    fourth("4개 일치 (50,000원) - ", 50_000, 4, 4),
    third("5개 일치 (1,500,000원) - ", 1_500_000, 5, 3),
    second("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000, 5, 2),
    first("6개 일치 (2,000,000,000원) - ", 2_000_000_000, 6, 1),
    ;

    private final String label;
    private final int money;
    private final int count;
    private final int rank;

    Prize(String label, int money, int count, int rank) {
        this.label = label;
        this.money = money;
        this.count = count;
        this.rank = rank;
    }

    public String label() {
        return label;
    }

    public int money() {
        return money;
    }

    public int count() {
        return count;
    }

    public int rank() {
        return rank;
    }

}
