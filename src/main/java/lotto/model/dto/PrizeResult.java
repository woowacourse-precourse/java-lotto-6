package lotto.model.dto;

public record PrizeResult(String condition, int prize, int size) implements Comparable<PrizeResult> {

    public static PrizeResult of(final String condition, final int prize, final int size) {
        return new PrizeResult(condition, prize, size);
    }

    @Override
    public int compareTo(final PrizeResult other) {
        return this.prize - other.prize;
    }
}
