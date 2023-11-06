package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.RandomLottoFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int lottoQuantity = getLottoQuantity();

        List<Lotto> lottos = generateRandomLottos(lottoQuantity);

        List<LottoNumber> lottoWinnerNumbers = getLottoWinnerNumbers();

        LottoNumber lottoBonusNumber = getLottoBonusNumber();

        // TODO : 로또 결과 계산

        outputView.writeResult();
    }

    private List<Lotto> generateRandomLottos(int lottoQuantity) {
        List<Lotto> lottos = RandomLottoFactory.generateLottos(lottoQuantity);
        outputView.writeGeneratedLotto(lottos);
        outputView.writeBlank();
        return lottos;
    }

    private Money getMoney() {
        outputView.writeLottoPurchaseMoney();
        return inputView.readUserPurchaseMoney();
    }

    private int getLottoQuantity() {
        try{
            Money purchaseMoney = getMoney();
            int availableForPurchase = purchaseMoney.quantityAvailableForPurchase(1000);
            outputView.writeBlank();
            return availableForPurchase;
        } catch (IllegalArgumentException e) {
            outputView.writeWithErrorMessage(e.getMessage());
            outputView.writeBlank();
            return getLottoQuantity();
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
