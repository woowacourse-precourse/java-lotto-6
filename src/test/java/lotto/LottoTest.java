package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
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

    @Test
    void 로또_번호_개수_테스트() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        Assertions.assertEquals(6, lotto.getNumbers().size());
    }

    @Test
    void 로또_번호_범위_테스트() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        Assertions.assertTrue(numbers.stream().allMatch(n -> n >= 1 && n <= 45));
    }

    @Test
    void 로또_번호_중복_테스트() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        Assertions.assertEquals(6, new HashSet<>(numbers).size());
    }

    @Test
    void 구매금액_검증_테스트() {
        // 구매금액이 0보다 작거나 1000의 배수가 아닐 경우 IllegalArgumentException이 발생해야 한다.
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoGame(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoGame(999));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoGame(1001));
    }

    @Test
    void 로또_생성_테스트() {
        // 구매금액이 10000일 경우 10개의 로또가 생성되어야 한다.
        LottoGame lottoGame = new LottoGame(10000);
        Assertions.assertEquals(10, lottoGame.lottos.size());

        // 각 로또의 번호는 1에서 45 사이의 숫자이어야 한다.
        for (Lotto lotto : lottoGame.lottos) {
            Assertions.assertTrue(lotto.getNumbers().stream().allMatch(n -> n >= 1 && n <= 45));
        }
    }

}