package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class LottoTest {

    @Nested
    @DisplayName("로또 생성 테스트")
    class createLottoTest {
        @DisplayName("로또가 잘 생성된다")
        @Test
        void createLotto() {
            List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

            Lotto lotto = new Lotto(validNumbers);

            assertThat(lotto).isNotNull();
        }

        @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        @Test
        void createLottoByOverSize() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("로또 번호는 6자리여야 합니다.");
        }

        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void createLottoByDuplicatedNumber() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("로또 번호는 중복되지 않아야 합니다.");
        }

        @DisplayName("로또 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
        @Test
        void createLottoByOutOfRange() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }


    }

    @Nested
    @DisplayName("로또 번호 일치 테스트")
    class matchedTest {
        @DisplayName("로또의 일치하는 숫자 개수를 올바르게 계산한다.")
        @Test
        void countMatchedNumbers() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto winningNumber = new Lotto(List.of(1, 2, 3, 7, 8, 9));

            long count = lotto.countMatchedNumbers(winningNumber);

            assertThat(count).isEqualTo(3);
        }

        @DisplayName("보너스 번호 일치 여부를 올바르게 판별한다.")
        @Test
        void isBonusMatch() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            assertThat(lotto.isBonusMatch(6)).isTrue();
            assertThat(lotto.isBonusMatch(7)).isFalse();
        }
    }

    @Nested
    @DisplayName("문자열 변환 테스트")
    class convertToStringTest {
        @DisplayName("로또의 구매한 번호를 올바르게 문자열로 반환한다.")
        @Test
        void getPurchaseLotto() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            assertThat(lotto.getPurchaseLotto()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        }

    }


}