package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BonusTest {
    private static final String IS_NOT_OVERLAP_BONUS_VALIDATOR_ERROR_MESSAGE = "[ERROR] 보너스 번호와 중복된 로또 번호가 존재합니다.";

    @ParameterizedTest
    @ValueSource(ints = {3,5,6})
    @DisplayName("보너스_객체_생성시_로또_번호와_보너스_번호_중복_테스트")
    void invalid_overlapTest(Integer invalidBonusNumber){
        // given
        // when & then
        assertThatThrownBy(() -> new Bonus(List.of(1, 2, 3, 4, 5, 6), invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IS_NOT_OVERLAP_BONUS_VALIDATOR_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {7,8,9})
    @DisplayName("보너스_객체_생성시_로또_번호와_보너스_번호_비중복_테스트")
    void valid_overlapTest(Integer validBonusNumber){
        // given
        Bonus bonus = new Bonus(List.of(1, 2, 3, 4, 5, 6), validBonusNumber);
        // when
        Integer bonusNumber = bonus.getNumber();
        // then
        assertThat(bonusNumber).isEqualTo(validBonusNumber);
    }
}