package lotto.model.dto;

import java.util.List;
import lotto.model.Lotto;

public record BuyerLottoHistory(int lottoCount, List<Lotto> lottos) {
}