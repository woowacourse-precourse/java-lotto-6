package lotto.controller;

import java.util.List;
import lotto.enums.Rank;
import lotto.model.Lotto;
import lotto.service.GameService;
import lotto.utils.Validator;
import lotto.view.UserView;

public class GameController {

    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    private int purchaseLotto() {
        while (true) {
            try {
                String money = UserView.startMessage();
                Validator.validateMoney(money);
                return gameService.calculateLottoCount(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> generateLotto(int lottoCount) {
        UserView.printLottoMessage(lottoCount);
        List<Lotto> lottoList = gameService.createLotto(lottoCount);
        return lottoList;
    }

    private List<Integer> generateWinNumber() {
        while (true) {
            try {
                String numbersString = UserView.winNumberMessage();
                List<Integer> winNumber = gameService.generateWinNumber(numbersString);
                Validator.validateWinningNumber(winNumber);  // 유효성 검증 메서드 추가 필요
                return winNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int generateBonusNumber(List<Integer> winNumber) {
        while (true) {
            try {
                String bonus = UserView.bonusNumberMessage();
                int bonusNumber = gameService.generateBonusNumber(bonus);
                Validator.validateBonusNumber(winNumber, bonus);  // 유효성 검증 메서드 추가 필요
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void playLottoGame() {
        int lottoCount = purchaseLotto();
        List<Lotto> lottoList = generateLotto(lottoCount);
        UserView.showLottoList(lottoList);

        List<Integer> winNumber = generateWinNumber();
        int bonusNumber = generateBonusNumber(winNumber);

        List<Rank> rankList = gameService.checkWinNumbers(winNumber, lottoList, bonusNumber);
        UserView.winStatisticsMessage(rankList);

        String returnRate = gameService.calculateReturnRate(rankList, lottoCount);
        UserView.totalYieldMessage(returnRate);
    }
}
