package lotto.dto;

import java.util.List;
import lotto.model.Lotto;

public class LottosDto {

    private final Integer numberOfPurchase;
    private final List<LottoDto> lottoDtos;

    private LottosDto(List<Lotto> lottos) {
        numberOfPurchase = lottos.size();
        lottoDtos = lottos.stream().map(LottoDto::create)
                .toList();
    }

    public static LottosDto create(List<Lotto> lottos) {
        return new LottosDto(lottos);
    }

    public Integer getNumberOfPurchase() {
        return numberOfPurchase;
    }

    public List<LottoDto> getLottoDtos() {
        return lottoDtos;
    }
}
