package lotto.dto;

import java.util.List;

public record WinningResultDto(
        List<RankingDto> rankingDtos,
        double returnRate) {
}
