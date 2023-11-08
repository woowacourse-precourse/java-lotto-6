package lotto.domain;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoManagerTest {

    @DisplayName("로또 당첨 통계를 만들어보자.")
    @Test
    void createLottoStatistics() {
        LottoBuyer lottoBuyer = new LottoBuyer(5000);

        List<Integer> winningNumbers = List.of(1, 5, 7, 23, 41, 44);
        int bonusNumber = 34;

        LottoManager lottoManager = new LottoManager(winningNumbers, bonusNumber);

        lottoManager.countMatchingWinningLottoNumbers(lottoBuyer);

//        for (Map.Entry<LottoResult, Integer> entry : lottoManager.getWinningLottoNumbers().entrySet()) {
//            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//        }
        System.out.println("보너스번호가 있는 당첨번호 5개가 일치하는 경우: " + lottoManager.getBonusLottoNumber());
    }
}
