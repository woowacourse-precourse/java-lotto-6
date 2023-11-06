package lotto.model;

import lotto.controller.InputController;
import lotto.domain.Lotto;
import lotto.domain.LottoBoard;
import lotto.domain.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoGame {
    private LottoBoard lottoBoard;
    private Player player;
    private InputController inputController = new InputController();
    private int[] result = {0, 0, 0, 0, 0};

    public LottoGame() {
        inputController.startGame();
        lottoBoard = new LottoBoard(inputController.getMoney());

        player = new Player(inputController.playerInput(), inputController.bonusInput());

        for (int i = 0; i < lottoBoard.getTickets(); i++) {
            checkLotto(lottoBoard.getOneLotto(i), player.getNumbers(), player.getBonus());
        }
    }

    void checkLotto(Lotto lotto, List<Integer> numbers, Integer bonus) {
        System.out.println(lotto);
    }

}
