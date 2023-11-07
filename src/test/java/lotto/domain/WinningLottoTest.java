package lotto.domain;

import lotto.exception.DuplicateInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
       this.winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), new BonusNumber("30"));
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6), 6, false),
                Arguments.of(Arrays.asList(1,2,3,4,5,7), 5, false),
                Arguments.of(Arrays.asList(1,2,3,4,8,9), 4, false),
                Arguments.of(Arrays.asList(1,2,3,8,9,30), 3, true),
                Arguments.of(Arrays.asList(1,2,8,9,10,11), 2, false),
                Arguments.of(Arrays.asList(1,8,9,10,11,12),1, false),
                Arguments.of(Arrays.asList(7,8,9,10,11,12),0, false)
        );
    }

    @DisplayName("로또 내 숫자를 세어 얼마나 맞았는지 확인")
    @ParameterizedTest
    @MethodSource("generateData")
    void countCorrectNumbersTest(List<Integer> lottoNumbers, Integer expectedMatchingNumber) {
        // given & when
        Integer matchingNumber = winningLotto.countCorrectNumbers(new Lotto(lottoNumbers));

        // then
        assertThat(matchingNumber).isEqualTo(expectedMatchingNumber);
    }

    @DisplayName("보너스 번호를 맞췄는지 확인")
    @ParameterizedTest
    @MethodSource("generateData")
    void isCorrectBonusNumber(List<Integer> lottoNumbers, Integer expectedMatchingNumber, Boolean expectedCorrectNumber) {
        // given & when
        Boolean isCorrectBonusNumber = winningLotto.isCorrectBonusNumber(new Lotto(lottoNumbers));

        // then
        assertThat(isCorrectBonusNumber).isEqualTo(expectedCorrectNumber);
    }

    @DisplayName("보너스 번호와 당첨 번호에 중복이 있으면 예외처리 하는지")
    @Test
    void hasDuplicatedNumberTest() {
        // given when & then
        assertThatThrownBy(() -> new WinningLotto(List.of(1,2,3,4,5,6), new BonusNumber("6")))
                .isInstanceOf(DuplicateInputException.class);
    }
}