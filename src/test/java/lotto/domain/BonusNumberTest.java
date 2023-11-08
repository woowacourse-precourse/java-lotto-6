package lotto.domain;

import lotto.constants.message.ErrorMessage;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

@DisplayName("보너스 번호 객체에 대해")
class BonusNumberTest {
    private static final String error = ErrorMessage.ERROR_TAG.toString();
    private final Lotto lotto = mock(Lotto.class);

    @BeforeEach
    void setUp() {
        given(lotto.getNumbers()).willReturn(List.of(1, 2, 3, 4, 5, 6));
    }


    @Test
    @DisplayName("당첨 로또 번호에 포함되어 있으면 에러가 발생한다.")
    void When_Contain3_Then_ThrowException() {
        assertThatThrownBy(() -> BonusNumber.of(3, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @Test
    @DisplayName("로또 범위 안에 포함되어 있지 않으면 에러가 발생한다.")
    void When_OverLottoRange_Then_ThrowException() {
        assertThatThrownBy(() -> BonusNumber.of(999, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @Test
    @DisplayName("입력 값이 보너스 번호와 일치하면 true를 반환한다.")
    void given_CreateBonusNumber_When_MatchBonusNumber_Then_ReturnTrue() {
        //given
        BonusNumber bonusNumber = BonusNumber.of(7, lotto);

        //when
        boolean isMatchBonusNumber = bonusNumber.isMatchBonusNumber(7);

        //then
        assertTrue(isMatchBonusNumber);
    }

    @Test
    @DisplayName("입력 값이 보너스 번호와 일치하지 않으면 false를 반환한다.")
    void Given_CreateBonusNumber_When_NotMatchBonusNumber_Then_ReturnFalse() {
        //given
        BonusNumber bonusNumber = BonusNumber.of(7, lotto);

        //when
        boolean isMatchBonusNumber = bonusNumber.isMatchBonusNumber(8);

        //then
        assertFalse(isMatchBonusNumber);
    }
}
