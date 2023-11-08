package lotto;

import lotto.domain.Lotto;
import lotto.util.LottoGenerator;
import lotto.util.Referee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    // 아래에 추가 테스트 작성 가능
    @Test
    public void 로또생성() throws Exception {
        // given
        int purchaseCount = 5;

        // when
        List<Lotto> lottos = LottoGenerator.createLottos(purchaseCount);

        // then
        Assertions.assertEquals(lottos.size(), purchaseCount);
    }

    @Test
    public void 당첨개수() throws Exception {
        // given
        int bonus = 5;
        Lotto answer = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto lotto2 = new Lotto(List.of(11, 22, 13, 17, 18, 19));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto1);
        lottos.add(lotto2);

        // when
        int[] winning = Referee.compareToLottos(lottos, answer, bonus);

        // then
        Assertions.assertEquals(winning.length, 5);
        Assertions.assertEquals(winning[0], 1); // 3개 일치하는 것 1개 존재
    }

    @Test
    public void 수익률() throws Exception {
        // given
        int purchaseCount = 8; // 8000원
        int[] winning = {1, 0, 0, 0, 0}; // 3개 일치하는 것 1개 존재(5000원 짜리)

        // when
        double income = Referee.calculateIncome(winning, purchaseCount);

        // then
        Assertions.assertEquals(income, 62.5); // 62.5% 수익률
    }
}