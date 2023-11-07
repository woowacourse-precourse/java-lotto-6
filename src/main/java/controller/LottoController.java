package controller;

import domain.Lottos;
import domain.Player;
import service.LottoService;
import view.InputMessage;
import view.OutputMessage;

public class LottoController {
    private Player player;
    private Lottos lottos;
    private LottoService lottoService = new LottoService();

    public void play() {

    }

    private void init() {
        int input = InputMessage.moneyInitInputMessage();
        lottoService.buyLotto(input);
    }
}
