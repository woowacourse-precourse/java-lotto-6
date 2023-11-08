package lotto.domain;

import static lotto.constant.NumberConstants.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private static final long TEST_MONEY = 10000;

    @DisplayName("입력된 금액 만큼의 로또를 생성한다.")
    @Test
    void shouldCreateLottosEqualToTheInputMoney() {
        // given
        long expectedQuantity = TEST_MONEY / LOTTO_PRICE;

        // when
        List<Lotto> lottos = new LottoGenerator(TEST_MONEY).generateLottos();

        // then
        assertThat(lottos).hasSize((int) expectedQuantity);
    }

    @DisplayName("로또를 생성했을때 오름차순으로 정렬된 로또를 생성한다.")
    @Test
    void shouldCreateLottosInAscendingOrder() {
        // given
        long expectedQuantity = TEST_MONEY / LOTTO_PRICE;

        // when
        List<Lotto> lottos = new LottoGenerator(TEST_MONEY).generateLottos();
        long sortedLottosCount = countSortedLottos(lottos);

        // then
        assertThat(sortedLottosCount).isEqualTo(expectedQuantity);
    }

    private long countSortedLottos(List<Lotto> lottos) {
        return lottos.stream()
                .filter(this::isAscendingOrder)
                .count();
    }

    private boolean isAscendingOrder(Lotto lotto) {
        List<Integer> numbers = lotto.numbers();
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < numbers.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

}
