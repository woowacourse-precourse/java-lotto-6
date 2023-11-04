package lotto.mapper;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.dto.LottosBuyingResult;
import lotto.controller.dto.input.DrawLottosDto;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;

/**
 * Dto와 Domain 간의 매핑을 담당
 */
public final class LottoMapper {

    /**
     * Lottos(Domain) -> LottosBuyingResult(Dto) 변환
     */
    public static LottosBuyingResult mapFrom(final Lottos lottos) {
        final List<Lotto> lottosList = new ArrayList<>();

        while (lottos.isNotEmpty()) {
            final Lotto lotto = lottos.nextLotto().get();
            lottosList.add(lotto);
        }

        return new LottosBuyingResult(lottosList, lottosList.size());
    }

    /**
     * DrawLottosDto -> WinningLotto(Domain) 변환
     */
    public WinningLotto mapFrom(final DrawLottosDto dto) {
        return new WinningLotto(dto.getLottoNumbers(), dto.getBonusNumber());
    }
}
