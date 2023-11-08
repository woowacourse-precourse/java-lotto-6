package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PurchaserTest {
    private Purchaser purchaser = new Purchaser(4000);

    @DisplayName("로또의 개수는 로또 금액은 1000으로 나눈 것이다.")
    @Test
    void calculateNumberOfLotto(){
        Integer numberOfLotto = purchaser.getNumberOfLotto();

        Assertions.assertThat(numberOfLotto).isEqualTo(4);
    }

    @DisplayName("구매한 로또 확인")
    @Test
    void buy() {
        List<Integer> list1 = List.of(8, 21, 23, 41, 42, 43);
        List<Integer> list2 = List.of(3, 5, 11, 16, 32, 38);
        List<Integer> list3 = List.of(7, 11, 16, 35, 36, 44);
        List<Integer> list4 = List.of(1, 8, 11, 31, 41, 42);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> lottos = purchaser.buy();
                    Assertions.assertThat(lottos.get(0).getNumbers()).isEqualTo(list1);
                    Assertions.assertThat(lottos.get(1).getNumbers()).isEqualTo(list2);
                    Assertions.assertThat(lottos.get(2).getNumbers()).isEqualTo(list3);
                    Assertions.assertThat(lottos.get(3).getNumbers()).isEqualTo(list4);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42)
        );
    }

    @DisplayName("당첨 계산 로직 확인")
    @Test
    void checkWinningResult() {
        List<Integer> list1 = List.of(8, 21, 23, 41, 42, 43);
        List<Integer> list2 = List.of(3, 5, 11, 16, 32, 38);
        List<Integer> list3 = List.of(7, 11, 16, 35, 36, 41);
        List<Integer> list4 = List.of(1, 8, 11, 31, 41, 42);

        assertRandomUniqueNumbersInRangeTest(
                () -> purchaser.buy(),
                list1, // None
                list2,  // None
                list3, // 5000
                list4   // 5+a
        );

        List<Integer> winningNumbers = List.of(1, 8, 11, 16, 31, 41);
        Integer bonusNumber = 42;
        Map<WinningPrice, List<Lotto>> winningPriceListMap = purchaser.checkWinningResult(winningNumbers, bonusNumber);

        List<Lotto> list0 = winningPriceListMap.get(WinningPrice.NONE);
        List<Lotto> list5000 = winningPriceListMap.get(WinningPrice.FIFTY_HUNDRED);
        List<Lotto> list30 = winningPriceListMap.get(WinningPrice.THREE_MILLION);

        Assertions.assertThat(list0.size()).isEqualTo(2);
        Assertions.assertThat(list0.get(0).getNumbers()).isEqualTo(list1);
        Assertions.assertThat(list0.get(1).getNumbers()).isEqualTo(list2);

        Assertions.assertThat(list5000.size()).isEqualTo(1);
        Assertions.assertThat(list5000.get(0).getNumbers()).isEqualTo(list3);

        Assertions.assertThat(list30.size()).isEqualTo(1);
        Assertions.assertThat(list30.get(0).getNumbers()).isEqualTo(list4);
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateEarningsRate() {
        assertRandomUniqueNumbersInRangeTest(
                () -> purchaser.buy(),
                List.of(8, 21, 23, 41, 42, 43), // None
                List.of(3, 5, 11, 16, 32, 38),  // None
                List.of(7, 11, 16, 35, 36, 41), // 5000
                List.of(1, 8, 11, 31, 41, 42)   // 5+a
        );
        List<Integer> winningNumbers = List.of(1, 8, 11, 16, 31, 41);
        Integer bonusNumber = 42;
        purchaser.checkWinningResult(winningNumbers, bonusNumber);

        Double earningsRate = purchaser.calculateEarningsRate();
        Assertions.assertThat(earningsRate).isEqualTo(750125.0);
    }
}