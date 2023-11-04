package lotto.util;

import lotto.domain.lotto.Lotto;
import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoFactoryTest {

    @Test
    @DisplayName("1에서 45 사이의 임의의 로또를 받을 수 있다.")
    public void getLotto() {
        // when
        Lotto lotto = LottoFactory.getLotto();
        // then
        List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
    }

    @Test
    @DisplayName("오름차순으로 정렬된 숫자가 아니면 예외가 발생한다.")
    public void getLottoException() {
        // when // then
        assertThatThrownBy(() -> LottoFactory.getLotto(List.of(1, 2, 21, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBERS_NOT_SORTED.getMessage());
    }

    @Test
    @DisplayName("로또 번호의 개수는 6개이다.")
    public void lottoNumberTest() {
        // when
        Lotto lotto = LottoFactory.getLotto();
        // then
        List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers).hasSize(6);
    }

    @Test
    @DisplayName("로또의 번호는 처음부터 오름차순으로 정렬된다.")
    public void lottoNumberSortedTest() {
        // when
        Lotto lotto = LottoFactory.getLotto();
        // then
        List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers).isSorted();
    }

}