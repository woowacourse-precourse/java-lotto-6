package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(
                IntStream.of(1, 2, 3, 4, 5, 6, 7)
                        .mapToObj(LottoBall::new)
                        .toList())
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(
                IntStream.of(1, 2, 3, 4, 5, 5)
                        .mapToObj(LottoBall::new)
                        .toList())
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("로또 안에 같은 공이 들어가있는지 여부를 올바르게 출력한다.")
    public void lottoContains(int number) {
        // given
        List<LottoBall> balls = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoBall::new)
                .toList();
        Lotto lotto = new Lotto(balls);

        // when, then
        Assertions.assertDoesNotThrow(() -> {
            lotto.contains(new LottoBall(number));
        });
    }

    @Test
    public void matchCount() {
        // given
        List<LottoBall> balls = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoBall::new)
                .toList();
        Lotto lotto = new Lotto(balls);

        Lotto secondLotto = new Lotto(
                IntStream.rangeClosed(3, 8)
                        .mapToObj(LottoBall::new)
                        .toList()
        );
        // when
        int matchedCount = lotto.getMatchedCount(secondLotto);
        // then
        assertThat(matchedCount).isEqualTo(4);
    }
}
