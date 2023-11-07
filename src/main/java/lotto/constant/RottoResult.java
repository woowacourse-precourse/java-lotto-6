package lotto.constant;

public enum RottoResult {
    FIVE(3, 5_000),
    FOUR(4,50_000),
    THREE(5,1_500_000),
    TWO(5,30_000_000),
    ONE(6,2_000_000_000);

    private final int matchingNumber;
    private final int amout;

    RottoResult(int matchingNumber, int amout) {
        this.matchingNumber = matchingNumber;
        this.amout = amout;
    }

    public String printRottoResult(){
        return String.format("%d개 일치 (%,d원) - ",matchingNumber,amout);
    }
}
