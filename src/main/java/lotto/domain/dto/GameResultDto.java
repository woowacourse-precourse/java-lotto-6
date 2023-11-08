package lotto.domain.dto;

import java.util.Map;
import lotto.domain.Prize;

public record GameResultDto(Map<Prize, Integer> prizeCounter, float winningPercentage) {
}
