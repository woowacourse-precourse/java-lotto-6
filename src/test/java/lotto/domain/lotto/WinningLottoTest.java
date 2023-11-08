package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import lotto.domain.Rank;
import lotto.global.constant.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @ParameterizedTest
    @MethodSource("validBonusNumberDuplicationParameters")
    void 당첨_번호와_보너스_번호가_중복되면_예외_발생(List<Integer> winningNumbers, int bonusNum) {
        BonusNumber bonusNumber = new BonusNumber(bonusNum);
        WinningLotto winningLotto = new WinningLotto(winningNumbers);

        Assertions.assertThatThrownBy(() -> winningLotto.checkDuplicationWithBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_DUPLICATION_ERROR.getText());
    }

    static Stream<Arguments> validBonusNumberDuplicationParameters() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(11, 22, 33, 44, 35, 27), 27),
                Arguments.of(List.of(11, 22, 33, 44, 41, 45), 45)
        );
    }

    @ParameterizedTest
    @MethodSource("validLottoNumbersCompareParameters")
    void 당첨_로또번호와_보너스_번호를_구매한_로또번호와_비교했을때_랭킹을_리턴한다(List<Integer> winningNumbers, int bonusNum,
                                                   List<Integer> lottoNumbers, Rank expectedValue) {
        BonusNumber bonusNumber = new BonusNumber(bonusNum);
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        Lotto lotto = new Lotto(lottoNumbers);

        Rank actualValue = winningLotto.compareNumbers(lotto, bonusNumber).get();

        assertEquals(actualValue, expectedValue);
    }

    static Stream<Arguments> validLottoNumbersCompareParameters() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6, List.of(1, 2, 3, 7, 8, 9), Rank.FIFTH),
                Arguments.of(List.of(11, 22, 33, 44, 35, 27), 27, List.of(11, 22, 33, 44, 1, 2), Rank.FOURTH),
                Arguments.of(List.of(11, 22, 33, 44, 35, 27), 29, List.of(11, 22, 33, 44, 35, 29), Rank.SECOND),
                Arguments.of(List.of(11, 22, 33, 44, 41, 45), 45, List.of(11, 22, 33, 44, 41, 45), Rank.FIRST)
        );
    }

    @ParameterizedTest
    @MethodSource("validLottoNumbersCompareIsUnderMinimumStandardParameters")
    void 당첨_로또번호와_보너스_번호를_구매한_로또번호와_비교했을때_최저_랭킹_기준보다_낮으면_Empty_Optional을_리턴한다(List<Integer> winningNumbers,
                                                                              int bonusNum,
                                                                              List<Integer> lottoNumbers) {
        BonusNumber bonusNumber = new BonusNumber(bonusNum);
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        Lotto lotto = new Lotto(lottoNumbers);

        Optional<Rank> actualValue = winningLotto.compareNumbers(lotto, bonusNumber);

        assertEquals(actualValue, Optional.empty());
    }

    static Stream<Arguments> validLottoNumbersCompareIsUnderMinimumStandardParameters() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6, List.of(1, 2, 11, 22, 33, 44)),
                Arguments.of(List.of(11, 22, 33, 44, 35, 27), 27, List.of(11, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(11, 22, 33, 44, 35, 27), 29, List.of(1, 2, 3, 4, 5, 6))
        );
    }

}
