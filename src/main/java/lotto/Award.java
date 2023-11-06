package lotto;

public enum Award {
    세개(3, 5000), 네개(4, 50000), 다섯개(5, 1500000), 다섯개보너스(5, 30000000), 여섯개(6, 2000000000);

    private int 일치;
    private int 상금;

    Award(int 일치, int 상금) {
        this.일치 = 일치;
        this.상금 = 상금;
    }

    public int get일치() {
        return 일치;
    }

    public int get상금() {
        return 상금;
    }
}
