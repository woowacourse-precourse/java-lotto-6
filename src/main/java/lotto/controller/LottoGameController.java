package lotto.controller;

import static lotto.configuration.IntegerConstants.COST_OF_LOTTO;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.ThousandUnitMoney;
import lotto.domain.WinningResult;
import lotto.domain.dto.LottoGameDto;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGameService lottoGameService;

    public LottoGameController(InputView inputView,
                               OutputView outputView,
                               LottoGameService lottoGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGameService = lottoGameService;
    }

    public void playGame() {
        //구입 금액입력받기
        String purchaseAmountInput = inputView.inputPurchaseAmount();

        //purchaseAmount를 Money로 변환
        ThousandUnitMoney purchasePrice = ThousandUnitMoney.create(purchaseAmountInput);
        //Money만큼 로또담아 Lottos 생성
        Lottos automaticLottos = Lottos.createAutomatic(purchasePrice, COST_OF_LOTTO.getValue());

        //Lottos출력
        outputView.outputPurchaseLottoList(automaticLottos);

        //당첨 번호 입력받기
        //보너스 번호 입력받기
        String winningNumbersInput = inputView.inputWinningLotto();
        String bonusNumberInput = inputView.inputBonusNumber();

        //Lotto로 변환
        //로또 넘버로 변환
        Lotto winningNumbers = Lotto.create(winningNumbersInput);
        LottoNumber bonusNumber = LottoNumber.create(bonusNumberInput);

        //당첨 개수, 총수익률 계산
        WinningResult winningResult = lottoGameService.calcWinningResult(
                winningNumbers,
                bonusNumber,
                automaticLottos,
                purchasePrice);

        //당첨 통계 출력
        outputView.outputWinningStatistics(winningResult);

        //데이터를 lottoGame에 담아 보관
        LottoGame lottoGame = LottoGame.create(
                purchasePrice,
                automaticLottos,
                winningNumbers,
                bonusNumber,
                winningResult);

        //service를 통해 게임 저장
        Long lottoGameId = lottoGameService.saveLottoGame(lottoGame);


        //재시작기능
        replayGame(false);
    }

    private void replayGame(boolean isContinue) {
        if (isContinue) {
            playGame();
        }
    }
}
