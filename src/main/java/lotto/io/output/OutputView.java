package lotto.io.output;

public interface OutputView {

    void printErrorMessage(Exception e);

    void printGetLottoMoney();

    void printGetWinningNumbers();

    void printGetBonusNumber();

    void printLottosInfo(int count, String lottosInfo);

    void printResult();

    void printStatistics(String statistics);

    void printProfitRate(float profitRate);
}