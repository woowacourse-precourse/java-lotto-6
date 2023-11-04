package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.controller.Play.calLottoCount;
import static lotto.controller.Play.compareLottoAndWinning;

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
    void compareNumber() {
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
        Assertions.assertThat(compareLottoAndWinning(lottoNumbers, winningNumbers)).isEqualTo(5);
    }
}