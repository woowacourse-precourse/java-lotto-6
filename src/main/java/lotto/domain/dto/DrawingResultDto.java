package lotto.domain.dto;

import java.util.Map;
import lotto.domain.Rank;

public record DrawingResultDto(Map<Rank, Integer> drawingResults) {
}
