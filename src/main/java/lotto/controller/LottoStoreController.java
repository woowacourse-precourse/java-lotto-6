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
import lotto.exception.InputException;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoStoreController {

    private final LottoMachine lottoMachine;
    private Consumer consumer;
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

            // 구매 금액 저장
            consumer = new Consumer(amountRequestDto.amountStringToInteger());

            // 줄 바꿈
            OutputView.newLineOutput();

        } catch (IllegalArgumentException e) {
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
        // 요청 한 갯수만큼의 로또 생성
        List<Lotto> createLottos = lottoMachine.createLottos(consumer.getBuyAvailableQuantity());

        // 생성된 로또 출력
        createLottosPrint(createLottos);

        // 구입 로또 저장 및 구입 로또 수량 확인
        consumer.buyLotto(createLottos);

        // 줄 바꿈
        OutputView.newLineOutput();
    }

    /**
     * 로또 정보 출력
     *
     * @param lottos
     */
    private void createLottosPrint(List<Lotto> lottos) {
        // 구입 로또 수량 출력
        OutputView.lottoBuyQuantityOutput(consumer.getBuyAvailableQuantity());

        // 구입 로또 출력
        for (Lotto lotto : lottos) {
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

            // 당첨 번호 로또 생성
            Lotto lotto = new Lotto(winLottoRequestDto.lottoStringToList());

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

            // 당첨 로또 등록
            WinLotto winLotto = new WinLotto(lotto, bonusRequestDto.bonusStringToInteger());

            lottoMachine.setWinLotto(winLotto);
            // 줄 바꿈
            OutputView.newLineOutput();

        } catch (IllegalArgumentException e) {
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
        List<Lotto> lottos = consumer.getLottos();
        for (Lotto lotto : lottos) {
            lottoPrizes.add(lottoMachine.lottoWinningResult(lotto));
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
        OutputView.lottoResultOutput(lottoResultResponseDto.prizeResults(),
                lottoResultResponseDto.toStringProfitRate());
    }

}
