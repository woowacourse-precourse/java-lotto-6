package controller;

import domain.Lotto;
import domain.Lottos;
import domain.Player;
import service.LottoService;
import view.InputMessage;
import view.OutputMessage;

import java.util.HashMap;
import java.util.List;

public class LottoController {
    private Player player;
    private Lottos lottos;
    private LottoService lottoService = new LottoService();

    public void play() {
        init();
        initPlayer();
    }

    public void init() {
        int input = InputMessage.printMoneyInputMessage();
        int totalCount = lottoService.getTotalCount(input);
        OutputMessage.moneyToNumberPrint(totalCount);
        List<Lotto> lottosList = lottoService.buyLotto(totalCount);
        OutputMessage.printLottosListOutputMessage(lottosList);
    }

    public void initPlayer() {
        List<Integer> winningNumbers = InputMessage.printWinNumberInputMessage();
        int bonusNumber = InputMessage.printBonusNumberInputMessage();
        lottoService.setPlayer(winningNumbers, bonusNumber);
    }

    private void result() {
        OutputMessage.printResultReadyOutputMessage();
        HashMap resultMap = lottoService.getWinningResult();
        OutputMessage.printResultOutputMessage(resultMap);
    }
}
