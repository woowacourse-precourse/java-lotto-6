package lotto.domain.lotto;

import lotto.Lotto;
import lotto.domain.BonusNumber;
import lotto.domain.winning.WinningGrade;
import lotto.domain.winning.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoCompareTest {
    private final LottoCompare compare = new LottoCompare();

    @DisplayName("당첨 번호와 로또 번호가 6개 일치하면 1등이다.")
    @Test
    void createFirstWinningGrade() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        winningNumbers.addBonusNumber(bonusNumber);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        compare.compareAllLottoToWinning(lottos, winningNumbers);

        Map<WinningGrade, Integer> result = compare.getWinningResult();
        Map<WinningGrade, Integer> expected = new EnumMap<>(WinningGrade.class);
        expected.put(WinningGrade.FIRST, 1);

        assertEquals(expected.get(WinningGrade.FIRST), result.get(WinningGrade.FIRST));
    }

    @DisplayName("당첨 번호와 로또 번호가 5개 일치하고, 보너스 번호도 일치하면 2등이다.")
    @Test
    void createSecondWinningGrade() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        winningNumbers.addBonusNumber(bonusNumber);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        compare.compareAllLottoToWinning(lottos, winningNumbers);

        Map<WinningGrade, Integer> result = compare.getWinningResult();
        Map<WinningGrade, Integer> expected = new EnumMap<>(WinningGrade.class);
        expected.put(WinningGrade.SECOND, 1);

        assertEquals(expected.get(WinningGrade.SECOND), result.get(WinningGrade.SECOND));
    }

    @DisplayName("당첨 번호와 로또 번호가 5개 일치하면 3등이다.")
    @Test
    void createThirdWinningGrade() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        winningNumbers.addBonusNumber(bonusNumber);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));

        compare.compareAllLottoToWinning(lottos, winningNumbers);

        Map<WinningGrade, Integer> result = compare.getWinningResult();
        Map<WinningGrade, Integer> expected = new EnumMap<>(WinningGrade.class);
        expected.put(WinningGrade.THIRD, 1);

        assertEquals(expected.get(WinningGrade.THIRD), result.get(WinningGrade.THIRD));
    }

    @DisplayName("당첨 번호와 로또 번호가 4개 일치하면 4등이다.")
    @Test
    void createFourthWinningGrade() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        winningNumbers.addBonusNumber(bonusNumber);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));

        compare.compareAllLottoToWinning(lottos, winningNumbers);

        Map<WinningGrade, Integer> result = compare.getWinningResult();
        Map<WinningGrade, Integer> expected = new EnumMap<>(WinningGrade.class);
        expected.put(WinningGrade.FOURTH, 1);

        assertEquals(expected.get(WinningGrade.FOURTH), result.get(WinningGrade.FOURTH));
    }

    @DisplayName("당첨 번호와 로또 번호가 3개 일치하면 5등이다.")
    @Test
    void createFifthWinningGrade() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        winningNumbers.addBonusNumber(bonusNumber);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));

        compare.compareAllLottoToWinning(lottos, winningNumbers);

        Map<WinningGrade, Integer> result = compare.getWinningResult();
        Map<WinningGrade, Integer> expected = new EnumMap<>(WinningGrade.class);
        expected.put(WinningGrade.FIFTH, 1);

        assertEquals(expected.get(WinningGrade.FIFTH), result.get(WinningGrade.FIFTH));
    }

    @DisplayName("당첨 번호와 로또 번호가 2개로 일치하면 6등이다.")
    @Test
    void createNoWinningGrade() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        winningNumbers.addBonusNumber(bonusNumber);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 8, 9, 10, 11)));
        lottos.add(new Lotto(List.of(1, 20, 21, 22, 23, 24)));
        lottos.add(new Lotto(List.of(30, 31, 32, 33, 34, 35)));

        compare.compareAllLottoToWinning(lottos, winningNumbers);

        Map<WinningGrade, Integer> result = compare.getWinningResult();
        Map<WinningGrade, Integer> expected = new EnumMap<>(WinningGrade.class);
        expected.put(WinningGrade.DEFAULT, 3);

        assertEquals(expected.get(WinningGrade.DEFAULT), result.get(WinningGrade.DEFAULT));
    }
}