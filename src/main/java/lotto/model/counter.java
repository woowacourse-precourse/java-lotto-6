package lotto.model;

public class counter {
    private final int count;

    public counter() {
        this(0);
    }

    public counter(final int count) {
        this.count = count;
    }

    public counter plus() {
        return new counter(count + 1);
    }

    public int getCount() {
        return count;
    }


}
