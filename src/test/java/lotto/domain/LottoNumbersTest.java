package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


import static lotto.domain.LottoNumbers.randomsLottos;
import static lotto.util.ValidateMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoNumbersTest {
    @DisplayName("금액만큼 로또 생성한다.")
    @Test
    void createLottoAmountByLottos() {
        // given
        String money = "8000";
        int count = Integer.parseInt(money) / 1000;

        // when
        LottoAmount lottoAmount = new LottoAmount(money);
        List<Lotto> lottos = randomsLottos(lottoAmount);

        // then
        assertThat(lottos.size()).isEqualTo(count);
    }
    @DisplayName("로또가 오름차순 정렬되어있는지 확인.")
    @Test
    void createLottoBySort() {
        // given
        String money = "8000";

        // when
        LottoAmount lottoAmount = new LottoAmount(money);
        List<Lotto> lottos = randomsLottos(lottoAmount);

        // then
        for (Lotto lotto : lottos) {
            assertTrue(isSorted(lotto.getNumber()));
        }
    }
    private boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

}
