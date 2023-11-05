package lotto.dto;

import lotto.domain.Lotto;
import java.util.List;
import java.util.stream.Collectors;

public record LottoReceiptDto(int purchaseCount, List<LottoDto> lottos) {
    public static LottoReceiptDto from(int purchaseCount, List<Lotto> lottos) {
        List<LottoDto> lottoDtos = lottos.stream().map(LottoDto::of).toList();
        return new LottoReceiptDto(purchaseCount, lottoDtos);
    }
}
