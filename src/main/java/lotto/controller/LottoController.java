package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static java.util.Collections.sort;

public class LottoController {

    public void startLotto() {
        OutputView.printGetPurchasePriceMessage();
        int purchasePrice = InputView.inputPurchasePrice();

        int lottoNum = getLottoNum(purchasePrice);
        OutputView.printLottoNumMessage(lottoNum);

        for(int i = 0; i < lottoNum ; i++) {
            OutputView.printLottoNumber(getLottoNumber());
        }

        System.out.println();

        OutputView.printWinNumberMessage();
        getWinLottoNumber();

    }

    public int getLottoNum(int purchasePrice) {
        int lottoNum = purchasePrice / 1000;
        return lottoNum;
    }

    public List<Integer> getLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sort(lottoNumber);
        return lottoNumber;
    }

    public List<Integer> getWinLottoNumber() {
        List<Integer> winNumber = InputView.inputWinNumber();

        return winNumber;
    }
}
