package lotto.controller;

import lotto.model.LottoMachine;
import lotto.model.LottoRandomGenerator;
import lotto.model.LottoShop;
import lotto.model.Player;
import lotto.model.WinningLotto;

public class LottoGameService {
    private final InputController inputController;
    private final OutputController outputController;

    private final LottoShop lottoShop;
    private final Player player;

    public LottoGameService(InputController inputController, OutputController outputController) {
        LottoMachine lottoMachine = new LottoMachine(new LottoRandomGenerator());
        lottoShop = new LottoShop(lottoMachine);
        player = new Player();
        this.inputController = inputController;
        this.outputController = outputController;
    }

    public void run() {
        // 외부로부터 구입할 금액 입력 받기
        player.setBudget(inputController.askBudget());

        // player가 lottoShop에서 로또 구매
        player.buyLottoTickets(lottoShop);
        outputController.printLottoTickets(player.getLottoTickets());

        // 외부로부터 당첨 번호, 보너스 번호 입력 받기
        WinningLotto winningLotto = inputController.askWinningLotto();

        // player 스스로 당첨 결과 계산
        player.calculateWinningLottoWithMine(winningLotto);
        outputController.printWinningStatistics(player.getWinningStatistics());
    }
}