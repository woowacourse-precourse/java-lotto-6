package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class LottoWinningNumbersTest {

    LottoWinningNumbers lottoWinningNumbers;

    @DisplayName("당천번호와 보너스번호")
    @BeforeEach
    public void beforeEach() {
        lottoWinningNumbers = new LottoWinningNumbers("1,6,8,25,33,45");
        lottoWinningNumbers.lottoWinningBonusNumber("5");
    }

    @DisplayName("5개의 로또당첨번호와 보너스 번호가 같을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "11", "16", "17"})
    public void 로또당첨번호_5개와_보너스번호_같을경우(String bonus) throws Exception {
        //given
        lottoWinningNumbers.lottoWinningBonusNumber(bonus);
        Lotto userLottoNumbers = new Lotto("1,2,3,11,16,17");

        //when
        Method method = lottoWinningNumbers.getClass().getDeclaredMethod("sameFiveNumbersAndBonus", Lotto.class, int.class);
        method.setAccessible(true);
        boolean check = (Boolean) method.invoke(lottoWinningNumbers, userLottoNumbers, 5);

        //then 결과값 비교
        Assertions.assertThat(check).isTrue();
    }

    @DisplayName("5개가 아닌 로또당첨번호와 보너스번호가 같을 경우")
    @ParameterizedTest
    @CsvSource(value = {"1,4", "2,3", "3,2", "11,1", "16,0"}, delimiter = ',')
    public void 로또당첨번호_5개아닌_보너스번호_같을경우(String bonus, int sameCount) throws Exception {
        //given
        lottoWinningNumbers.lottoWinningBonusNumber(bonus);
        Lotto userLottoNumbers = new Lotto("1,2,3,11,16,17");

        //when
        Method method = lottoWinningNumbers.getClass().getDeclaredMethod("sameFiveNumbersAndBonus", Lotto.class, int.class);
        method.setAccessible(true);
        boolean check = (Boolean) method.invoke(lottoWinningNumbers, userLottoNumbers, sameCount);

        //then 결과값 비교
        Assertions.assertThat(check).isFalse();
    }

    @DisplayName("로또 당첨번호와 사용자의 로또 번호 중 동일한 개수 구하기")
    @Test
    public void 당첨번호_사용자번호_동일한_개수() throws Exception {
        //given (주어진 값)
        Lotto sameUserLottoNumberSix = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 33, 45)));
        Lotto sameUserLottoNumberFiveAndBonus = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 33, 5)));
        Lotto sameUserLottoNumberFive = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 33, 44)));
        Lotto sameUserLottoNumberFour = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 31, 43)));
        Lotto sameUserLottoNumberThree = new Lotto(new ArrayList<>(List.of(1, 6, 8, 18, 22, 40)));
        Lotto sameUserLottoNumberTwo = new Lotto(new ArrayList<>(List.of(1, 6, 7, 16, 21, 32)));
        Lotto sameUserLottoNumberOne = new Lotto(new ArrayList<>(List.of(1, 2, 3, 5, 11, 42)));
        Lotto sameUserLottoNumberZero = new Lotto(new ArrayList<>(List.of(2, 3, 4, 5, 11, 42)));

        //when (기능 작동)
        Method method = lottoWinningNumbers.getClass().getDeclaredMethod("checkUserLottoNumberCount", Lotto.class);
        method.setAccessible(true);
        int six = (Integer) method.invoke(lottoWinningNumbers, sameUserLottoNumberSix);
        int fiveAndBonus = (Integer) method.invoke(lottoWinningNumbers, sameUserLottoNumberFiveAndBonus);
        int five = (Integer) method.invoke(lottoWinningNumbers, sameUserLottoNumberFive);
        int four = (Integer) method.invoke(lottoWinningNumbers, sameUserLottoNumberFour);
        int three = (Integer) method.invoke(lottoWinningNumbers, sameUserLottoNumberThree);
        int two = (Integer) method.invoke(lottoWinningNumbers, sameUserLottoNumberTwo);
        int one = (Integer) method.invoke(lottoWinningNumbers, sameUserLottoNumberOne);
        int zero = (Integer) method.invoke(lottoWinningNumbers, sameUserLottoNumberZero);

        //then (기능 작동 후 결과)
        Assertions.assertThat(six).isEqualTo(6);
        Assertions.assertThat(fiveAndBonus).isEqualTo(50);
        Assertions.assertThat(five).isEqualTo(5);
        Assertions.assertThat(four).isEqualTo(4);
        Assertions.assertThat(three).isEqualTo(3);
        Assertions.assertThat(two).isEqualTo(2);
        Assertions.assertThat(one).isEqualTo(1);
        Assertions.assertThat(zero).isEqualTo(0);
    }

    @DisplayName("사용자 번호와 당첨 로또 번호를 비교하기")
    @Test
    public void 사용자번호_당첨번호_등수_결과() throws Exception {
        //given (주어진 값)
        List<Lotto> userLottos = new ArrayList<>();
        Lotto sameUserLottoNumberSix = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 33, 45)));
        Lotto sameUserLottoNumberFiveAndBonus = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 33, 5)));
        Lotto sameUserLottoNumberFiveAndBonusTwo = new Lotto(new ArrayList<>(List.of(1, 6, 8, 5, 33, 45)));
        Lotto sameUserLottoNumberFive = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 33, 44)));
        Lotto sameUserLottoNumberFiveTwo = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 27, 45)));
        Lotto sameUserLottoNumberFour = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 31, 43)));
        Lotto sameUserLottoNumberThree = new Lotto(new ArrayList<>(List.of(1, 6, 8, 18, 22, 40)));
        Lotto sameUserLottoNumberTwo = new Lotto(new ArrayList<>(List.of(1, 6, 7, 16, 21, 32)));
        Lotto sameUserLottoNumberOne = new Lotto(new ArrayList<>(List.of(1, 2, 3, 5, 11, 42)));
        Lotto sameUserLottoNumberZero = new Lotto(new ArrayList<>(List.of(2, 3, 4, 5, 11, 42)));

        userLottos.add(sameUserLottoNumberSix);
        userLottos.add(sameUserLottoNumberFiveAndBonus);
        userLottos.add(sameUserLottoNumberFiveAndBonusTwo);
        userLottos.add(sameUserLottoNumberFive);
        userLottos.add(sameUserLottoNumberFiveTwo);
        userLottos.add(sameUserLottoNumberFour);
        userLottos.add(sameUserLottoNumberThree);
        userLottos.add(sameUserLottoNumberTwo);
        userLottos.add(sameUserLottoNumberOne);
        userLottos.add(sameUserLottoNumberZero);

        //when (기능 작동)
        lottoWinningNumbers.compareWithUserLottoAndWinningLotto(userLottos, 100000);
        int sixCount = lottoWinningNumbers.countTotalLottoPrizes().get(6);
        int fiveAndBonusCount = lottoWinningNumbers.countTotalLottoPrizes().get(50);
        int fiveCount = lottoWinningNumbers.countTotalLottoPrizes().get(5);
        int fourCount = lottoWinningNumbers.countTotalLottoPrizes().get(4);
        int threeCount = lottoWinningNumbers.countTotalLottoPrizes().get(3);

        //then (기능 작동 후 결과)
        Assertions.assertThat(sixCount).isEqualTo(1);
        Assertions.assertThat(fiveAndBonusCount).isEqualTo(2);
        Assertions.assertThat(fiveCount).isEqualTo(2);
        Assertions.assertThat(fourCount).isEqualTo(1);
        Assertions.assertThat(threeCount).isEqualTo(1);
    }

    @DisplayName("6개 당첨에 따른 수익률 검사")
    @Test
    public void 당첨번호_6개_당첨_수익률() throws Exception {
        //given (주어진 값)
        List<Lotto> userLottos = new ArrayList<>();
        Lotto sameUserLottoNumberSix = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 33, 45)));
        userLottos.add(sameUserLottoNumberSix);
        double calculate = ((double) 2000000000 / 1000) * 100;

        LottoResult lottoResult = new LottoResult();
        lottoResult.addWinningCount(6);
        Map<Integer, Integer> check = lottoResult.getWinningCount();

        //when (기능 작동)
        lottoWinningNumbers.compareWithUserLottoAndWinningLotto(userLottos, 1000);
        Map<Integer, Integer> count = lottoWinningNumbers.countTotalLottoPrizes();
        double profitMoney = lottoWinningNumbers.totalProfitMargin();

        //then (기능 작동 후 결과)
        Assertions.assertThat(profitMoney).isEqualTo(calculate);
        Assertions.assertThat(count).isEqualTo(check);
    }

    @DisplayName("6개 2번당첨에 따른 수익률 검사")
    @Test
    public void 당첨번호_6개_2번_당첨_수익률() throws Exception {
        //given (주어진 값)
        List<Lotto> userLottos = new ArrayList<>();
        Lotto sameUserLottoNumberSix = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 33, 45)));
        userLottos.add(sameUserLottoNumberSix);
        userLottos.add(sameUserLottoNumberSix);
        double calculate = ((double) 4000000000l / 2000) * 100;

        LottoResult lottoResult = new LottoResult();
        lottoResult.addWinningCount(6);
        lottoResult.addWinningCount(6);
        Map<Integer, Integer> check = lottoResult.getWinningCount();

        //when (기능 작동)
        lottoWinningNumbers.compareWithUserLottoAndWinningLotto(userLottos, 2000);
        Map<Integer, Integer> count = lottoWinningNumbers.countTotalLottoPrizes();
        double profitMoney = lottoWinningNumbers.totalProfitMargin();

        //then (기능 작동 후 결과)
        Assertions.assertThat(profitMoney).isEqualTo(calculate);
        Assertions.assertThat(count).isEqualTo(check);
    }

    @DisplayName("5개와 보너스번호 1번당첨에 따른 수익률 검사")
    @Test
    public void 당첨번호_5개_보너스번호_3번당첨_수익률() throws Exception {
        //given (주어진 값)
        List<Lotto> userLottos = new ArrayList<>();
        Lotto sameUserLottoNumberFiveAndBonusOne = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 33, 5)));
        Lotto sameUserLottoNumberFiveAndBonusTwo = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 33, 5)));
        Lotto sameUserLottoNumberFiveAndBonusThree = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 33, 5)));
        userLottos.add(sameUserLottoNumberFiveAndBonusOne);
        userLottos.add(sameUserLottoNumberFiveAndBonusTwo);
        userLottos.add(sameUserLottoNumberFiveAndBonusThree);
        double calculate = ((double) 90000000 / 3000) * 100;

        LottoResult lottoResult = new LottoResult();
        lottoResult.addWinningCount(50);
        lottoResult.addWinningCount(50);
        lottoResult.addWinningCount(50);
        Map<Integer, Integer> check = lottoResult.getWinningCount();

        //when (기능 작동)
        lottoWinningNumbers.compareWithUserLottoAndWinningLotto(userLottos, 3000);
        Map<Integer, Integer> count = lottoWinningNumbers.countTotalLottoPrizes();
        double profitMoney = lottoWinningNumbers.totalProfitMargin();

        //then (기능 작동 후 결과)
        Assertions.assertThat(profitMoney).isEqualTo(calculate);
        Assertions.assertThat(count).isEqualTo(check);
    }

    @DisplayName("6개와 5개 당첨에 따른 수익률 검사")
    @Test
    public void 당첨번호_6개와_5개_당첨_수익률() throws Exception {
        //given (주어진 값)
        List<Lotto> userLottos = new ArrayList<>();
        Lotto sameUserLottoNumberSix = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 33, 45)));
        Lotto sameUserLottoNumberFive = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 33, 7)));
        Lotto sameUserLottoNumberZero = new Lotto(new ArrayList<>(List.of(2, 3, 4, 22, 31, 9)));
        userLottos.add(sameUserLottoNumberSix);
        userLottos.add(sameUserLottoNumberFive);
        userLottos.add(sameUserLottoNumberZero);
        double calculate = ((double) 2001500000 / 3000) * 100;

        LottoResult lottoResult = new LottoResult();
        lottoResult.addWinningCount(6);
        lottoResult.addWinningCount(5);
        Map<Integer, Integer> check = lottoResult.getWinningCount();

        //when (기능 작동)
        lottoWinningNumbers.compareWithUserLottoAndWinningLotto(userLottos, 3000);
        Map<Integer, Integer> count = lottoWinningNumbers.countTotalLottoPrizes();
        double profitMoney = lottoWinningNumbers.totalProfitMargin();

        //then (기능 작동 후 결과)
        Assertions.assertThat(profitMoney).isEqualTo(calculate);
        Assertions.assertThat(count).isEqualTo(check);
    }

    @DisplayName("4개 당첨에 따른 수익률 검사")
    @Test
    public void 당첨번호_4개_당첨_수익률() throws Exception {
        //given (주어진 값)
        List<Lotto> userLottos = new ArrayList<>();
        Lotto sameUserLottoNumberFour = new Lotto(new ArrayList<>(List.of(1, 6, 8, 25, 31, 43)));
        userLottos.add(sameUserLottoNumberFour);
        double calculate = ((double) 50000 / 1000) * 100;

        LottoResult lottoResult = new LottoResult();
        lottoResult.addWinningCount(4);
        Map<Integer, Integer> check = lottoResult.getWinningCount();

        //when (기능 작동)
        lottoWinningNumbers.compareWithUserLottoAndWinningLotto(userLottos, 1000);
        Map<Integer, Integer> fourCount = lottoWinningNumbers.countTotalLottoPrizes();
        double profitMoney = lottoWinningNumbers.totalProfitMargin();

        //then (기능 작동 후 결과)
        Assertions.assertThat(profitMoney).isEqualTo(calculate);
        Assertions.assertThat(fourCount).isEqualTo(check);
    }

    @DisplayName("3개 당첨에 따른 수익률 검사")
    @Test
    public void 당첨번호_3개_당첨_수익률() throws Exception {
        //given (주어진 값)
        List<Lotto> userLottos = new ArrayList<>();
        Lotto sameUserLottoNumberThree = new Lotto(new ArrayList<>(List.of(1, 6, 8, 5, 31, 43)));
        userLottos.add(sameUserLottoNumberThree);
        double calculate = ((double) 5000 / 1000) * 100;

        LottoResult lottoResult = new LottoResult();
        lottoResult.addWinningCount(3);
        Map<Integer, Integer> check = lottoResult.getWinningCount();

        //when (기능 작동)
        lottoWinningNumbers.compareWithUserLottoAndWinningLotto(userLottos, 1000);
        Map<Integer, Integer> threeCount = lottoWinningNumbers.countTotalLottoPrizes();
        double profitMoney = lottoWinningNumbers.totalProfitMargin();

        //then (기능 작동 후 결과)
        Assertions.assertThat(profitMoney).isEqualTo(calculate);
        Assertions.assertThat(threeCount).isEqualTo(check);
    }

    @DisplayName("2개 당첨에 따른 수익률 검사")
    @Test
    public void 당첨번호_2개_당첨_수익률() throws Exception {
        //given (주어진 값)
        List<Lotto> userLottos = new ArrayList<>();
        Lotto sameUserLottoNumberTwo = new Lotto(new ArrayList<>(List.of(1, 6, 4, 5, 31, 43)));
        userLottos.add(sameUserLottoNumberTwo);
        double calculate = ((double) 0 / 1000) * 100;

        LottoResult lottoResult = new LottoResult();
        lottoResult.addWinningCount(2);
        Map<Integer, Integer> check = lottoResult.getWinningCount();

        //when (기능 작동)
        lottoWinningNumbers.compareWithUserLottoAndWinningLotto(userLottos, 1000);
        Map<Integer, Integer> threeCount = lottoWinningNumbers.countTotalLottoPrizes();
        double profitMoney = lottoWinningNumbers.totalProfitMargin();

        //then (기능 작동 후 결과)
        Assertions.assertThat(profitMoney).isEqualTo(calculate);
        Assertions.assertThat(threeCount).isEqualTo(check);
    }

    @DisplayName("1개 당첨에 따른 수익률 검사")
    @Test
    public void 당첨번호_1개_당첨_수익률() throws Exception {
        //given (주어진 값)
        List<Lotto> userLottos = new ArrayList<>();
        Lotto sameUserLottoNumberTwo = new Lotto(new ArrayList<>(List.of(1, 2, 4, 5, 31, 43)));
        userLottos.add(sameUserLottoNumberTwo);
        double calculate = ((double) 0 / 1000) * 100;

        LottoResult lottoResult = new LottoResult();
        lottoResult.addWinningCount(1);
        Map<Integer, Integer> check = lottoResult.getWinningCount();

        //when (기능 작동)
        lottoWinningNumbers.compareWithUserLottoAndWinningLotto(userLottos, 1000);
        Map<Integer, Integer> threeCount = lottoWinningNumbers.countTotalLottoPrizes();
        double profitMoney = lottoWinningNumbers.totalProfitMargin();

        //then (기능 작동 후 결과)
        Assertions.assertThat(profitMoney).isEqualTo(calculate);
        Assertions.assertThat(threeCount).isEqualTo(check);
    }

    @DisplayName("0개 당첨에 따른 수익률 검사")
    @Test
    public void 당첨번호_0개_당첨_수익률() throws Exception {
        //given (주어진 값)
        List<Lotto> userLottos = new ArrayList<>();
        Lotto sameUserLottoNumberTwo = new Lotto(new ArrayList<>(List.of(22, 2, 4, 5, 31, 43)));
        userLottos.add(sameUserLottoNumberTwo);
        double calculate = ((double) 0 / 1000) * 100;

        LottoResult lottoResult = new LottoResult();
        lottoResult.addWinningCount(0);
        Map<Integer, Integer> check = lottoResult.getWinningCount();

        //when (기능 작동)
        lottoWinningNumbers.compareWithUserLottoAndWinningLotto(userLottos, 1000);
        Map<Integer, Integer> threeCount = lottoWinningNumbers.countTotalLottoPrizes();
        double profitMoney = lottoWinningNumbers.totalProfitMargin();

        //then (기능 작동 후 결과)
        Assertions.assertThat(profitMoney).isEqualTo(calculate);
        Assertions.assertThat(threeCount).isEqualTo(check);
    }
}