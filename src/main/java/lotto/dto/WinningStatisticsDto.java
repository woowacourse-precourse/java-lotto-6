package lotto.dto;

public record WinningStatisticsDto(int threeMatches, int fourMatches, int fiveMatches,
                                   int fiveMatchesWithBonus, int sixMatches, double earningRate) {
}
