package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfitTest {

    @Test
    @DisplayName("수익률을 계산하여 반환한다.")
    void calculateTest() {
        //given
        List<Lotto> myLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
                , new Lotto(List.of(7, 8, 9, 10, 11, 12))
                , new Lotto(List.of(7, 8, 9, 10, 11, 12))
                , new Lotto(List.of(7, 8, 9, 10, 11, 12))
                , new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 40, 41, 42));
        BonusNumber bonusNumber = new BonusNumber(45);

        WinningLottoCounts winningLottoCounts = new WinningLottoCounts(myLottos, winningNumbers, bonusNumber);
        Profit profit = new Profit(winningLottoCounts, new Money(8000));

        //when
        double profitTest = profit.calculate();

        //then
        Assertions.assertThat(profitTest).isEqualTo(62.5);
    }
}