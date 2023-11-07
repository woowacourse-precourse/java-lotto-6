package lotto.dto;

import java.util.Map;
import lotto.embedded.LottoResult;

public record ResultDto(Map<LottoResult, Integer> resultMap, Double yield) {

}
