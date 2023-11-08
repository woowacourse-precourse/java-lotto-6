package lotto.domain.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static lotto.exception.ErrorMessage.BONUS_NUMBER_DUPLICATED;
import static lotto.exception.ErrorMessage.NUMBER_OUT_OF_RANGE;
import static lotto.fixture.NumberFixture.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("[Domain Layer] Prize")
class PrizeTest {

    @Nested
    @DisplayName("[of] 정적 팩토리 메소드 / 생성자 테스트")
    class of {

        /**
         * Prize 객체 생성자 예외처리
         * 1. bonusNumber가 범위(Default : 1~45)를 벗어나는 요청
         * 2. Lotto의 prizeNumbers로 이미 등록한 숫자를 보너스 숫자로 요청
         */

        @Test
        @DisplayName("[Success] 정상적인 로또, 보너스 숫자 인자로 객체 생성 성공")
        void Should_Success_When_Valid() {
            // given && when && then
            assertDoesNotThrow(VALID::toPrizeEntity);
        }

        @Test
        @DisplayName("[Exception] bonusNumber가 범위(Default : 1~45)를 벗어나는 요청 예외처리")
        void Should_ThrowException_When_OutOfRangeBonusNumber() {
            // given && when && then
            assertThatThrownBy(OUT_OF_RANGE_BONUS::toPrizeEntity)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NUMBER_OUT_OF_RANGE.getMessage());
        }

        @Test
        @DisplayName("[Exception] Lotto의 prizeNumbers로 이미 등록한 숫자를 보너스 숫자로 요청")
        void Should_ThrowException_When_BonusNumberDuplicatedAtPrizeNumber() {
            // given && when && then
            assertThatThrownBy(BONUS_NUMBER_DUPLICATED_1::toPrizeEntity)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }

    @Nested
    @DisplayName("[isPrizeNumber] 파라미터에 요청된 숫자가 Lotto 일급 컬렉션 객체 숫자라면 true, 아니라면 false 리턴")
    class isPrizeNumber {

        @Test
        @DisplayName("[Success] 파라미터에 요청된 숫자가 Lotto 일급 컬렉션 객체 숫자이므로 true 리턴")
        void Should_ReturnTrue_When_PrizeNumbersContainRequest() {
            // given
            Prize prize = VALID.toPrizeEntity();
            // when
            final Integer contain = VALID.getNumberList().get(0);
            // then
            assertTrue(prize.isPrizeNumber(contain));
        }

        @Test
        @DisplayName("[Success] 파라미터에 요청된 숫자가 Lotto 일급 컬렉션 객체 숫자가 아니므로 false 리턴")
        void Should_ReturnTrue_When_PrizeNumbersNotContainRequest() {
            // given
            Prize containOneToSix = VALID.toPrizeEntity();
            // when
            final int notContain = -2147483648;
            // then
            assertFalse(containOneToSix.isPrizeNumber(notContain));
        }
    }

    @Nested
    @DisplayName("[isBonusNumber] 보너스 숫자가 파라미터에 요청된 숫자와 일치하면 true, 아니라면 false 리턴")
    class isBonusNumber {

        @Test
        @DisplayName("[Success] 보너스 숫자가 파라미터에 요청된 숫자와 일치하므로 true 리턴")
        void Should_ReturnTrue_When_SameBonusNumber() {
            // given
            Prize prize = VALID.toPrizeEntity();
            // when
            final int contain = VALID.getBonusNumber();
            // then
            assertTrue(prize.isBonusNumber(contain));
        }

        @Test
        @DisplayName("[Success] 보너스 숫자가 파라미터에 요청된 숫자와 일치하지 않으므로 false 리턴")
        void Should_ReturnTrue_When_DifferentBonusNumber() {
            // given
            Prize prize = VALID.toPrizeEntity();
            // when
            final int notContain = -2147483648;
            // then
            assertFalse(prize.isBonusNumber(notContain));
        }
    }
}
