package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class WinnerTest {

    Winner winner;

    @DisplayName("당천번호와 보너스번호")
    @BeforeEach
    public void beforeEach() {
        winner = new Winner("1,6,8,25,33,45");
        winner.lottoWinningBonusNumber("5");
    }

    @DisplayName("5개의 로또 당첨번호와 보너스 번호가 같을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "11", "16", "17"})
    public void 로또당첨번호_5개와_보너스번호_같을경우(String bonus) throws Exception {
        //given
        winner.lottoWinningBonusNumber(bonus);
        Lotto userLottoNumbers = new Lotto("1,2,3,11,16,17");

        //when
        Method method = winner.getClass().getDeclaredMethod("sameFiveNumbersAndBonus", Lotto.class, int.class);
        method.setAccessible(true);
        boolean check = (Boolean) method.invoke(winner, userLottoNumbers, 5);

        //then 결과값 비교
        Assertions.assertThat(check).isTrue();
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
        Method method = winner.getClass().getDeclaredMethod("checkUserLottoNumberCount", Lotto.class);
        method.setAccessible(true);
        int six = (Integer) method.invoke(winner, sameUserLottoNumberSix);
        int fiveAndBonus = (Integer) method.invoke(winner, sameUserLottoNumberFiveAndBonus);
        int five = (Integer) method.invoke(winner, sameUserLottoNumberFive);
        int four = (Integer) method.invoke(winner, sameUserLottoNumberFour);
        int three = (Integer) method.invoke(winner, sameUserLottoNumberThree);
        int two = (Integer) method.invoke(winner, sameUserLottoNumberTwo);
        int one = (Integer) method.invoke(winner, sameUserLottoNumberOne);
        int zero = (Integer) method.invoke(winner, sameUserLottoNumberZero);

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
    public void 사용자번호_당첨번호_등수_결과() throws Exception{
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
        winner.compareWithUserLottoAndWinningLotto(userLottos, 100000);
        int sixCount = winner.countTotalLottoPrizes().get(6);
        int fiveAndBonusCount = winner.countTotalLottoPrizes().get(50);
        int fiveCount = winner.countTotalLottoPrizes().get(5);
        int fourCount = winner.countTotalLottoPrizes().get(4);
        int threeCount = winner.countTotalLottoPrizes().get(3);

        //then (기능 작동 후 결과)
        Assertions.assertThat(sixCount).isEqualTo(1);
        Assertions.assertThat(fiveAndBonusCount).isEqualTo(2);
        Assertions.assertThat(fiveCount).isEqualTo(2);
        Assertions.assertThat(fourCount).isEqualTo(1);
        Assertions.assertThat(threeCount).isEqualTo(1);
    }
}