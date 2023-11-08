package lotto.domain.service.dto;

import java.util.Map;
import lotto.domain.entity.Rank;

public record GameResult(
        Map<Rank, Long> rankBoard,
        float earningRate
) {

}
