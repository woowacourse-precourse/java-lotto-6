package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName("정답 번호와 동일한 보너스 번호일 경우 예외가 발생한다.")
    @Test
    void validateDuplicateBonusNumber() {
        // given
        List<Integer> answerNumber = List.of(1,2,3,4,5,6);
        int bonus = 1;
        BonusNumber bonusNumber = new BonusNumber();

        // when, then
        assertThatThrownBy(() -> bonusNumber.validateDuplicateBonusNumber(answerNumber, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }


    static Stream<Arguments> numberSizeParameters() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(46),
                Arguments.of(-5)
        );
    }

    @DisplayName("보너스 번호가 1~45 사이가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("numberSizeParameters")
    void validateBonusNumberSize(int bonusNumbers) {
        // given
        BonusNumber bonusNumber = new BonusNumber();

        // when, then
        assertThatThrownBy(() -> bonusNumber.validateBonusNumberSize(bonusNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}