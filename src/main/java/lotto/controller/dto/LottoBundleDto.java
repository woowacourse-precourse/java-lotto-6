package lotto.controller.dto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;

public record LottoBundleDto(
        List<List<Integer>> lottoNumbersBundle,
        int size
) {

    public static LottoBundleDto of(LottoBundle lottoBundle) {
        return new LottoBundleDto(
                lottoBundle.getLottos()
                        .stream()
                        .map(Lotto::getNumbers)
                        .toList(),
                lottoBundle.size()
        );
    }
}
