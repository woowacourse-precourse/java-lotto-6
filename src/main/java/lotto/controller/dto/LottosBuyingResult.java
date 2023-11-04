package lotto.controller.dto;

import java.util.List;
import lotto.domain.lotto.Lotto;

public record LottosBuyingResult(List<Lotto> lottos, int count) {
}
