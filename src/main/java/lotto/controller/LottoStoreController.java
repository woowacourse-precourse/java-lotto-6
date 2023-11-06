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

    private final LottoMachine lottoMachine;
    private Consumer consumer;
    private WinLotto winLotto;
    private LottoResult lottoResult;

    public LottoStoreController() {
        this.lottoMachine = LottoMachine.getInstance();
        this.consumer = null;
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

    /**
     * 구매 금액 등록
     */
    private void enterBuyerPurchaseAmount() {
        try {
            // 구매 금액 입력 문구 출력
            OutputView.amountOutput();

            // 구매 금액 입력
            AmountRequestDto amountRequestDto = new AmountRequestDto(InputView.amountInput());
            int purchaseAmount = amountRequestDto.amountStringToInteger();

            // 구매 금액 저장
            consumer = new Consumer(purchaseAmount);

            // 줄 바꿈
            OutputView.newLineOutput();

        } catch (InputException | ConsumerException e) {
            // 예외 출력
            OutputView.errorMessageOutput(e.getMessage());

            // 구매 금액 재 입력
            enterBuyerPurchaseAmount();
        }
    }

    /**
     * 로또 구매
     */
    private void buyerLottoPurchase() {
        // 요청 한 갯수 만큼의 로또 생성
        int quantity = consumer.getBuyAvailableQuantity();
        List<Lotto> createdLottoes = lottoMachine.getPurchaseLottoes(quantity);

        // 생성된 로또 출력
        createLottoesPrint(createdLottoes, quantity);

        // 구입 로또 저장 및 구입 로또 수량 확인
        consumer.receiveLottoes(createdLottoes);

        // 줄 바꿈
        OutputView.newLineOutput();
    }

    /**
     * 로또 정보 출력
     *
     * @param lottoes
     */
    private void createLottoesPrint(List<Lotto> lottoes, int quantity) {
        // 구입 로또 수량 출력
        OutputView.lottoBuyQuantityOutput(quantity);

        // 구입 로또 출력
        for (Lotto lotto : lottoes) {
            OutputView.lottoNumberOutput(lotto.toString());
        }
    }

    /**
     * 로또 당첨 번호 등록
     */
    private void enterWinningNumber() {
        try {
            // 당첨 번호 입력 문구 출력
            OutputView.winLottoNumberOutput();

            // 당첨 번호 입력
            WinLottoRequestDto winLottoRequestDto = new WinLottoRequestDto(InputView.winLottoNumberInput());
            List<Integer> lottoNumber = winLottoRequestDto.lottoStringToList();

            // 당첨 번호 로또 생성
            Lotto lotto = new Lotto(lottoNumber);

            // 줄 바꿈
            OutputView.newLineOutput();

            // 보너스 번호 입력
            enterBonusNumber(lotto);

        } catch (InputException | LottoException e) {
            // 예외 출력
            OutputView.errorMessageOutput(e.getMessage());

            // 당첨 번호 재 입력
            enterWinningNumber();
        }
    }

    /**
     * 로또 보너스 번호 등록
     *
     * @param lotto
     */
    private void enterBonusNumber(Lotto lotto) {
        try {
            // 보너스 번호 입력 문구 출력
            OutputView.bonusLottoNumberOutput();

            // 보너스 번호 입력
            BonusRequestDto bonusRequestDto = new BonusRequestDto(InputView.bonusNumberInput());
            int bonusNumber = bonusRequestDto.bonusStringToInteger();

            // 당첨 로또 등록
            winLotto = new WinLotto(lotto, bonusNumber);
            
            // 줄 바꿈
            OutputView.newLineOutput();

        } catch (InputException | LottoException e) {
            // 예외 출력
            OutputView.errorMessageOutput(e.getMessage());

            // 보너스 번호 재 입력
            enterBonusNumber(lotto);
        }
    }

    /**
     * 로또 당첨 결과
     */
    private void lottoWinningResults() {
        List<LottoPrize> lottoPrizes = new ArrayList<>();
        List<Lotto> lottoes = consumer.getLottoes();
        for (Lotto lotto : lottoes) {
            lottoPrizes.add(winLotto.lottoComparison(lotto));
        }

        // 로또 당첨 결과 등록
        lottoResult = new LottoResult(lottoPrizes, consumer.getBuyAmount());
    }

    /**
     * 당첨 결과 출력
     */
    private void resultPrint() {
        LottoResultResponseDto lottoResultResponseDto = new LottoResultResponseDto(
                lottoResult.getLottoWinningCounts()
                , lottoResult.getProfitRate()
        );

        // 당첨 결과 출력
        OutputView.lottoResultOutput(
                lottoResultResponseDto.prizeResults(),
                lottoResultResponseDto.toStringProfitRate()
        );
    }

}
