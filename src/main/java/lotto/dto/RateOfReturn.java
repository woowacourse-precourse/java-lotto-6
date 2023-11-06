package lotto.dto;

public record RateOfReturn(double value) {
    @Override
    public String toString() {
        return "총 수익률은 " + value + "%입니다.";
    }
}
