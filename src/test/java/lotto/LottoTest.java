package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    @DisplayName("[Lotto] 기능 테스트")
    class LottoUnitTest {

        @Test
        @DisplayName("발행된 로또 번호 출력 확인")
        void toString_발행된_로또_번호_출력_확인() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            assertThat(lotto.toString())
                    .isEqualTo("[1, 2, 3, 4, 5, 6]");
        }

        @Test
        @DisplayName("발행된 로또 번호 오름차순 출력 확인")
        void toString_발행된_로또_번호_오름차순_출력_확인() {
            Lotto lotto = new Lotto(List.of(1, 4, 2, 5, 3, 6));

            assertThat(lotto.toString())
                    .isEqualTo("[1, 2, 3, 4, 5, 6]");
        }

        @Test
        @DisplayName("로또에 특정 번호가 있는 경우를 확인")
        void check_로또에_특정_번호가_있는_경우를_확인() {
            List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
            Integer bonusNumber = 5;

            Lotto lotto = new Lotto(lottoNumbers);

            assertThat(lotto.contains(bonusNumber))
                    .isTrue();
        }
    }
}