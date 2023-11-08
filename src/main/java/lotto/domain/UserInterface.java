package lotto.domain;

public interface UserInterface {

    int getValidPurchasePrice();

    WinningLotto getValidWinningLotto();

    Integer getBonusNumber();

    void printWinningResult(LottoWinningResult lottoWinningResult);

    void printErrorMessage(IllegalArgumentException exception);

    void printPurchasedResult(long lottoCount, LottoResult lottoResult);
}
