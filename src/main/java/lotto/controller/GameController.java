package lotto.controller;

import java.util.List;
import lotto.enums.Rank;
import lotto.model.Lotto;
import lotto.service.GameService;
import lotto.view.UserView;

public class GameController {

    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public void gameSetting() {
        String money = UserView.startMessage();
        int lottoCount = calculateLottoCount(money);
        UserView.printLottoMessage(lottoCount);
        List<Lotto> lottoList = gameService.createLotto(lottoCount);
        UserView.showLottoList(lottoList);

        String numbers = UserView.winNumberMessage();
        List<Integer> winNumber = gameService.generateWinNumber(numbers);
        UserView.showWinNumber(winNumber);

        String bonus = UserView.bonusNumberMessage();
        int bonusNumber = gameService.generateBonusNumber(bonus);
        UserView.showBonusNumber(bonusNumber);

        List<Rank> rankList = gameService.checkWinNumbers(winNumber, lottoList, bonusNumber);
        UserView.winStatisticsMessage(rankList);
    }


    // Lotto 구입 개수 계산
    private int calculateLottoCount(String money) {
        int lottoCount = Integer.parseInt(money);
        return lottoCount/1000;
    }
}
