package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.PlayerLottoAmount;
import lotto.view.Inputview;

import java.util.List;

public class Application {
    public static void main(String[] args) {
//        PlayerLottoAmount playerLottoAmount =
//                new PlayerLottoAmount(Inputview.inputPurchaseAmount());
//
//        int result = playerLottoAmount.calculateLottoCount();
//        System.out.println("result = " + result);

        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Integer> list = lottoNumbers.setRandomNumbers();
        System.out.println(list);
    }
}
