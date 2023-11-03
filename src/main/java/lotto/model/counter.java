package lotto.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        counter counter = (counter) o;
        return count == counter.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

}
