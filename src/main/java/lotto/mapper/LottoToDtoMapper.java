package lotto.mapper;

import java.util.List;
import lotto.controller.dto.output.LottoDto;
import lotto.controller.dto.output.LottosBuyingResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.opened.LottosOpened;

/**
 * Lotto 관련 Dto -> 도메인 객체로 변환하는 Mapper
 */
public final class LottoToDtoMapper {

    /**
     * 외부 생성 제한
     */
    private LottoToDtoMapper() {
    }

    /**
     * Lottos(Domain) -> LottosBuyingResult(Dto) 변환
     */
    public static LottosBuyingResult mapFrom(final Lottos lottos) {
        final LottosOpened lottosOpened = lottos.toOpened();
        final List<LottoDto> lottoDtos = lottosOpened.getLottos()
                .stream()
                .map(LottoToDtoMapper::mapFrom)
                .toList();

        return new LottosBuyingResult(lottoDtos, lottosOpened.size());
    }

    /**
     * Lotto(Domain) -> LottoDto 변환
     */
    private static LottoDto mapFrom(final Lotto lotto) {
        final List<Integer> numbers = lotto.toOpened()
                .getNumbers();

        return new LottoDto(numbers);
    }
}
