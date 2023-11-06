package lotto.controller;

import lotto.domain.*;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView;
    OutputView outputView;
    User user;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.user = new User();
    }

    public void run() {
        issueLotto();
        getWinningNumbers();
        printLottoResult();
    }

    private UserLottos issueLotto() {
        // 구매 가격 받아 오기
        inputView.requestPurchasePrice();
        Price price = user.requestPurchasePrice();

        // 로또 발행 하고 출력
        UserLottos userLottos = user.generateAllLottos(price);
        outputView.printNumberOfPurchase(userLottos.getLottos().size());
        outputView.printAllLottoNumbersList(userLottos);

        return userLottos;
    }

    private LottoWinning getWinningNumbers() {
        // 당첨 번호와 보너스 번호 입력 받기
        inputView.requestWinningNum();
        Lotto winningNums = user.requestWinningNums();

        inputView.requestBonusNum();
        LottoNumber bonusNum = user.requestBonusNum(winningNums);

        LottoWinning lottoWinning = new LottoWinning(winningNums, bonusNum);
        return lottoWinning;
    }

    private void printLottoResult() {

    }
}
