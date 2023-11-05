package lotto;

import lotto.util.RandomNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TddTest {

    @Test
    public void 로또는_한장에_천원() {
        Lottos lottos = new Lottos();
        int lottoCount = lottos.calculateLottoCount(8000);

        assertThat(lottoCount).isEqualTo(8);
    }

    @Test
    public void 로또_구매입력이_1000원_단위가_아닐때() {
        Lottos lottos = new Lottos();

        int money = 1500;
        assertThatThrownBy(() -> {
            lottos.calculateLottoCount(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 1000원 단위만 구매할 수 있습니다.");
    }

    @Test
    public void _1부터_45사이_로또번호_생성_테스트() {
        List<Integer> numbers = RandomNumbers.generateRandomNumbers();

        for (int number : numbers) {
                assertThat(number).isBetween(1, 45);
        }
    }
    @Test
    public void 로또_번호는_6자리() {
        List<Integer> numbers = RandomNumbers.generateRandomNumbers();
        Assertions.assertThat(numbers).hasSize(6);
    }

    @Test
    public void 로또_번호_5자리_오류() {
        List<Integer> numbers = RandomNumbers.generateRandomNumbers();

        assertThrows(AssertionError.class, () -> {
            assertThat(numbers.size()).isEqualTo(5);
        });
    }

}
