package lotto.service.mapper;

import java.util.List;
import lotto.controller.dto.output.LottoDto;
import lotto.controller.dto.output.LottosBuyingResult;
import lotto.controller.dto.output.LottosDrawingResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoDrawingData;
import lotto.domain.lotto.LottoPrize;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.boxed.LottoNumber;
import lotto.domain.lotto.opened.LottoOpened;
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
     * LottoOpened -> LottoDto 변환
     */
    private static LottoDto mapFrom(final LottoOpened lottoOpened) {
        final List<Integer> numbers = lottoOpened.getNumbers()
                .stream()
                .map(LottoNumber::getValue)
                .toList();

        return new LottoDto(numbers);
    }

    /**
     * LottosDrawData -> LottosDrawingResult
     */
    public static LottosDrawingResult mapFrom(final LottoDrawingData data) {
        return new LottosDrawingResult(
                data.get(LottoPrize.FIRST),
                data.get(LottoPrize.SECOND),
                data.get(LottoPrize.THIRD),
                data.get(LottoPrize.FOURTH),
                data.get(LottoPrize.FIFTH),
                data.calculateReturnOfRate()
        );
    }

    /**
     * Lotto(Domain) -> LottoDto 변환
     */
    private static LottoDto mapFrom(final Lotto lotto) {
        final List<Integer> numbers = lotto.toOpened()
                .getNumbers()
                .stream()
                .map(LottoNumber::getValue)
                .toList();

        return new LottoDto(numbers);
    }

}
