package lotto.mapper;

import lotto.controller.dto.input.DrawLottosDto;
import lotto.domain.lotto.WinningLotto;

/**
 * Dto와 Domain 간의 매핑을 담당
 */
public final class dtoToLottoMapper {


    /**
     * DrawLottosDto -> WinningLotto(Domain) 변환
     */
    public static WinningLotto mapFrom(final DrawLottosDto dto) {
        return new WinningLotto(dto.getLottoNumbers(), dto.getBonusNumber());
    }

}
