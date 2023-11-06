package lotto;

import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.controller.Play.*;
import static lotto.controller.Statistic.calLottoCount;
import static lotto.controller.lotteryController.makeLottery;
import static lotto.controller.winningController.compareLottoAndBonus;
import static lotto.controller.winningController.compareLottoAndWinningNumber;

public class PlayTest {
    @DisplayName("로또 한 장의 금액에 따라서 로또의 수를 반환한다.")
    @Test
    void calLottoCountTest() {
        int priceA = 10000;
        int lottoCountA = calLottoCount(priceA);
        Assertions.assertThat(lottoCountA).isEqualTo(10);

        int priceB = 10010;
        int lottoCountB = calLottoCount(priceB);
        Assertions.assertThat(lottoCountB).isEqualTo(10);
    }

    @DisplayName("로또와 당첨 번호를 비교해서 맞는 번호의 수를 반환한다.")
    @Test
    void compareLottoAndWinningTest() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(6);

        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(6);
        winningNumbers.add(5);
        winningNumbers.add(4);
        winningNumbers.add(3);
        winningNumbers.add(2);
        winningNumbers.add(9);
        Assertions.assertThat(compareLottoAndWinningNumber(lottoNumbers, winningNumbers)).isEqualTo(5);
    }

    @DisplayName("로또와 보너스 숫자를 비교해서 맞으면 참, 틀리면 거짓을 반환한다.")
    @Test
    void compareLottoAndBonusTest() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(6);

        int bonusA = 1;
        Assertions.assertThat(compareLottoAndBonus(lottoNumbers, bonusA)).isEqualTo(true);

        int bonusB = 7;
        Assertions.assertThat(compareLottoAndBonus(lottoNumbers, bonusB)).isEqualTo(false);
    }

    @DisplayName("로또 번호 랜덤 생성")
    @Test
    void makeLotteryTest() {
        Lotto lotto = makeLottery();
        for (int num : lotto.getLotto()) {
            System.out.println(num);
        }
    }

}