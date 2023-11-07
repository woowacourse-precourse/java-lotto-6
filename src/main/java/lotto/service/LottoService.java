package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.Player;
import lotto.domain.WinningLotto;
import lotto.validation.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class LottoService {
    private final InputView inputView;
    private final OutputView outputView;
    private final Lottos lottos;
    private final Validation validation;
    private Player player;

    public LottoService(InputView inputView, OutputView outputView, Validation validation, Lottos lottos) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validation = validation;
        this.lottos = lottos;
    }

    public void createPlayer() {
        try {
            String quantity = inputView.enterMoney();
            player = new Player(quantity);
            createLotto(player);
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            createPlayer();
        }
    }

    private void createLotto(Player player) {
        for (int i = 0; i < player.getQuantity(); i++) {
            lottos.pickLottos();
        }
        printQuantity(player);
        printLottos(lottos);
    }

    private void printQuantity(Player player) {
        outputView.printCount(player.getQuantity());
    }

    private void printLottos(Lottos lottos) {
        for (int i = 0; i < lottos.getLotto().size(); i++) {
            List<Integer> sortNum = new ArrayList<>(lottos.getLotto().get(i).getNumbers());
            Collections.sort(sortNum);
            outputView.printLottos(sortNum);
        }
    }

    public void createWinningLotto() {
        try {
            String[] lotto = inputView.enterWinningLotto().trim().split(",");
            List<Integer> lottos = new ArrayList<>();
            for (String num : lotto) {
                int winningNum = validation.checkWinningNum(num);
                lottos.add(winningNum);
            }
            validation.totalWinngLottoCheck(lottos);

            int bonusNum = createBonusNum(lottos);
            createStatistic(new WinningLotto(lottos, bonusNum));
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            createWinningLotto();
        }
    }

    private int createBonusNum(List<Integer> lottos) {
        try {
            int bonusNum = validation.checkBonusNum(inputView.enterBonus());
            validation.totalBonusNumCheck(lottos, bonusNum);
            return bonusNum;
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return createBonusNum(lottos);
        }
    }

    private void createStatistic(WinningLotto winningLotto) {
        winningLotto.calculatePrize(lottos, player);
        accordStatistic(winningLotto);
    }

    private void accordStatistic(WinningLotto winningLotto) {
        outputView.printResult(winningLotto);
    }

    public void totalPercent() {
        outputView.printTotal(player);
    }
}