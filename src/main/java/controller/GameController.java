package controller;

import domain.Lotto;

import service.LottoService;

import view.GameView;

public class GameController {

    private final LottoService lottoService;
    private final GameView gameView;

    public GameController(LottoService lottoService, GameView gameView) {
        this.lottoService = lottoService;
        this.gameView = gameView;
    }

    public void lottoAdd(int pay) {
        int count = lottoService.addPay(pay);
        gameView.printGameCount(count);
        gameView.printLottoList(lottoService.addLotto(count));
    }

    public void winningLottoAdd(Lotto winningLotto) {
        lottoService.addWinningLotto(winningLotto);
    }

    public void BonusLottoAdd(int number) {
        // TODO: 인자로 받은 번호 보너스 번호 생성
    public void bonusLottoAdd(int number) throws IllegalArgumentException{
        lottoService.addBonusNumber(number);
        winList();
    }

    private void winList() {
        int[] winLottoArr = lottoService.findWinResult();
        gameView.printResult(winLottoArr);
    }
}
