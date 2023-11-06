package lotto;

import lotto.domain.LottoAmount;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        LottoAmount playerLottoAmount = new LottoAmount(InputView.inputPlayerAmount());

        int lottoNum=playerLottoAmount.calcLottoNum();
        System.out.println(lottoNum);


    }
}
