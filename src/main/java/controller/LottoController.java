package controller;

import domain.Lotto;
import domain.Lottos;
import domain.Player;
import service.LottoService;
import view.InputMessage;
import view.OutputMessage;

import java.util.List;

public class LottoController {
    private Player player;
    private Lottos lottos;
    private LottoService lottoService = new LottoService();

    public void play() {

    }

    private void init() {
        int input = InputMessage.printMoneyInputMessage();
        List<Lotto> lottosList = lottoService.buyLotto(input);
        OutputMessage.printLottosListOutputMessage(lottosList);
    }
}
