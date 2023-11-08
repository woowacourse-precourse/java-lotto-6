package lotto.domain.prize.ranking.rule;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.prize.Prize;
import lotto.domain.prize.PrizeNumber;
import lotto.domain.prize.PrizeNumberType;
import lotto.fixture.Fixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 기준 도메인")
public class PrizeRankingRuleTest {

    private Prize prize;

    @BeforeEach
    void setUpFixedPrize() {
        List<PrizeNumber> prizeNumbers = Fixture.createContinuousPrizeNumbers(1, 6);
        PrizeNumber bonusNumber = new PrizeNumber(7, PrizeNumberType.BONUS);
        prize = new Prize(prizeNumbers, bonusNumber);
    }

    @Test
    @DisplayName("1등은 6개 번호가 일치한다.")
    void Should_Be_First_Ranking_When_All_Lotto_Numbers_Win() {
        //given
        final List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        final Lotto lotto = new Lotto(lottoNumbers);

        //when
        final PrizeCriteria firstPrizeCriteria = PrizeRanking.FIRST.getPrizeCriteria();
        final PrizeRule firstPrizeRule = firstPrizeCriteria.getPrizeRule();
        final boolean actual = firstPrizeRule.test(lotto, prize);

        //then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("2등은 5개 번호와 보너스 번호가 일치한다.")
    void Should_Be_Second_Ranking_When_Five_Lotto_Numbers_And_Bonus_Number_Win() {
        //given
        final List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(7)
        );
        final Lotto lotto = new Lotto(lottoNumbers);

        //when
        final PrizeCriteria secondPrizeCriteria = PrizeRanking.SECOND.getPrizeCriteria();
        final PrizeRule secondPrizeRule = secondPrizeCriteria.getPrizeRule();
        final boolean actual = secondPrizeRule.test(lotto, prize);

        //then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("3등은 보너스 번호와 일치하지 않고 5개 번호가 일치한다.")
    void Should_Be_Third_Ranking_When_Only_Five_Lotto_Numbers_Win() {
        //given
        final List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(8)
        );
        final Lotto lotto = new Lotto(lottoNumbers);

        //when
        final PrizeCriteria thirdPrizeCriteria = PrizeRanking.THIRD.getPrizeCriteria();
        final PrizeRule thirdPrizeRule = thirdPrizeCriteria.getPrizeRule();
        final boolean actual = thirdPrizeRule.test(lotto, prize);

        //then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("4등은 4개 번호가 일치한다.")
    void Should_Be_Fourth_Ranking_When_Only_Four_Lotto_Numbers_Win() {
        //given
        final List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(8),
                new LottoNumber(9)
        );
        final Lotto lotto = new Lotto(lottoNumbers);

        //when
        final PrizeCriteria fourthPrizeCriteria = PrizeRanking.FOURTH.getPrizeCriteria();
        final PrizeRule fourthPrizeRule = fourthPrizeCriteria.getPrizeRule();
        final boolean actual = fourthPrizeRule.test(lotto, prize);

        //then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("5등은 3개 번호가 일치한다.")
    void Should_Be_Fifth_Ranking_When_Only_Three_Lotto_Numbers_Win() {
        //given
        final List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(8),
                new LottoNumber(9),
                new LottoNumber(10)
        );
        final Lotto lotto = new Lotto(lottoNumbers);

        //when
        final PrizeCriteria fifthPrizeCriteria = PrizeRanking.FIFTH.getPrizeCriteria();
        final PrizeRule fifthPrizeRule = fifthPrizeCriteria.getPrizeRule();
        final boolean actual = fifthPrizeRule.test(lotto, prize);

        //then
        assertThat(actual).isTrue();
    }
}
