package lotto.controller.dto.output;

import java.util.List;

/**
 * 구매한 모든 로또 데이터를 담은 Dto입니다.
 */
public record LottosBuyingOutput(List<LottoOutput> lottos, int count) {
}
