package lotto;

public enum Prize{
    First(2000000000) ,Second(30000000), Third(1500000), Fourth(50000), Fifth(5000), None(0);
    private final int prize;
    Prize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

}