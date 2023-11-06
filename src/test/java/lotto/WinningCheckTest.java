package lotto;

import lotto.domain.*;
import lotto.utility.GameUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("당첨 확인 기능 테스트")
public class WinningCheckTest {
    @Test
    @DisplayName("1등부터 6등을 한 번씩 했을 때 결과랑 일치하는 지 테스트")
    void 당첨_확인_기능_테스트() {
        // given
        Payment payment = new Payment(5000);
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6)); //1등 번호
        BonusNumber bonusNumber = new  BonusNumber(7); //보너스 번호
        WinningAndBonusNumber.create(winningNumber, bonusNumber);
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); //1등
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); //2등
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 40)); //3등
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 39, 40)); //4등
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 38, 39, 40)); //5등
        List<Lotto> lottoList = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);
        Customer user = new Customer(payment, lottoList);
        // when
        WinningResult winningResult = GameUtility.calculateCustomerWinningResult(user);
//            // then
        assertEquals(winningResult.getNumberOfPrizeFromIndex(1), 1);
        assertEquals(winningResult.getNumberOfPrizeFromIndex(2), 1);
        assertEquals(winningResult.getNumberOfPrizeFromIndex(3), 1);
        assertEquals(winningResult.getNumberOfPrizeFromIndex(4), 1);
        assertEquals(winningResult.getNumberOfPrizeFromIndex(5), 1);
    }


}