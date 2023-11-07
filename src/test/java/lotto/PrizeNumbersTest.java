package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.PrizeNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PrizeNumbersTest {

    @Test
    @DisplayName("보너스 번호가 로또 번호에 포함되면 예외 발생")
    void testBonusNumberIsInLottoNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PrizeNumbers(lotto, bonusNumber);
        });

        assertEquals("보너스 번호는 로또 번호에 포함될 수 없습니다.", exception.getMessage());
    }
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 4, 5, 6, 7, FIRST"
    })
    @DisplayName("1등 당첨 결과 반환")
    void shouldReturnCorrectPrize(int n1, int n2, int n3, int n4, int n5, int n6, int bn, Ranking expected) {

        // given
        Lotto lottoNumbers = new Lotto(List.of(n1, n2, n3, n4, n5, n6));
        BonusNumber bonusNumber = new BonusNumber(bn);
        PrizeNumbers prizeNumbers = new PrizeNumbers(lottoNumbers, bonusNumber);

        // when
        Lotto myLotto = new Lotto(List.of(n1, n2, n3, n4, n5, n6));

        // then
        assertThat(prizeNumbers.calculatePrize(myLotto)).isEqualTo(expected);
    }
    @Test
    @DisplayName("2등 당첨 결과 반환")
    void secondPrize() {
        // given
        Lotto lottoNumbers = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(7);
        PrizeNumbers prizeNumbers = new PrizeNumbers(lottoNumbers, bonusNumber);

        // when
        Lotto myLotto = new Lotto(List.of(1,2,3,4,5,7));

        //then
        assertThat(prizeNumbers.calculatePrize(myLotto)).isEqualTo(Ranking.SECOND);
    }

    @Test
    @DisplayName("3등 당첨 결과 반환")
    void thirdPrize() {
        // given
        Lotto lottoNumbers = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(7);
        PrizeNumbers prizeNumbers = new PrizeNumbers(lottoNumbers, bonusNumber);

        // when
        Lotto myLotto = new Lotto(List.of(1,2,3,4,5,8));

        //then
        assertThat(prizeNumbers.calculatePrize(myLotto)).isEqualTo(Ranking.THIRD);
    }

    @Test
    @DisplayName("4등 당첨 결과 반환")
    void fourthPrize() {
        // given
        Lotto lottoNumbers = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(7);
        PrizeNumbers prizeNumbers = new PrizeNumbers(lottoNumbers, bonusNumber);

        // when
        Lotto myLotto = new Lotto(List.of(1,2,3,4,8,9));

        //then
        assertThat(prizeNumbers.calculatePrize(myLotto)).isEqualTo(Ranking.FOURTH);
    }
    @Test
    @DisplayName("5등 당첨 결과 반환")
    void fifthPrize() {
        // given
        Lotto lottoNumbers = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(7);
        PrizeNumbers prizeNumbers = new PrizeNumbers(lottoNumbers, bonusNumber);

        // when
        Lotto myLotto = new Lotto(List.of(1,2,3,8,9,10));

        //then
        assertThat(prizeNumbers.calculatePrize(myLotto)).isEqualTo(Ranking.FIFTH);
    }
}
