package lotto.io.output;

public interface OutputView {

    void printErrorMessage(Exception e);
    void printGetLottoMoney();
    void printGetWinningNumbers();
    void printGetBonusNumber();
    void printResult();
    void printStatistics();
    void printProfitRate();
}


