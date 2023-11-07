package lotto.service.dto;

import java.util.List;

public record LotteryResultsDto(
        List<LotteryResultDto> results,
        double earningRate) {

}
