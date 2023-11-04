package lotto.dto;

public record LottoNumberResponse(
        String numbers
) {
    @Override
    public String toString() {
        return numbers;
    }
}
