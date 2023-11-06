package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.LottoPrize;
import lotto.domain.Consumer;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinLotto;
import lotto.dto.AmountRequestDto;
import lotto.dto.BonusRequestDto;
import lotto.dto.LottoResultResponseDto;
import lotto.dto.WinLottoRequestDto;
import lotto.exception.ConsumerException;
import lotto.exception.InputException;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoStoreController {

    private static LottoStoreController lottoStore;
    private final LottoMachine lottoMachine;
    private Consumer consumer;
    private WinLotto winLotto;
    private LottoResult lottoResult;

    private LottoStoreController() {
        this.lottoMachine = new LottoMachine();
        this.consumer = null;
    }

    public static LottoStoreController getLottoStore() {
        if (lottoStore == null) {
            synchronized (LottoStoreController.class) {
                lottoStore = new LottoStoreController();
            }
        }
        return lottoStore;
    }

    public void open() {
        // 구매자 구매 금액 입력
        enterBuyerPurchaseAmount();

        // 구매자 로또 구입
        buyerLottoPurchase();

        // 로또 당첨 번호 및 보너스 번호 입력
        enterWinningNumber();

        // 로또 당첨 결과
        lottoWinningResults();

        // 당첨 결과 출력
        resultPrint();
    }

    private void enterBuyerPurchaseAmount() {
        try {
            OutputView.amountOutput();

            AmountRequestDto amountRequestDto = new AmountRequestDto(InputView.amountInput());
            savePurchaseAmount(amountRequestDto);

        } catch (InputException | ConsumerException e) {
            OutputView.errorMessageOutput(e.getMessage());

            enterBuyerPurchaseAmount();
        }
    }

    private void savePurchaseAmount(AmountRequestDto amountRequestDto) throws ConsumerException {
        int purchaseAmount = amountRequestDto.amountStringToInteger();

        consumer = new Consumer(purchaseAmount);

        OutputView.newLineOutput();
    }

    private void buyerLottoPurchase() {
        int quantity = consumer.getBuyAvailableQuantity();
        List<Lotto> createdLottoes = lottoMachine.getPurchaseLottoes(quantity);

        createLottoesPrint(createdLottoes, quantity);

        consumer.receiveLottoes(createdLottoes);

        OutputView.newLineOutput();
    }

    private void createLottoesPrint(List<Lotto> lottoes, int quantity) {
        OutputView.lottoBuyQuantityOutput(quantity);

        for (Lotto lotto : lottoes) {
            OutputView.lottoNumberOutput(lotto.toString());
        }
    }

    private void enterWinningNumber() {
        try {
            OutputView.winLottoNumberOutput();

            WinLottoRequestDto winLottoRequestDto = new WinLottoRequestDto(InputView.winLottoNumberInput());
            Lotto lotto = new Lotto(winLottoRequestDto.lottoStringToList());

            OutputView.newLineOutput();

            enterBonusNumber(lotto);
        } catch (InputException | LottoException e) {
            OutputView.errorMessageOutput(e.getMessage());

            enterWinningNumber();
        }
    }

    private void enterBonusNumber(Lotto lotto) {
        try {
            OutputView.bonusLottoNumberOutput();

            BonusRequestDto bonusRequestDto = new BonusRequestDto(InputView.bonusNumberInput());
            int bonusNumber = bonusRequestDto.bonusStringToInteger();

            winLotto = new WinLotto(lotto, bonusNumber);

            OutputView.newLineOutput();

        } catch (InputException | LottoException e) {
            OutputView.errorMessageOutput(e.getMessage());

            enterBonusNumber(lotto);
        }
    }

    private void lottoWinningResults() {
        List<LottoPrize> lottoPrizes = new ArrayList<>();
        List<Lotto> lottoes = consumer.getLottoes();
        for (Lotto lotto : lottoes) {
            lottoPrizes.add(winLotto.lottoComparison(lotto));
        }

        lottoResult = new LottoResult(lottoPrizes, consumer.getBuyAmount());
    }

    private void resultPrint() {
        LottoResultResponseDto lottoResultResponseDto = new LottoResultResponseDto(
                lottoResult.getLottoWinningCounts()
                , lottoResult.getProfitRate()
        );

        OutputView.lottoResultOutput(
                lottoResultResponseDto.prizeResults(),
                lottoResultResponseDto.toStringProfitRate()
        );
    }

}
