package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Nested
    @DisplayName("Lottos의 save 기능을 테스트")
    class saveTest {

        @Test
        @DisplayName("저장된 개수가 올바른지 테스트 한다.")
        void testCorrectNumberOfItemsStored() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            Lottos lottos = new Lottos();
            Lotto firestLotto = new Lotto(numbers);
            Lotto secondLotto = new Lotto(numbers);
            Lotto thirdLotto = new Lotto(numbers);

            lottos.save(firestLotto);
            lottos.save(secondLotto);
            lottos.save(thirdLotto);

            assertThat(lottos.getLottos().size()).isEqualTo(3);
        }

        @Test
        @DisplayName("Lottos 객체에 Lotto 객체가 잘 저장이 되는지 테스트 한다.")
        void testLottoSave() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            Lotto lotto = new Lotto(numbers);
            Lottos lottos = new Lottos();

            lottos.save(lotto);

            assertThat(lottos.getLottos().get(0)).isEqualTo(lotto);
        }
    }
}