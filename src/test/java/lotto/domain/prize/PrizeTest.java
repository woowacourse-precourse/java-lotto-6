package lotto.domain.prize;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.exception.ErrorMessage;
import lotto.fixture.Fixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 도메인")
public class PrizeTest {
    @Test
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void Should_IllegalArgumentExceptionThrown_When_Prize_Numbers_Size_Over_Lotto_Size() {
        //given
        final List<PrizeNumber> prizeNumbersOverSize = Fixture.createContinuousPrizeNumbers(1, 7);
        final PrizeNumber bonusNumber = new PrizeNumber(8, PrizeNumberType.BONUS);

        //when, then
        assertThatThrownBy(() -> new Prize(prizeNumbersOverSize, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
    }

    @Test
    @DisplayName("당첨 번호가 중복되면 예외가 발생한다.")
    void Should_IllegalArgumentExceptionThrown_When_Prize_Numbers_Are_Duplicated() {
        //given
        final List<PrizeNumber> duplicatedPrizeNumbers = Fixture.createPrizeNumbers(1, 2, 3, 4, 5, 5);
        final PrizeNumber bonusNumber = new PrizeNumber(7, PrizeNumberType.BONUS);

        //when, then
        assertThatThrownBy(() -> new Prize(duplicatedPrizeNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LOTTO_DUPLICATES.getMessage());
    }

    @Test
    @DisplayName("당첨 번호의 타입이 모두 당첨 타입이 아니면 예외가 발생한다.")
    void Should_IllegalArgumentExceptionThrown_When_All_Prize_Number_Types_Are_Not_Prize() {
        //given
        final List<PrizeNumber> prizeNumbersWithMixedType = new ArrayList<>(
                Fixture.createContinuousPrizeNumbers(1, 5));
        prizeNumbersWithMixedType.add(new PrizeNumber(6, PrizeNumberType.BONUS));

        final PrizeNumber bonusNumber = new PrizeNumber(7, PrizeNumberType.BONUS);

        //when, then
        assertThatThrownBy(() -> new Prize(prizeNumbersWithMixedType, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_PRIZE_NUMBER_TYPE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호의 타입이 보너스 타입이 아니면 예외가 발생한다.")
    void Should_IllegalArgumentExceptionThrown_When_Bonus_Number_Is_Not_Bonus() {
        //given
        final List<PrizeNumber> prizeNumbers = Fixture.createContinuousPrizeNumbers(1, 6);
        final PrizeNumber notBonusNumber = new PrizeNumber(7, PrizeNumberType.PRIZE);

        //when, then
        assertThatThrownBy(() -> new Prize(prizeNumbers, notBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_BONUS_NUMBER_TYPE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 기존 번호와 겹치면 예외가 발생한다.")
    void Should_IllegalArgumentExceptionThrown_When_Bonus_Number_Is_Duplicated_With_Prize_Numbers() {
        //given
        final List<PrizeNumber> prizeNumbers = Fixture.createContinuousPrizeNumbers(1, 6);
        final PrizeNumber duplicatedBonusNumber = new PrizeNumber(1, PrizeNumberType.BONUS);

        //when, then
        assertThatThrownBy(() -> new Prize(prizeNumbers, duplicatedBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_BONUS_NUMBER_NOT_UNIQUE.getMessage());
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 특정 개수만큼 일치한다면 True를 반환한다.")
    void Should_Win_When_Certain_Number_Of_Lotto_Numbers_Contains_Prize_Numbers() {
        //given
        final List<PrizeNumber> prizeNumbers = Fixture.createContinuousPrizeNumbers(1, 6);
        final PrizeNumber bonusNumber = new PrizeNumber(7, PrizeNumberType.BONUS);
        final Prize prize = new Prize(prizeNumbers, bonusNumber);

        //when
        final Lotto lotto = Fixture.createContinuousLottoNumbers(1, 2, 3, 10, 11, 12);
        final int actualMatchCount = 3;

        //then
        assertThat(prize.isWin(lotto, actualMatchCount)).isTrue();
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 특정 개수만큼 일치하고, 보너스 번호도 일치한다면 True를 반환한다.")
    void Should_Win_With_Bonus_When_Certain_Number_Of_Lotto_Numbers_And_Bonus_Number_Contains_Prize_Numbers() {
        //given
        final List<PrizeNumber> prizeNumbers = Fixture.createContinuousPrizeNumbers(1, 6);
        final PrizeNumber bonusNumber = new PrizeNumber(7, PrizeNumberType.BONUS);
        final Prize prize = new Prize(prizeNumbers, bonusNumber);

        //when
        final Lotto lotto = Fixture.createContinuousLottoNumbers(1, 2, 3, 7, 11, 12);
        final int actualMatchCount = 3;
        final boolean actual = prize.isWin(lotto, actualMatchCount) && prize.containsBonusNumber(lotto);

        //then
        assertThat(actual).isTrue();
    }
}
