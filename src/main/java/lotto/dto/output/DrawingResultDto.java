package lotto.dto.output;

public record DrawingResultDto(
        int firstMatchCount,
        int secondMatchCount,
        int thirdMatchCount,
        int fourthMatchCount,
        int fifthMatchCount,
        double prizeOfRate
) {
}
