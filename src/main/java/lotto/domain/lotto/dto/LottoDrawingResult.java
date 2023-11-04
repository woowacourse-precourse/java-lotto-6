package lotto.domain.lotto.dto;

public record LottoDrawingResult(
        int firstCount,
        int secondCount,
        int thirdCount,
        int fourthCount,
        int fifthCount,
        double returnOfRate
) {
}
