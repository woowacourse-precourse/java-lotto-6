package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.dto.WinningLottoDto;
import lotto.service.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("당첨 로또 DTO 생성 성공시 통과")
    @Test
    void success_ToDto() {
        // give
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        // when
        WinningLottoDto winningLottoDto = winningLotto.toDto();
        // then
        assertThat(winningLottoDto.numbers()).isEqualTo(List.of(1,2,3,4,5,6));
        assertThat(winningLottoDto.bonusNumber()).isEqualTo(7);
    }

    @DisplayName("로또 번호 비교 시작시 옵저버에게 자신의 번호와 비교하게 해서 옵저버가 올바른 등수를 가지면 통과")
    @Test
    void success_StartCompare() {
        // give
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        PurchasedLotto purchasedLotto = new PurchasedLotto(List.of(1,2,3,4,5,6));
        // when
        winningLotto.addObserver(purchasedLotto);
        winningLotto.startCompare();
        // then
        assertThat(purchasedLotto.toDto().rank()).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("등록한 옵저버 제거 성공시 통과")
    @Test
    void success_RemoveObserver() {
        // give
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        PurchasedLotto purchasedLotto = new PurchasedLotto(List.of(1,2,3,4,5,6));
        // when
        winningLotto.addObserver(purchasedLotto);
        winningLotto.removeObserver(purchasedLotto);
        winningLotto.startCompare();
        // then
        assertThat(purchasedLotto.toDto().rank()).isEqualTo(LottoRank.NONE);
    }
}