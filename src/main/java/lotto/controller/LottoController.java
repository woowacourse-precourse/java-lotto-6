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

        OutputView.printBonusNumberMessage();
        getBonusNumber();


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

        try {
            Validator.winNumberNum(winNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("당첨 번호를 6개 입력해주세요.");
            getWinLottoNumber();
        }

        try {
            Validator.winNumberDuplication(winNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("당첨 번호를 중복 없이 입력해주세요.");
            getWinLottoNumber();
        }

        return winNumber;
    }

    public void getBonusNumber() {
        int bonusNumber = InputView.inputBonusNumber();

        try {
            Validator.bonusNumberNum(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("1개만 입력하세요.");
            getLottoNumber();
        }
    }
}
