package lotto;

import java.util.List;

public class Game {
    private int purchasingPrice;
    private List<Integer> winningNumber;
    private int bonusNumber;
    private List<List<Integer>> lottoNumbersCollection;


    void execute(){
        purchaseLotto();
        printLottoNumber();
        printStatistics();
    }

    void purchaseLotto(){
        InputView inputView = new InputView();
        purchasingPrice= inputView.inputLottoPrice();
    }

    void printLottoNumber(){
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Util util = new Util();
        int countOfPurchasedLotto = util.countPurchasedLotto(purchasingPrice);
        outputView.printPurchasedLottoQuantity(countOfPurchasedLotto);

        lottoNumbersCollection = util.makeLottoNumbersCollection(countOfPurchasedLotto);
        outputView.printLottoNumbers(lottoNumbersCollection);

        winningNumber = inputView.inputLottoNumber();
        bonusNumber = inputView.inputBonusNumber();
        Lotto lotto = new Lotto(winningNumber);
    }

    void printStatistics(){
        OutputView outputView = new OutputView();
        PrizeCalculaor prizeCalculaor = new PrizeCalculaor();
        List<Integer> winningNumbersExceptBonus = prizeCalculaor.combineWinningNumbersAndBonusNumber(winningNumber,bonusNumber);
        List<Integer> countsOfWonNumber = prizeCalculaor.makeWinningCountCollection(lottoNumbersCollection,winningNumber,winningNumbersExceptBonus,bonusNumber);
        int totalPrize = prizeCalculaor.calculateTotalPrize(countsOfWonNumber);
        float profitRate = prizeCalculaor.calculateProfitRate(totalPrize, purchasingPrice);
        outputView.printWinningStatistics(countsOfWonNumber,profitRate);
    }

}
