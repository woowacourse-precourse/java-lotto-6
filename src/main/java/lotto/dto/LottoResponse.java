package lotto.dto;

public record LottoResponse(
        String numbers
) {
    @Override
    public String toString() {
        return numbers;
    }
}
