package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @Test
    @DisplayName("보너스 넘버가 리스트 안에 포함되면 true 포함되지 않으면 false를 반환한다.")
    void containBonusNumberTest() {
        //given
        BonusNumber bonusNumber = new BonusNumber("6");
        List<Integer> lottoNumbersTrue = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbersFalse = List.of(11, 12, 13, 14, 15, 16);

        //when
        boolean expectTrue = bonusNumber.containBonusNumber(lottoNumbersTrue);
        boolean expectFalse = bonusNumber.containBonusNumber(lottoNumbersFalse);

        //then
        assertThat(expectTrue).isEqualTo(true);
        assertThat(expectFalse).isEqualTo(false);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 문자 포함시 예외가 발생한다.")
    @ValueSource(strings = {"-1","1a","a1","aa"," 1","1 "})
    void onlyOneNumbertest(String userInput) {
        //given

        //when

        //then
        assertThatThrownBy(() -> new BonusNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("1 ~ 45 범위를 벗어날시 예외가 발생한다.")
    @ValueSource(strings = {"0","46"})
    void bonusNumberRangertest(String userInput) {
        //given

        //when

        //then
        assertThatThrownBy(() -> new BonusNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}