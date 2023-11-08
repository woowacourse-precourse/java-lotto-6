package lotto.service.mapper;

import lotto.domain.lotto.WinningLotto;
import lotto.controller.dto.input.DrawLottosInput;

/**
 * Dto와 Domain 간의 매핑을 담당
 */
public final class LottoFromDtoMapper {


    /**
     * DrawLottosDto -> WinningLotto(Domain) 변환
     */
    public static WinningLotto from(final DrawLottosInput dto) {
        return new WinningLotto(dto.getLottoNumbers(), dto.getBonusNumber());
    }

}
