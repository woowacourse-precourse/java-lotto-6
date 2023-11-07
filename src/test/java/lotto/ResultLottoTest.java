package lotto;


import java.util.ArrayList;
import lotto.model.Lotto;
import lotto.model.ResultLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultLottoTest {

    @DisplayName("보너스 번호가 0 아래면 오류가 발생한다.")
    @Test
    void checkBonusNumUnderRange() {
        assertThatThrownBy(() -> new ResultLotto(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45보다 크면 오류가 발생한다.")
    @Test
    void checkBonusNumUpRange() {
        assertThatThrownBy(() -> new ResultLotto(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 겹치면 오류가 발생한다.")
    @Test
    void checkBonusNumDuplicate() {
        assertThatThrownBy(() -> new ResultLotto(List.of(1, 2, 3, 4, 5, 6), 4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1등인 상황에서 등수를 체크한다")
    @Test
    void checkWhenFirstRanking() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoBundle = new ArrayList<>();
        lottoBundle.add(lotto);
        ResultLotto resultLotto = new ResultLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        //when
        List<Integer> winning = resultLotto.calculateResult(lottoBundle);

        //then
        Assertions.assertThat(winning.get(4)).isEqualTo(1);

    }

    @DisplayName("1등인 상황에서 금액을 체크한다")
    @Test
    void checkWhenFirstMoney() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoBundle = new ArrayList<>();
        lottoBundle.add(lotto);
        ResultLotto resultLotto = new ResultLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        //when
        List<Integer> winning = resultLotto.calculateResult(lottoBundle);

        //then
        Assertions.assertThat(winning.get(5)).isEqualTo(2000000000);

    }

}
