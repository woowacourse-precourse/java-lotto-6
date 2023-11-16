package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoDomainTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void testLottoCreation() {
        // 유효한 로또 번호 리스트를 생성
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // 유효한 로또 번호 리스트로 로또 객체를 생성
        Lotto lotto = new Lotto(numbers);

        // 생성된 로또 객체의 번호 리스트가 입력한 번호 리스트와 같은지 확인
        assertEquals(numbers, lotto.getNumbers());
    }

    @Test
    @DisplayName("당첨 번호 테스트")
    void testWinningNumbers() {
        // 당첨 번호 리스트와 보너스 번호를 생성
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbers, bonusNumber);

        // 입력한 당첨 번호 리스트와 보너스 번호가 주어진 로또와 일치하는지 확인
        assertEquals(Rank.FIRST, winningNumbersObj.calculateRank(new Lotto(winningNumbers)));
        assertEquals(Rank.MISS, winningNumbersObj.calculateRank(new Lotto(List.of(7, 8, 9, 10, 11, 12))));
    }

    @Test
    @DisplayName("당첨 결과 테스트")
    void testWinningResult() {
        // 로또 티켓 목록, 당첨 번호 및 보너스 볼을 생성
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // 생성된 로또 티켓 목록과 당첨 번호로 당첨 결과를 계산
        WinningResult winningResult = WinningResult.calculate(lottos, winningNumbers);

        // 각 Rank(등수)별 당첨 횟수를 확인
        assertEquals(1, winningResult.getCount(Rank.FIRST));
        assertEquals(1, winningResult.getCount(Rank.SECOND));
        assertEquals(1, winningResult.getCount(Rank.MISS));
    }
}
