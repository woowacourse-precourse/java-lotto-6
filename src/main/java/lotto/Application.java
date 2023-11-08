package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Calculator.*;
import static lotto.Calculator.displayResults;
import static lotto.Lotto.*;
import static lotto.Lotto.inputBonusNumber;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int coin = inputCoin();
        List<Lotto> lottoList = toChangeLotto(coin);    //구매금액 입력
        List<Integer> winningNumbers = inputWinningNumbers();   //당첨번호 입력
        int bonusNumber = inputBonusNumber();   //보너스 번호 입력
        checkLottoResultsAndDisplay(lottoList, winningNumbers, bonusNumber);
    }

    public enum LottoResult {
        FIFTH_PRIZE("3개 일치 (5,000원)", 5000),
        FOURTH_PRIZE("4개 일치 (50,000원)", 50000),
        THIRD_PRIZE("5개 일치 (1,500,000원)", 1500000),
        SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
        FIRST_PRIZE("6개 일치 (2,000,000,000원)", 2000000000),
        NO_PRIZE("꽝", 0);
        private final String description;
        private final int prizeAmount;
        LottoResult(String description, int prizeAmount) {
            this.description = description;
            this.prizeAmount = prizeAmount;
        }

        public String getDescription() {
            return description;
        }

        public int getPrizeAmount() {
            return prizeAmount;
        }
    }
}
