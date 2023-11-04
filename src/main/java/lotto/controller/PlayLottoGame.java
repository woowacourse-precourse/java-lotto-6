package lotto.controller;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.repository.LottoRepository;
import lotto.service.GameService;
import lotto.service.LottoService;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class PlayLottoGame {

    private final GameService gameService = new GameService();
    private final LottoService lottoService = new LottoService();
    private final InputView inputView = new InputView();
    private final LottoRepository lottoRepository = new LottoRepository();

    private final OutputView outputView = new OutputView();
    private final Parser parser = new Parser();
    private User user;

    private Game game;

    private static final int LEAST_AMOUNT = 1000;

    public void runLottoGame(){
        beforeStartGame();
        createNewGame();
        showGameResult();
    }


    private void beforeStartGame(){
        user = new User(inputUserAmount());
        lottoService.buyLottoAtOnce(user);
        showPurchaseResult();
    }

    private void createNewGame(){
        game = new Game(inputWinningNumbers(), inputBonusNumber());
    }

    private void showGameResult(){
        gameService.checkUserLotteries(user, game);
        outputView.winningStatistics();
        outputView.showRankResult(gameService.getLottoResult());
        outputView.showRateOfReturn(gameService.getRateOfReturn());
    }


    private int inputUserAmount(){
        String userInput = inputView.inputPurchaseAmount();
        int userAMount = parser.parseInputStringNumber(userInput);
        return userAMount;
    }

    private void showPurchaseResult(){
        outputView.purchaseMessage(user.getPurchaseAmount() / LEAST_AMOUNT);
        for(Lotto lotto : lottoRepository.getLotteries()){
            outputView.lottoNumbers(lotto.getNumbers());
        }
    }
    private List<Integer> inputWinningNumbers(){
        String userInput = inputView.inputWinningNumbers();
        List<Integer> winningNumbers = parser.parseInputWinningNumbers(userInput);
        return winningNumbers;
    }

    private int inputBonusNumber(){
        String userInput = inputView.inputBonusNumber();
        int bonusNumber = parser.parseInputStringNumber(userInput);
        return bonusNumber;
    }




}
