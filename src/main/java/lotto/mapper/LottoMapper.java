package lotto.mapper;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.dto.input.DrawLottosDto;
import lotto.controller.dto.output.LottoDto;
import lotto.controller.dto.output.LottosBuyingResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lotto.boxed.LottoNumber;

/**
 * Dto와 Domain 간의 매핑을 담당
 */
public final class LottoMapper {

    /**
     * Lottos(Domain) -> LottosBuyingResult(Dto) 변환
     */
    public static LottosBuyingResult mapFrom(final Lottos lottos) {
        final List<LottoDto> lottoDtos = new ArrayList<>();

        while (lottos.isNotEmpty()) {
            final Lotto lotto = lottos.nextLotto().get();
            lottoDtos.add(toLottoDto(lotto));
        }

        return new LottosBuyingResult(lottoDtos, lottoDtos.size());
    }

    /**
     * DrawLottosDto -> WinningLotto(Domain) 변환
     */
    public static WinningLotto mapFrom(final DrawLottosDto dto) {
        return new WinningLotto(dto.getLottoNumbers(), dto.getBonusNumber());
    }

    /**
     * Lotto(Domain) -> LottoDto 변환
     */
    private static LottoDto toLottoDto(final Lotto lotto) {
        final List<Integer> numbers = lotto.getNumbers()
                .stream()
                .map(LottoNumber::getValue)
                .toList();

        return new LottoDto(numbers);
    }
}
