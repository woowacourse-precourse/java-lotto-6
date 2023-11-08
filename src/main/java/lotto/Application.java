package lotto;

import java.util.List;

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
}
