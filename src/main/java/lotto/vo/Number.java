package lotto.vo;

public record Number(Integer value) implements Comparable<Number> {
    @Override
    public int compareTo(Number other) {
        return value.compareTo(other.value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
