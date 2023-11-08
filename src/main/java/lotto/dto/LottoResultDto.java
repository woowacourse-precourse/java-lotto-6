package lotto.dto;

import lotto.domain.WinningStatistics;

import java.util.HashMap;
import java.util.List;

public class LottoResultDto {
    private final WinningTierResponseDto winningTierResponseDto;
    private final List<Long> correctWinningsCount;
    private final List<Boolean> correctBonuses;

    public LottoResultDto(WinningTierResponseDto winningTierResponseDto,
                          List<Long> correctWinningsCount,
                          List<Boolean> correctBonuses) {
        this.winningTierResponseDto = winningTierResponseDto;
        this.correctWinningsCount = correctWinningsCount;
        this.correctBonuses = correctBonuses;
    }

    public WinningTierResponseDto getWinningTierResponseDto() {
        return winningTierResponseDto;
    }

    public List<Long> getCorrectWinningsCount() {
        return correctWinningsCount;
    }

    public List<Boolean> getCorrectBonuses() {
        return correctBonuses;
    }
}
