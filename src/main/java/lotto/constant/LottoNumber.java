package lotto.constant;

public enum LottoNumber {
    RANGE(1, 45, 6);

    private final int startNumber;
    private final int endNumber;
    private final int count;

    LottoNumber(int startNumber, int endNumber, int count) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.count = count;
    }

    public boolean notInclude(int number) {
        return this.isOver(number) || this.isUnder(number);
    }

    private boolean isOver(int number) {
        return number < RANGE.startNumber;
    }

    private boolean isUnder(int number) {
        return number > RANGE.endNumber;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public int getEndNumber() {
        return endNumber;
    }

    public int getCount() {
        return count;
    }
}
