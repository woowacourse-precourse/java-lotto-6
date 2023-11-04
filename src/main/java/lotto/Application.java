package lotto;

public class Application {
    public static void main(String[] args) {
        StartLotto lottoStart = new StartLotto();
        lottoStart.printMessageForInputPurchasePrice();
        lottoStart.inputPurchasePrice();
        lottoStart.printPurchaseLottoAmount();
        lottoStart.generateLottoList();
        lottoStart.printLottoList();
        lottoStart.printMessageForInputWinningNumbers();
        lottoStart.inputWinningNumbers();
        lottoStart.printMessageForInputBonusNumber();
        lottoStart.inputBonusNumber();
        lottoStart.fillPriceHistoryMap();
        lottoStart.printPriceHistory();
        double totalEarningRate = lottoStart.calcEarningRate();
        lottoStart.printTotalEarningRate(totalEarningRate);
    }
}
