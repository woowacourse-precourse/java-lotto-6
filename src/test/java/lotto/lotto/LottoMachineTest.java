package lotto.lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.money.Money;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    public void 당첨_결과_검증() {
        WinningNumber winningNumber = new WinningNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))); // 1등
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)))); // 2등
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8)))); // 3등
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 9)))); // 4등

        Map<Prize, Long> result = LottoMachine.getResult(winningNumber, lottos);

        assertEquals(1, result.getOrDefault(Prize.MATCH_6, 0L));
        assertEquals(1, result.getOrDefault(Prize.MATCH_5_BONUS, 0L));
        assertEquals(1, result.getOrDefault(Prize.MATCH_5, 0L));
        assertEquals(1, result.getOrDefault(Prize.MATCH_4, 0L));
        assertEquals(0, result.getOrDefault(Prize.MATCH_3, 0L));
    }

    @Test
    public void 로또_미당첨() {
        WinningNumber winningNumber = new WinningNumber(new ArrayList<>(Arrays.asList(10, 11, 12, 13, 14, 15)), 16);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))));

        Map<Prize, Long> result = LottoMachine.getResult(winningNumber, lottos);

        assertEquals(2, result.getOrDefault(Prize.NOTING, 0L));
    }

    @Test
    public void 당첨_상금_총액_검증() {
        WinningNumber winningNumber = new WinningNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))); // 1등
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)))); // 2등
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8)))); // 3등
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 9)))); // 4등

        Money totalPrizeMoney = LottoMachine.receiveMoney(winningNumber, lottos);

        int expectedTotalPrizeMoney = Prize.MATCH_6.getPrizeMoney() +
                Prize.MATCH_5_BONUS.getPrizeMoney() +
                Prize.MATCH_5.getPrizeMoney() +
                Prize.MATCH_4.getPrizeMoney();
        assertEquals(expectedTotalPrizeMoney, totalPrizeMoney.getAmount());
    }

    @Test
    public void 미당첨시_수령금액_검증() {
        WinningNumber winningNumber = new WinningNumber(new ArrayList<>(Arrays.asList(10, 11, 12, 13, 14, 15)), 16);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))));

        Money totalPrizeMoney = LottoMachine.receiveMoney(winningNumber, lottos);

        assertEquals(0, totalPrizeMoney.getAmount());
    }

    @Test
    public void 로또_구매_수량_검증_1() {
        Money inputMoney = new Money(5000);
        List<Lotto> lottos = LottoMachine.buyLottos(inputMoney);
        assertEquals(5, lottos.size());
    }

    @Test
    public void 로또_구매_수량_검증_2() {
        Money inputMoney = new Money(14000);
        List<Lotto> lottos = LottoMachine.buyLottos(inputMoney);
        assertEquals(14, lottos.size());
    }

}