package lotto.dto;

import java.util.List;

public record LottosDto(int purchaseNumber, List<LottoDto> purchaseLotto) {
}
