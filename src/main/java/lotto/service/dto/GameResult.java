package lotto.service.dto;

import java.util.Map;
import lotto.service.manager.Rank;

public record GameResult(
        Map<Rank, Long> rankBoard,
        float earningRate
) {

}
