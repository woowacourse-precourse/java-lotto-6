package lotto.domain;

import lotto.dto.LottoReturnsRateDTO;
import lotto.dto.LottoWinningResultDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {

    @Test
    void 당첨_로또_번호와_보너스_번호가_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoResult.create(new Lotto(List.of(1, 2, 3, 4, 5, 6)), BonusNumber.create(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_당첨_결과를_반환한다() {
        var lottoResult = LottoResult.create(new Lotto(List.of(1, 2, 3, 4, 5, 6)), BonusNumber.create(7));
        var lottos = List.of(
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        assertEquals(lottoResult.calculateResult(lottos).lottoWinningResultDTOs(),
                List.of(
                        new LottoWinningResultDTO(0, false),
                        new LottoWinningResultDTO(3, false),
                        new LottoWinningResultDTO(4, false),
                        new LottoWinningResultDTO(5, false),
                        new LottoWinningResultDTO(5, true),
                        new LottoWinningResultDTO(6, false)
                )
        );
    }

    @Test
    void 로또_당첨_수익률을_반환한다() {
        var lottoResult = LottoResult.create(new Lotto(List.of(1, 2, 3, 4, 5, 6)), BonusNumber.create(7));
        var lottos = List.of(
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        assertEquals(lottoResult.calculateResult(lottos).lottoReturnsRateDTO(),
                new LottoReturnsRateDTO(3.385925E7)
        );
    }
}