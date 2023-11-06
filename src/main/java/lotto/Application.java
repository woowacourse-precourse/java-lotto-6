package lotto;

import lotto.domain.LottoAmount;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
//        LottoAmount playerLottoAmount = new LottoAmount(InputView.inputPlayerAmount());
//
//        int lottoNum=playerLottoAmount.calcLottoNum();
//        System.out.println(lottoNum);

        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Integer> result= lottoNumbers.setLottoNumbers();
        System.out.println(result);

    }
}
