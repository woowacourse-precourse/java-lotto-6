package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호가 1~45사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 티켓 갯수만큼 로또를 구매한다")
    @Test
    void buyLottos() {
        // given
        Tickets tickets = Tickets.of(3);
        // when
        List<Lotto> lottos = Lotto.buyLottos(tickets);
        // then
        assertEquals(3, lottos.size());
    }

    @DisplayName("로또번호와 당첨번호의 일치하는 숫자 갯수를 구한다. 보너스 번호는 제외한다.")
    @Test
    void getMatchCount() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLottoNumber = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        // when
        int matchCount = lotto.getMatchCount(winningLottoNumber);
        // then
        assertEquals(5, matchCount);
    }

    @DisplayName("로또번호와 보너스번호가 겹치는지 확인한다.")
    @Test
    void checkDuplicateNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;
        // when
        boolean isDuplicate = lotto.checkDuplicateNumber(bonusNumber);
        // then
        assertTrue(isDuplicate);
    }

}