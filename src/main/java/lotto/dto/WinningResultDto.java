package lotto.dto;

public record WinningResultDto(
        int firstPlaceCount,
        int secondPlaceCount,
        int thirdPlaceCount,
        int fourthPlaceCount,
        int fifthPlaceCount
) {
}
