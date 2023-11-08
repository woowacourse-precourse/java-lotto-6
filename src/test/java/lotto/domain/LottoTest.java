package lotto.domain;


import static lotto.utils.ErrorMessages.LOTTO_NUMBER_DUPLICATION;
import static lotto.utils.ErrorMessages.LOTTO_OUT_OF_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


@DisplayName("Lotto 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoTest {


    @Test
    void 생성자는_입력값의_길이가_6이_아니면_예외를_던진다() {
        List<Integer> testLottoNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        Assertions.assertThatThrownBy(() -> new Lotto(testLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_OUT_OF_SIZE);
    }

    @Test
    void 생성자는_입력값에_중복이_존재하면_예외를_던진다() {
        List<Integer> testLottoNumbers = List.of(1, 1, 3, 4, 5, 6);

        Assertions.assertThatThrownBy(() -> new Lotto(testLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_DUPLICATION);
    }

    @ParameterizedTest
    @MethodSource("provideWinningNumbers")
    void countMatchedWinningLotto_메소드는_당첨번호와_일치하는_개수를_반환한다(String winningNumbers, List<Integer> lottoNumbers, int expect) {
        WinningNumbers testWinningNumbers = new WinningNumbers(winningNumbers);
        Lotto testLotto = new Lotto(lottoNumbers);

        assertEquals(testLotto.countMatchedWinningLotto(testWinningNumbers), expect);
    }

    private static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", List.of(1,2,3,4,5,6), 6),
                Arguments.of("1,2,3,4,5,7", List.of(1,2,3,4,5,6), 5),
                Arguments.of("1,2,3,4,5,6", List.of(7,8,9,10,11,12), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideBonusNumber")
    void isMatchedBonusNumber_메소드는_보너스번호_일치_여부를_반환한다(int bonusNumber, List<Integer> lottoNumbers, boolean expect) {
        BonusNumber testBonusNumber = new BonusNumber(bonusNumber, new WinningNumbers("11,12,13,14,15,16"));
        Lotto testLotto = new Lotto(lottoNumbers);

        assertEquals(testLotto.isMatchedBonusNumber(testBonusNumber), expect);
    }

    private static Stream<Arguments> provideBonusNumber() {
        return Stream.of(
                Arguments.of(1, List.of(1,2,3,4,5,6), true),
                Arguments.of(7, List.of(1,2,3,4,5,6), false)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "45:false"}, delimiter = ':')
    void isContain_메소드는_로또번호_포함여부를_반환한다(int number, boolean expect) {
        Lotto testLotto = new Lotto(List.of(1,2,3,4,5,6));
        LottoNumber testLottoNumber = new LottoNumber(number);

        assertEquals(testLotto.isContain(testLottoNumber), expect);
    }
}
