package lotto.controller;

import lotto.domain.*;
import lotto.dto.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LotteryMachine lotteryMachine;

    public LottoController(InputView inputView, OutputView outputView, LotteryMachine lotteryMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lotteryMachine = lotteryMachine;
    }

    public void run() {
        Money purchaseMoney = getMoney();

        int lottoQuantity = getLottoQuantity(purchaseMoney);

        List<Lotto> lottos = generateRandomLottos(lottoQuantity);

        List<LottoNumber> lottoWinnerNumbers = getLottoWinnerNumbers();

        LottoNumber lottoBonusNumber = getLottoBonusNumber();

        WinningResult winningResult = lotteryMachine.judge(lottos, lottoWinnerNumbers, lottoBonusNumber);

        outputView.writeResult(winningResult, new Yield(purchaseMoney, winningResult.getRewardMoney()));
    }

    private List<Lotto> generateRandomLottos(int lottoQuantity) {
        List<Lotto> lottos = RandomLottoFactory.generateLottos(lottoQuantity);
        outputView.writeGeneratedLotto(lottos);
        outputView.writeBlank();
        return lottos;
    }

    private Money getMoney() {
        try {
            outputView.writeLottoPurchaseMoney();
            return inputView.readUserPurchaseMoney();
        } catch (IllegalArgumentException e) {
            outputView.writeWithErrorMessage(e.getMessage());
            outputView.writeBlank();
            return getMoney();
        }
    }

    private int getLottoQuantity(Money purchaseMoney) {
        try{
            int availableForPurchase = purchaseMoney.quantityAvailableForPurchase(1000);
            outputView.writeBlank();
            return availableForPurchase;
        } catch (IllegalArgumentException e) {
            outputView.writeWithErrorMessage(e.getMessage());
            outputView.writeBlank();
            return getLottoQuantity(purchaseMoney);
        }
    }

    private List<LottoNumber> getLottoWinnerNumbers() {
        try{
            outputView.writeLottoWinningNumbers();
            List<LottoNumber> winnerLottoNumbers = inputView.readWinnerLottoNumbers();
            outputView.writeBlank();
            return winnerLottoNumbers;
        } catch (IllegalArgumentException e) {
            outputView.writeWithErrorMessage(e.getMessage());
            outputView.writeBlank();
            return getLottoWinnerNumbers();
        }
    }

    private LottoNumber getLottoBonusNumber() {
        try{
            outputView.writeLottoBonusNumber();
            LottoNumber bonusNumber = inputView.readBonusNumber();
            outputView.writeBlank();
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.writeWithErrorMessage(e.getMessage());
            outputView.writeBlank();
            return getLottoBonusNumber();
        }
    }
}
