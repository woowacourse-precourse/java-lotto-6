package lotto.config;

import lotto.controller.LottoController;
import lotto.controller.PlayerController;
import lotto.domain.LottoMachine;
import lotto.domain.Player;
import lotto.service.LottoService;
import lotto.service.PlayerService;

public class AppConfig {

    public Player player() {
        return new Player();
    }

    public LottoService lottoService() {
        return LottoService.getInstance();
    }

    public PlayerService playerService() {
        return PlayerService.getInstance(lottoService(), player());
    }

    public LottoController lottoController() {
        return LottoController.getInstance(playerService());
    }

    public PlayerController playerController() {
        return PlayerController.getInstance(playerService());
    }

    public LottoMachine lottoMachine() {
        return new LottoMachine(playerController(), lottoController());
    }

}
