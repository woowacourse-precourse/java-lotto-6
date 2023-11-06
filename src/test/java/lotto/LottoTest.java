package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
    @DisplayName("로또 번호의 일치 개수에 따라 상금이 주어진다.")
    @ParameterizedTest
    @MethodSource("provideLottoAndPrizeMoney")
    void getPrize(Lotto lotto, int prizeMoney) {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when, then
        assertThat(lotto.getPrize(winningNumbers, bonusNumber)).isEqualTo(prizeMoney);
    }

    private static Stream<Arguments> provideLottoAndPrizeMoney() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 2000000000),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), 30000000),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), 1500000)
        );
    }

    @DisplayName("발행된 로또 번호는 문자열 형태로 출력되어야 한다.")
    @Test
    void lottoToString() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        String lottoNumbers = lotto.toString();

        // then
        assertThat(lottoNumbers).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}