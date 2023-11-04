package lotto.controller.dto.output;

import java.util.List;

public record LottosBuyingResult(List<LottoDto> lottos, int count) {
}
