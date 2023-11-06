package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

    @DisplayName("다른 로또와 일치하는 번호의 개수를 구할 수 있다.")
    @ParameterizedTest
    @MethodSource("matchData")
    void matchCount(Lotto lotto, Lotto targetLotto, int count) {
        assertThat(lotto.matchCount(targetLotto)).isEqualTo(count);
    }

    @Test
    @DisplayName("특정 로또 번호가 해당 로또에 존재하는 지 알 수 있다.")
    void hasNumber(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.hasNumber(new LottoNumber(1))).isTrue();
    }

    static Stream<Arguments> matchData() {
        return Stream.of(
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7)), 5),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 8, 7)), 4),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 8, 23, 24)), 3),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 22, 12, 33, 23)), 2),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 23, 32, 12, 34, 35)), 1),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(17, 23, 32, 12, 34, 35)), 0)
        );
    }

}