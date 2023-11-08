package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.dto.PurchasedLottoDto;
import lotto.dto.WinningLottoDto;
import lotto.service.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasedLottoTest {
    @DisplayName("구매한 로또 DTO 생성 성공시 통과")
    @Test
    void success_ToDto() {
        PurchasedLotto purchasedLotto = new PurchasedLotto(List.of(1, 2, 3, 4, 5, 6));
        PurchasedLottoDto dto = purchasedLotto.toDto();
        assertThat(dto.numbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @DisplayName("당첨 번호와 번호 비교 후 올바른 등수를 가지면 통과")
    @Test
    void success_compare() {
        // give
        WinningLottoDto winningLottoDto = new WinningLottoDto(List.of(1,2,3,4,5,6), 7);
        PurchasedLotto purchasedLotto = new PurchasedLotto(List.of(1,2,3,4,5,7));
        // when
        purchasedLotto.compare(winningLottoDto);
        PurchasedLottoDto purchasedLottoDto = purchasedLotto.toDto();
        // then
        assertThat(purchasedLottoDto.rank()).isEqualTo(LottoRank.SECOND);
    }
}