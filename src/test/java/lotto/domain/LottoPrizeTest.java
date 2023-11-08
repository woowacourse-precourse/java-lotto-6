package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {

    private LottoPrize lottoPrize;

    @BeforeEach
    void initLottoPrize() {
        lottoPrize = LottoPrize.create();
    }

    @Nested
    @DisplayName("LottoPrize의 updateRankCount 기능 테스트")
    class updateRankCountTest {

        @Test
        @DisplayName("로또 번호 5개가 일치하고 보너스 번호가 있으면 2등의 개수가 업데이트 되는지 테스트")
        void testUpdateSecondRankCountWithBonus() {
            int secondRankCount = 5;
            boolean hasBonusNumber = true;

            lottoPrize.updateRankCount(secondRankCount, hasBonusNumber);

            assertThat(lottoPrize.getSecondRankCount()).isEqualTo(1);
        }

        @Test
        @DisplayName("로또 번호 5개가 일치하고 보너스 번호가 없으면 3등의 개수가 업데이트 되는지 테스트")
        void testUpdateThirdRankCountWithoutBonus() {
            int thirdRankCount = 5;
            boolean hasBonusNumber = false;

            lottoPrize.updateRankCount(thirdRankCount, hasBonusNumber);

            assertThat(lottoPrize.getThirdRankCount()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("생성된 로또 번호와 당첨 번호를 비교하여 당첨 등수 개수가 잘 업데이트 되는지 테스트")
    void testCountCommonNumber() {
        int bonusNumber = 7;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 11, 12);
        Lotto lotto = Lotto.create(numbers);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.create(winningNumbers, bonusNumber);

        lottoPrize.countCommonNumber(lotto, lottoWinningNumbers);

        assertThat(lottoPrize.getFifthRankCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("입력한 당첨 번호와 보너스 번호를 저장되어 있는 로또 번호와 비교했을때 등수 개수가 업데이트 되는지 테스트")
    void testCountPrizeRank() {
        int bonusNumber = 16;
        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 11, 12);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.create(winningNumbers, bonusNumber);
        Lottos lottos = new Lottos();

        lottos.save(Lotto.create(List.of(1, 2, 3, 7, 11, 12)));
        lottos.save(Lotto.create(List.of(1,2,3,7,11,16)));
        lottos.save(Lotto.create(List.of(1,2,3,7,11,26)));
        lottoPrize.countPrizeRank(lottos, lottoWinningNumbers);

        assertAll(
                () -> assertThat(lottoPrize.getFirstRankCount()).isEqualTo(1),
                () -> assertThat(lottoPrize.getSecondRankCount()).isEqualTo(1),
                () -> assertThat(lottoPrize.getThirdRankCount()).isEqualTo(1),
                () -> assertThat(lottoPrize.getFourthRankCount()).isEqualTo(0),
                () -> assertThat(lottoPrize.getFifthRankCount()).isEqualTo(0)
        );
    }
}