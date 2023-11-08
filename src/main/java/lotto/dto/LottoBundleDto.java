package lotto.dto;

import java.util.List;
import lotto.LottoBundle;

public record LottoBundleDto(List<LottoDto> lottos) {
    public static LottoBundleDto from(LottoBundle lottoBundle) {
        List<LottoDto> lottos = lottoBundle.getLottos().stream()
                .map(LottoDto::from)
                .toList();

        return new LottoBundleDto(lottos);
    }
}
