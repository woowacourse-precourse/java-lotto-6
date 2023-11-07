package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("로또 한 장 테스트")
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

    // 아래에 추가 테스트 작성 가능
    private static final List<Integer> SUCCESSFUL_LOTTO_NUMBERS = List.of(1, 8, 12, 15, 23, 36);

    @Nested
    @DisplayName("로또 번호 생성 테스트")
    class LottoNumberCreationTest {
        @DisplayName("정상 작동")
        @Test
        void success() {
            Lotto lotto = new Lotto(SUCCESSFUL_LOTTO_NUMBERS);
            assertThat(lotto.toString()).isEqualTo(SUCCESSFUL_LOTTO_NUMBERS.toString());
        }

        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {
            private final List<Integer> LESS_SIZE_LOTTO_NUMBER = List.of(1, 2, 3, 4, 5);
            private final List<Integer> EXCEED_SIZE_LOTTO_NUMBER = List.of(1, 2, 3, 4, 5);
            private final List<Integer> DUPLICATION_LOTTO_NUMBER = List.of(1, 2, 3, 3, 6, 10);

            @DisplayName("로또 번호 개수가 6개 미만일 때 예외 테스트")
            @Test
            void lessSizeExceptionTest() {
                assertThatThrownBy(() -> new Lotto(LESS_SIZE_LOTTO_NUMBER))
                        .isInstanceOf(IllegalArgumentException.class);
            }

            @DisplayName("로또 번호 개수가 6개 초과일 때 예외 테스트")
            @Test
            void exceedSizeExceptionTest() {
                assertThatThrownBy(() -> new Lotto(EXCEED_SIZE_LOTTO_NUMBER))
                        .isInstanceOf(IllegalArgumentException.class);
            }

            @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
            @Test
            void duplicationExceptionTest() {
                assertThatThrownBy(() -> new Lotto(DUPLICATION_LOTTO_NUMBER))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("로또 등수 구하기 테스트")
    class LottoRankingTest {
        private static final List<Integer> WINNING_NUMBERS = List.of(1, 3, 12, 15, 26, 36);
        private static final int BONUS_NUMBER = 23;
        private static final List<Integer> FIRST_RANK_LOTTO_NUMBERS = List.of(1, 3, 12, 15, 26, 36);
        private static final List<Integer> SECOND_RANK_LOTTO_NUMBERS = List.of(1, 3, 12, 15, 23, 36);
        private static final List<Integer> THIRD_RANK_LOTTO_NUMBERS = List.of(1, 3, 12, 15, 25, 36);
        private static final List<Integer> FOURTH_RANK_LOTTO_NUMBERS = List.of(1, 3, 12, 13, 25, 36);
        private static final List<Integer> FIFTH_RANK_LOTTO_NUMBERS = List.of(1, 3, 13, 25, 36, 45);
        private static final List<Integer> NO_RANK_LOTTO_NUMBERS = List.of(1, 2, 13, 25, 36, 45);

        @Test
        @DisplayName("6개 로또 번호가 당첨 번호와 모두 맞다면 1등이다")
        void firstRankingTest() {
            Lotto lotto = new Lotto(FIRST_RANK_LOTTO_NUMBERS);
            Ranking ranking = lotto.getRanking(WINNING_NUMBERS, BONUS_NUMBER);
            assertThat(ranking).isEqualTo(Ranking.FIRST_RANKING);
        }

        @Test
        @DisplayName("6개 로또 번호가 5개의 당첨 번호와 일치하고 보너스 번호와 일치하다면 2등이다")
        void secondRankingTest() {
            Lotto lotto = new Lotto(SECOND_RANK_LOTTO_NUMBERS);
            Ranking ranking = lotto.getRanking(WINNING_NUMBERS, BONUS_NUMBER);
            assertThat(ranking).isEqualTo(Ranking.SECOND_RANKING);
        }

        @Test
        @DisplayName("6개 로또 번호가 5개의 당첨 번호와 일치하고 보너스 번호와 일치하지 않는다면 3등이다")
        void thirdRankingTest() {
            Lotto lotto = new Lotto(THIRD_RANK_LOTTO_NUMBERS);
            Ranking ranking = lotto.getRanking(WINNING_NUMBERS, BONUS_NUMBER);
            assertThat(ranking).isEqualTo(Ranking.THIRD_RANKING);
        }

        @Test
        @DisplayName("6개 로또 번호가 4개의 당첨 번호와 일치하면 4등이다")
        void fourthRankingTest() {
            Lotto lotto = new Lotto(FOURTH_RANK_LOTTO_NUMBERS);
            Ranking ranking = lotto.getRanking(WINNING_NUMBERS, BONUS_NUMBER);
            assertThat(ranking).isEqualTo(Ranking.FOURTH_RANKING);
        }

        @Test
        @DisplayName("6개 로또 번호가 3개의 당첨 번호와 일치하면 5등이다")
        void fifthRankingTest() {
            Lotto lotto = new Lotto(FIFTH_RANK_LOTTO_NUMBERS);
            Ranking ranking = lotto.getRanking(WINNING_NUMBERS, BONUS_NUMBER);
            assertThat(ranking).isEqualTo(Ranking.FIFTH_RANKING);
        }

        @Test
        @DisplayName("6개 로또 번호가 3개의 미만의 당첨 번호와 일치하면 당첨되지 않는다")
        void noRankingTest() {
            Lotto lotto = new Lotto(NO_RANK_LOTTO_NUMBERS);
            Ranking ranking = lotto.getRanking(WINNING_NUMBERS, BONUS_NUMBER);
            assertThat(ranking).isEqualTo(Ranking.NO_RANK);
        }
    }
}