package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import lotto.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {

    @DisplayName("로또 결과 등수의 수량을 계산할 수 있다.")
    @ParameterizedTest
    @MethodSource("lottoDataProvider")
    void calculateResult(List<Integer> lotto, int bonusNumber, Rank targetRank, int targetCount) {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto6 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> givenLottos = List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);

        Lottos lottos = Lottos.from(givenLottos);
        AnswerLotto answerLotto = AnswerLotto.of(new Lotto(lotto), bonusNumber);

        // when
        Result result = lottos.calculateResult(answerLotto);

        // then
        assertThat(result.getRankCount().values().stream().mapToLong(count -> count).sum()).isEqualTo(6);
        assertThat(result.getRankCount().get(targetRank)).isEqualTo(targetCount);
    }

    static Stream<Arguments> lottoDataProvider() {
        return Stream.of(
                arguments(List.of(1, 8, 9, 10, 11, 12), 6, Rank.NONE, 6),
                arguments(List.of(1, 2, 8, 9, 10, 11), 6, Rank.NONE, 6),
                arguments(List.of(1, 2, 3, 8, 9, 10), 6, Rank.FIFTH, 6),
                arguments(List.of(1, 2, 3, 4, 8, 9), 6, Rank.FOURTH, 6),
                arguments(List.of(1, 2, 3, 4, 5, 8), 9, Rank.THIRD, 6),
                arguments(List.of(1, 2, 3, 4, 5, 7), 6, Rank.SECOND, 6),
                arguments(List.of(1, 2, 3, 4, 5, 6), 7, Rank.FIRST, 6)
        );
    }

    @DisplayName("로또 번호 리스트를 반활 할 수 있다.")
    @Test
    void getLottoNumbers() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto6 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> givenLottos = List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);

        Lottos lottos = Lottos.from(givenLottos);

        // when
        List<String> lottoNumbers = lottos.getLottoNumbers();

        // then
        lottoNumbers.forEach(lotto -> assertThat(lotto).isEqualTo("[1, 2, 3, 4, 5, 6]"));
    }

}