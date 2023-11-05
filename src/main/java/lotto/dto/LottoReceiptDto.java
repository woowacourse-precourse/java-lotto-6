package lotto.dto;

import java.util.List;

public record LottoReceiptDto(int purchaseCount, List<LottoDto> lottos) {
}
