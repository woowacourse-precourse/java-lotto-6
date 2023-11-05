package lotto.dto;

import java.util.List;
import lotto.domain.Lotteries;

public record LotteriesDto(List<LottoDto> lottos) {

    public static LotteriesDto from(Lotteries lotteries) {
        List<LottoDto> lottoDtos = lotteries.getLottos().stream()
                .map(LottoDto::new).toList();

        return new LotteriesDto(lottoDtos);
    }

    public int getSize() {
        return lottos.size();
    }
}
