package lotto.domain;

public record Rank(int fifth, int fourth, int third, int second, int first) {
    @Override
    public String toString() {
        return "{" + fifth +
                ", " + fourth +
                ", " + third +
                ", " + second +
                ", " + first +
                '}';
    }
}
