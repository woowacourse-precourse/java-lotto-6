package lotto.controller;

import static lotto.controller.constants.ErrorMessage.INVALID_INPUT;

import java.util.List;
import lotto.controller.utils.InputParser;
import lotto.domain.LottoService;
import lotto.domain.Lottos;
import lotto.domain.WinningResult;
import lotto.view.GameView;

public class GameController {

    private final LottoService model;
    private final GameView view;
    private final InputParser inputParser;

    public GameController(LottoService model, GameView view){
        this.model = model;
        this.view = view;
        this.inputParser = new InputParser();
    }

    public void run(){
        Integer purchaseAmount = getPurchaseAmount(view.inputLottoPurchaseAmount());
        validatePurchaseAmount(purchaseAmount);

        model.issueLottos(model.findPurchaseCount());
        printLottos(model.findPurchaseCount(), model.findAllLottos());

        List<Integer> numbers = getLottoNumbers(view.inputLottoNumbers());
        Integer bonusNumber = getLottoBonusNumber(view.inputLottoBonusNumber());
        validateWinningLotto(numbers,bonusNumber);

        model.createWinningResult(model.findAllLottos(), model.findWinningLotto());
        printWinningStatistics(model.findWinningResult(), model.findPurchaseCount()*1000);
    }

    private Integer getPurchaseAmount(String lottPurchaseAmount) {
        try {
            return inputParser.parseToInteger(lottPurchaseAmount);
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(INVALID_INPUT.getMessage());
            return getPurchaseAmount(view.inputLottoPurchaseAmount());
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        try {
            model.savePurchaseCount(purchaseAmount);
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            validatePurchaseAmount(getPurchaseAmount(view.inputLottoPurchaseAmount()));
        }
    }

    private List<Integer> getLottoNumbers(String lottoNumbers) {
        try {
            return inputParser.parseLottoNumbers(lottoNumbers);
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            return getLottoNumbers(view.inputLottoNumbers());
        }
    }

    private Integer getLottoBonusNumber(String lottoBonusNumber) {
        try {
            return inputParser.parseToInteger(lottoBonusNumber);
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            return getLottoBonusNumber(view.inputLottoBonusNumber());
        }
    }

    private void validateWinningLotto(List<Integer> numbers,int bonusNumber){
        try {
            model.saveWinningLotto(numbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            validateWinningLotto(getLottoNumbers(view.inputLottoNumbers()), getLottoBonusNumber(view.inputLottoBonusNumber()));
        }
    }

    private void printLottos(int lottoPurchaseCount, Lottos lottos) {
        view.printLottoCount(lottoPurchaseCount);
        lottos.getLottos()
                .forEach(lotto -> view.printLottoNumbers(lotto.getNumbers()));
    }

    private void printWinningStatistics(WinningResult winningResult, int purchaseAmount) {
        view.printTotalRankingCount();
        view.printFifthRankingCount(winningResult.getFifthPlaceCount());
        view.printFourthRankingCount(winningResult.getFourthPlaceCount());
        view.printThirdRankingCount(winningResult.getThirdPlaceCount());
        view.printSecondRankingCount(winningResult.getSecondPlaceCount());
        view.printFirstRankingCount(winningResult.getFirstPlaceCount());
        view.printReturnRate(model.getReturnRate(winningResult, purchaseAmount));
    }

}
