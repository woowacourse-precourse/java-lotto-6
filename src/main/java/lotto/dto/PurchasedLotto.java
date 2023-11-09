package lotto.dto;

import java.util.List;

public record PurchasedLotto(int purchasesNumber, List<LottoNumbers> lottos) {
}
