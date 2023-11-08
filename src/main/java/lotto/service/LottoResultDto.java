package lotto.service;

import java.util.Map;
import lotto.enums.LottoStatus;

public record LottoResultDto(Map<LottoStatus, Integer> lottoStatusCounts) {
}
