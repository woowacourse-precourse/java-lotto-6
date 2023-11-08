package lotto.repository;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoRepositoryTest {



    @DisplayName("구매한 로또의 번호와 당첨번호가 몇개 맞는지 계산해 줍니다.")
    @Test
    void countMatchingNumber() {
        // given
        // 당첨번호와 보너스번호를 winningLottoRepository에 넣어준다
        Lotto winningLotto = new Lotto(List.of(1, 4, 5, 7, 17, 26));
        BonusNumber bonusNumber = BonusNumber.from(winningLotto, 16);
        WinningLottoRepository winningLottoRepository = WinningLottoRepository.of(winningLotto, bonusNumber);
        //복권을 구매한다
        Lotto buyLotto = new Lotto(List.of(1, 26, 4, 5, 6, 7));

        // then
        Assertions.assertThat(winningLottoRepository.countMatchingNumber(buyLotto)).isEqualTo(5);

    }
}