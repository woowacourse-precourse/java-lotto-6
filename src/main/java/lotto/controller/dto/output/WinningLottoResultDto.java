package lotto.controller.dto.output;

import java.util.List;

public record WinningLottoResultDto(List<Integer> winningLottoCountByRank, float profitRate) {
}
