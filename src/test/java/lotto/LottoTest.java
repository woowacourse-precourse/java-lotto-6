package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.model.AnswerLotto;
import lotto.model.Lotto;
import lotto.model.Score;
import org.junit.jupiter.api.BeforeAll;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_범위에_벗어날_경우() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_정렬() {
        Lotto lotto = new Lotto(List.of(4,5,3,6,2,1));
        assertEquals(lotto.toString(), "[1, 2, 3, 4, 5, 6]");
    }

    @Nested
    class 로또_개수_비교 {
        private static AnswerLotto answerLotto;

        @BeforeAll
        static void beforeAll() {
            answerLotto = new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        }

        @Test
        void 로또_1등() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            assertEquals(answerLotto.contains(lotto), Score.First);
        }

        @Test
        void 로또_2등() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            assertEquals(answerLotto.contains(lotto), Score.Second);
        }

        @Test
        void 로또_3등() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));
            assertEquals(answerLotto.contains(lotto), Score.Third);
        }

        @Test
        void 로또_4등() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 10, 7));
            assertEquals(answerLotto.contains(lotto), Score.Fourth);
        }

        @Test
        void 로또_5등() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 10, 20, 7));
            assertEquals(answerLotto.contains(lotto), Score.Fifth);
        }

        @Test
        void 로또_낙첨() {
            Lotto lotto_1 = new Lotto(List.of(1, 10, 20, 30, 40, 7));
            Lotto lotto_2 = new Lotto(List.of(1, 2, 20, 30, 40, 7));
            assertAll(
                    () -> assertEquals(answerLotto.contains(lotto_1), Score.Nothing),
                    () -> assertEquals(answerLotto.contains(lotto_2), Score.Nothing)
            );
        }
    }
}