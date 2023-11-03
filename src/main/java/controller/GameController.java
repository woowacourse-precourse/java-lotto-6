package controller;

import service.LottoService;

import view.GameView;

public class GameController {

    private final LottoService lottoService;
    private final GameView gameView;

    public GameController(LottoService lottoService, GameView gameView) {
        this.lottoService = lottoService;
        this.gameView = gameView;
    }

    public void lottoAdd(String pay) {
        // TODO: 인자로 받은 금액 예외 처리 후 로또 구매
    }

    public void winningLottoAdd(String numbers) {
        // TODO: 인자로 받은 번호 예외 처리 후 당첨 번호 생성
    }

    public void BonusLottoAdd(String number) {
        // TODO: 인자로 받은 번호 예외 처리 후 보너스 번호 생성
    }
}
