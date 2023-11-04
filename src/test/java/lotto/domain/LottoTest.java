package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복이 없고 6개면 에러가 발생하지 않는다.")
    @Test
    void createLottoSuccess() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> new Lotto(numbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호를 반환한다.")
    @Test
    void getNumbersTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            assertThat(lottoNumbers.get(i).getNumber()).isEqualTo(numbers.get(i));
        }
    }

    @DisplayName("로또 안에 특정 로또 번호가 있는지 확인한다.")
    @Test
    void containsTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber1 = new LottoNumber(7);
        LottoNumber lottoNumber2 = new LottoNumber(6);
        assertThat(lotto.contains(lottoNumber1)).isFalse();
        assertThat(lotto.contains(lottoNumber2)).isTrue();
    }

    @DisplayName("당첨 번호에 이미 보너스 번호가 존재하면 에러를 반환한다.")
    @Test
    void hasSameNumberTrueTest() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatCode(() -> winningNumbers.hasSameNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 보너스 번호가 존재하지 않으면 에러를 반환하지 않는다.")
    @Test
    void hasSameNumberFalseTest() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatCode(() -> winningNumbers.hasSameNumber(7))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호를 당첨 번호, 보너스 번호와 비교하여 등수를 반환한다.")
    @ParameterizedTest
    @MethodSource("rankTestArguments")
    void determineRankTest(Lotto purchasedLotto, Lotto winningNumbers, LottoNumber bonusNumber, RankPrize result) {
        RankPrize rankPrize = purchasedLotto.determineRank(winningNumbers, bonusNumber);
        assertThat(rankPrize).isEqualTo(result);
    }

    static Stream<Arguments> rankTestArguments() {
        return Stream.of(
                arguments(new Lotto(List.of(1, 3, 5, 7, 9, 11)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoNumber(7),
                        RankPrize.FIFTH_PLACE
                ),
                arguments(new Lotto(List.of(1, 3, 5, 7, 9, 2)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoNumber(7),
                        RankPrize.FOURTH_PLACE
                ),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoNumber(7),
                        RankPrize.THIRD_PLACE
                ),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoNumber(7),
                        RankPrize.SECOND_PLACE
                ),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoNumber(7),
                        RankPrize.FIRST_PLACE
                )
        );
    }
}
