package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 당첨 결과 확인 기능")
public class WinningLottoTest {

    @ParameterizedTest
    @MethodSource("countMatchingNumbersData")
    @DisplayName("로또 하나와 당첨 로또를 비교한다.")
    void 로또_당첨로또_비교_정상처리(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonus, long matchCount) {
        Lotto lotto = new Lotto(lottoNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);
        long countMatchingNumbers = lotto.countMatchingNumbers(winningLotto);

        Assertions.assertThat(countMatchingNumbers).isEqualTo(matchCount);
    }

    static Stream<Arguments> countMatchingNumbersData() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6), 7, 6),
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 45), 6, 5),
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 42, 43, 44), 45, 3),
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(39, 40, 41, 42, 43, 44), 45, 0)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("보너스 번호가 로또 번호에 존재하는 경우")
    void 보너스번호_확인_존재_정상처리(int bonusNumber) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 43, 44, 45));

        Assertions.assertThat(lotto.isInNumbers(bonusNumber)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    @DisplayName("보너스 번호가 로또 번호에 없는 경우")
    void 보너스번호_확인_없음_정상처리(int bonusNumber) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 43, 44, 45));

        Assertions.assertThat(lotto.isInNumbers(bonusNumber)).isFalse();
    }

    @ParameterizedTest
    @MethodSource("checkLottoResultData")
    @DisplayName("로또 등수를 구할 수 있다.")
    void 등수_정상처리(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonus, LottoRanking lottoRanking) {
        Lotto lotto = new Lotto(lottoNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);
        LottoRanking lottoResult = winningLotto.checkLottoResult(lotto);

        Assertions.assertThat(lottoResult).isEqualTo(lottoRanking);
    }

    static Stream<Arguments> checkLottoResultData() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6), 7, LottoRanking.FIRST_PRIZE),
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 45), 6, LottoRanking.SECOND_PRIZE),
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 44), 45, LottoRanking.THIRD_PRIZE),
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(39, 40, 41, 42, 43, 44), 45, LottoRanking.DID_NOT_WIN)
        );
    }
}
