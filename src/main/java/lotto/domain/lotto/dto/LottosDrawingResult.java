package lotto.domain.lotto.dto;

public record LottosDrawingResult(
        int firstCount,
        int secondCount,
        int thirdCount,
        int fourthCount,
        int fifthCount,
        double returnOfRate
) {
}
