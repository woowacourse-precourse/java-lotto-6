package lotto.dto;

import lotto.model.Lotto;

import java.util.List;

public record PurchaseResult(List<Lotto> lottos, Integer purchaseCount) {
}
