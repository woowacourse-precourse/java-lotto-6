package lotto.domain.lottery;

import lotto.domain.prize.Prize;
import lotto.fixture.NumberFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static lotto.domain.lottery.constants.LottoConstraint.LOTTO_PICK_COUNT;
import static lotto.exception.ErrorMessage.*;
import static lotto.fixture.NumberFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("[Domain Layer] Lotto")
class LottoTest {

    @Nested
    @DisplayName("[new] 정적 팩토리 메소드 / 생성자 테스트")
    class constructor_new {

        /**
         * Lotto 객체 생성자 예외처리
         * 1. 리스트 숫자의 갯수가 제약조건(Default : 6)과 일치하지 않는 요청
         * 2. 리스트 숫자의 각 요소가 제약조건(Default 1 ~ 45)를 만족하지 않는 요청
         * 3. 리스트 숫자에 중복된 요소가 포함되는 요청
         */

        @Test
        @DisplayName("[Success] 정상적인 로또 숫자 인자로 객체 생성 성공")
        void Should_Success_When_Valid() {
            // given
            NumberFixture valid = CONTAIN_NUMBER_1_TO_6;
            // when && then
            Assertions.assertDoesNotThrow(valid::toLottoEntity);
        }

        @Test
        @DisplayName("[Exception] 리스트 숫자의 갯수가 제약조건(Default : 6)과 일치하지 않는 요청 예외처리")
        void Should_ThrowException_When_DifferentNumberCountConstraint() {
            // given
            NumberFixture less = NumberFixture.LESS_NUMBER_COUNT;
            NumberFixture exceed = NumberFixture.LESS_NUMBER_COUNT;
            // when && then
            assertAll(
                    () -> assertThatThrownBy(less::toLottoEntity)
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(NUMBER_COUNT_INVALID.getMessage()),
                    () -> assertThatThrownBy(exceed::toLottoEntity)
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(NUMBER_COUNT_INVALID.getMessage())
            );
        }

        @Test
        @DisplayName("[Exception] 리스트 숫자의 각 요소가 제약조건(Default 1 ~ 45)를 만족하지 않는 요청 예외처리")
        void Should_ThrowException_When_DifferentNumberRangeConstraint() {
            // given && when && then
            assertAll(
                    () -> assertThatThrownBy(EXCEED_CONSTRAINT::toLottoEntity)
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(NUMBER_OUT_OF_RANGE.getMessage()),
                    () -> assertThatThrownBy(ZERO::toLottoEntity)
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(NUMBER_OUT_OF_RANGE.getMessage()),
                    () -> assertThatThrownBy(NEGATIVE_INTEGER::toLottoEntity)
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(NUMBER_OUT_OF_RANGE.getMessage())
            );
        }

        @Test
        @DisplayName("[Exception] 리스트 숫자에 중복된 요소가 포함되는 요청 예외처리")
        void Should_ThrowException_When_DuplicatedParameter() {
            // given && when && then
            assertThatThrownBy(DUPLICATED::toLottoEntity)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NUMBER_DUPLICATED.getMessage());
        }
    }

    @Nested
    @DisplayName("[countPrizeNumberMatchingCount] Lotto 일급 컬렉션 숫자 중, 당첨 숫자와 일치하는 숫자의 갯수를 리턴")
    class countPrizeNumberMatchingCount {

        @Test
        @DisplayName("[Success] Prize의 당첨 숫자 일치하는 숫자의 갯수를 리턴합니다.")
        void Should_Success_When_Valid() {
            // given
            final Lotto sameLotto = CONTAIN_NUMBER_1_TO_6.toLottoEntity();
            final Prize samePrize = CONTAIN_NUMBER_1_TO_6.toPrizeEntity();

            final int expected = LOTTO_PICK_COUNT.getValue();
            // then
            assertThat(expected).isEqualTo(sameLotto.countPrizeNumberMatchingCount(samePrize));
        }
    }

    @Nested
    @DisplayName("[hasBonusNumber] 보너스 숫자가 로또 일급 컬렉션 객체에 포함되어 있다면 true, 아니라면 false를 리턴")
    class hasBonusNumber {

        @Test
        @DisplayName("[Success] 보너스 숫자가 로또 일급 컬렉션 객체에 포함되어 있어 true를 리턴")
        void Should_ReturnTrue_When_Included() {
            // given
            final Lotto lotto = CONTAIN_NUMBER_1_TO_6.toLottoEntity();
            final Prize prize = CONTAIN_BONUS_1.toPrizeEntity();

            // then
            assertThat(lotto.hasBonusNumber(prize)).isTrue();
        }

        @Test
        @DisplayName("[Success] 보너스 숫자가 로또 일급 컬렉션 객체에 포함되지 않아 false를 리턴")
        void Should_ReturnFalse_When_Excluded() {
            // given
            final Lotto lotto = CONTAIN_NUMBER_1_TO_6.toLottoEntity();
            final Prize prize = CONTAIN_BONUS_45.toPrizeEntity();

            // then
            assertThat(lotto.hasBonusNumber(prize)).isFalse();
        }
    }

    @Nested
    @DisplayName("[hasNumber] 로또 일급 컬렉션 객체에 해당 숫자가 포함되어 있다면 true, 아니라면 false를 리턴")
    class hasNumber {

        @Test
        @DisplayName("[Success] 로또 일급 컬렉션 객체에 해당 숫자가 포함되어 있어 true를 리턴")
        void Should_ReturnTrue_When_Included() {
            // given
            final Lotto lotto = CONTAIN_NUMBER_1_TO_6.toLottoEntity();
            final int includedNumber = 1;

            // then
            assertThat(lotto.hasNumber(includedNumber)).isTrue();
        }

        @Test
        @DisplayName("[Success] 보너스 숫자가 로또 일급 컬렉션 객체에 포함되지 않지 않아 false를 리턴")
        void Should_ReturnFalse_When_Excluded() {
            // given
            final Lotto lotto = CONTAIN_NUMBER_1_TO_6.toLottoEntity();
            final int includedNumber = 45;

            // then
            assertThat(lotto.hasNumber(includedNumber)).isFalse();
        }
    }
}
