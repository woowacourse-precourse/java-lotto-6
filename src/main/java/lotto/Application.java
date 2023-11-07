package lotto;

public class Application {
    public static void main(String[] args) {
        StartLotto lottoStart = new StartLotto();
        lottoStart.printMessageForInputPurchasePrice();
        lottoStart.inputPurchasePriceForClient();
        lottoStart.printPurchaseLottoAmount();
        lottoStart.generateLottoList();
        lottoStart.printLottoList();
        lottoStart.printMessageForInputWinningNumbers();
        lottoStart.inputWinningNumbersForClient();
        lottoStart.printMessageForInputBonusNumber();
        lottoStart.inputBonusNumberForClient();
        lottoStart.fillPriceHistoryMap();
        lottoStart.printPriceHistory();
        double totalEarningRate = lottoStart.calcEarningRate();
        lottoStart.printTotalEarningRate(totalEarningRate);
    }
}
