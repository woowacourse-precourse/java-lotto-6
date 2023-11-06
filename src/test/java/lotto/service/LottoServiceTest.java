package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @Test
    void publish_정상_케이스() {
        //given
        int quantity = 5;

        //when
        List<Lotto> publishedLotto = lottoService.publish(5);

        //then
        Assertions.assertThat(publishedLotto.size()).isEqualTo(quantity);
    }

    @Test
    void getWinninNumbers_정상_케이스() {
        //given
        String inputNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "7";
        String[] input = inputNumbers.split(",");
        Set<Integer> numbers = new HashSet<>();
        for (String s : input) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        //when
        WinningNumbers winningNumbers = lottoService.getWinningNumbers(numbers, bonusNumber);

        //then
        assertThat(winningNumbers.getBonusNumber()).isEqualTo(bonusNumber);
        for (Integer originalWinningNumber : winningNumbers.getOriginalWinningNumbers()) {
            assertThat(numbers).contains(originalWinningNumber);
        }
    }

    @Test
    void getRewardCount_정상_케이스() {
        //given
        String inputNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "7";
        String[] input = inputNumbers.split(",");
        Set<Integer> numbers = new HashSet<>();
        for (String s : input) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        WinningNumbers winningNumbers = lottoService.getWinningNumbers(numbers, bonusNumber);

        List<Lotto> publishedLotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)) // 1등
                , new Lotto(List.of(1, 2, 3, 4, 5, 7)) // 2등
                , new Lotto(List.of(1, 2, 3, 4, 5, 7)) // 2등
                , new Lotto(List.of(1, 2, 3, 4, 5, 10)) // 3등
                , new Lotto(List.of(1, 2, 3, 4, 5, 10)) // 3등
                , new Lotto(List.of(1, 2, 3, 4, 5, 10)) // 3등
                , new Lotto(List.of(1, 2, 3, 4, 8, 9)) // 4등
                , new Lotto(List.of(1, 2, 3, 4, 8, 9)) // 4등
                , new Lotto(List.of(1, 2, 3, 4, 8, 9)) // 4등
                , new Lotto(List.of(1, 2, 3, 4, 8, 9)) // 4등
                , new Lotto(List.of(1, 2, 3, 8, 9, 10)) // 5등
                , new Lotto(List.of(1, 2, 3, 8, 9, 10)) // 5등
                , new Lotto(List.of(1, 2, 3, 8, 9, 10)) // 5등
                , new Lotto(List.of(1, 2, 3, 8, 9, 10)) // 5등
                , new Lotto(List.of(1, 2, 3, 8, 9, 10)) // 5등
        );

        Map<Prize, Integer> expectRewardCount = Map.of(
                Prize.FIRST_REWARD,1
                , Prize.SECOND_REWARD, 2
                , Prize.THIRD_REWARD, 3
                , Prize.FOURTH_REWARD, 4
                , Prize.FIFTH_REWARD, 5
        );

        //when
        Map<Prize, Integer> rewardCount = lottoService.getRewardCount(publishedLotto, winningNumbers);

        //then
        for (Prize prize : rewardCount.keySet()) {
            int expectCount = expectRewardCount.get(prize);
            int actualCount = rewardCount.get(prize);
            assertThat(actualCount).isEqualTo(expectCount);
        }
    }

    @Test
    void getRewardRatio_정상_케이스() {
        //given
        int purchaseAmount = 18000;
        Map<Prize, Integer> prizeMap = Map.of(
                Prize.FIRST_REWARD, 0
                , Prize.SECOND_REWARD, 0
                , Prize.THIRD_REWARD, 0
                , Prize.FOURTH_REWARD, 0
                , Prize.FIFTH_REWARD, 2);

        //when
        double rewardRatio = lottoService.getRewardRatio(purchaseAmount, prizeMap);
        //then
        Assertions.assertThat(rewardRatio).isEqualTo(55.6);
    }

    @Test
    void countLottoByWinningNumbers_정상_케이스() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Set<Integer> winningNumbers = Set.of(1,2,3,8,9,10);
        int expect = 3;

        //when
        int actual = lottoService.countLottoByWinningNumbers(lotto, winningNumbers);

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void checkNumber_정상_케이스() {
        //given
        int targetNumber = 5;
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        boolean expect = true;

        //when
        boolean actual = lottoService.checkNumber(winningNumbers, targetNumber);

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void getPrize_정상_케이스() {
        //given
        int count = 3;
        boolean isExistBonusNumber = true;
        Prize expect = Prize.FIFTH_REWARD;

        //when
        Prize actual = lottoService.getPrize(count, isExistBonusNumber);

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void compareSecondAndThird_정상_케이스() {
        //given
        boolean isExistBonusNumber = true;
        Prize expect = Prize.SECOND_REWARD;

        //when
        Prize actual = lottoService.compareSecondAndThird(isExistBonusNumber);

        //then
        assertThat(actual).isEqualTo(expect);
    }
}