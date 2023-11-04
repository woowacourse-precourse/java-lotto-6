package controller;

import service.LottoService;

import view.GameView;

import java.util.List;

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

    public void winningLottoAdd(List<Integer> numbers) {
        // TODO: 인자로 받은 번호 당첨 번호 생성
    }

    public void BonusLottoAdd(int number) {
        // TODO: 인자로 받은 번호 보너스 번호 생성
    }
}
