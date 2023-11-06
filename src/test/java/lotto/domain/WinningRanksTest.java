package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class WinningDetailsTest {
    @DisplayName("당첨 내역을 계산한다.")
    @Test
    void calculateProfitAmount() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        lottos.add(lotto1);
        lottos.add(lotto2);

        WinningNumber winningNumber = new WinningNumber(List.of(34, 21, 22, 43, 15, 7));
        BonusNumber bonusNumber = new BonusNumber(10);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber, bonusNumber);

        WinningDetails winningDetails = new WinningDetails(lottos, winningNumbers);

        winningDetails.getDetails();
    }
}