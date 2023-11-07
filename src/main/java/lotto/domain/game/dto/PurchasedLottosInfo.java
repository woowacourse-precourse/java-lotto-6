package lotto.domain.game.dto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

import java.util.List;

public record PurchasedLottosInfo(
        int count,
        List<List<Integer>> lottoNumbers // 직렬화/역직렬화, 데이터 은닉, 간결성을 위해 일급 컬렉션 사용 X
) {
    public static PurchasedLottosInfo from(final Lottos lottos) {
        return new PurchasedLottosInfo(
                lottos.lottos().size(),
                lottos.lottos().stream()
                        .map(Lotto::getLottoInfo)
                        .toList()
        );
    }
}
