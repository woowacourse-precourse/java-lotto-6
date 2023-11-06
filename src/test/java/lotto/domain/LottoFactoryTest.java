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

class LottoFactoryTest {

    @DisplayName("투입한 금액에 수량에 맞는 로또가 발행된다.")
    @Test
    void create() {
        // given
        Money money = Money.of(5000);

        // when
        LottoFactory lottoFactory = LottoFactory.of(new RandomNumberGenerator(), money);

        // then
        assertThat(lottoFactory.getLottoNumbers()).hasSize(money.calculateLottoCount());
    }

    @DisplayName("로또 결과 등수의 수량을 계산할 수 있다.")
    @ParameterizedTest
    @MethodSource("lottoDataProvider")
    void calculateResult(List<Integer> lotto, int bonusNumber, Rank rank, int count) {
        // given
        LottoFactory lottoFactory = LottoFactory.of(() -> List.of(1, 2, 3, 4, 5, 6), Money.of(6000));
        AnswerLotto answerLotto = AnswerLotto.of(new Lotto(lotto), bonusNumber);

        // when
        Result result = lottoFactory.calculateResult(answerLotto);

        // then
        assertThat(result.getRankCount().get(rank)).isEqualTo(count);
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
        LottoFactory lottoFactory = LottoFactory.of(() -> List.of(1, 2, 3, 4, 5, 6), Money.of(4000));

        // when
        List<String> lottoNumbers = lottoFactory.getLottoNumbers();

        // then
        lottoNumbers.forEach(lotto -> assertThat(lotto).isEqualTo("[1, 2, 3, 4, 5, 6]"));
    }

}