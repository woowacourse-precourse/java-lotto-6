package lotto.dto.response;

import java.util.Map;
import lotto.domain.enums.Prize;

public record LottoResultDto(Map<Prize, Integer> prizeIntegerMap, double earningRate) {
}
