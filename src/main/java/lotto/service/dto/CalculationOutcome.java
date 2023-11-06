package lotto.service.dto;

import java.util.List;
import lotto.domain.LotteryResult;

public record CalculationOutcome(
        List<LotteryResult> results,
        double earningRate) {

}
