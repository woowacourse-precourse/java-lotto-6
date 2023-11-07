package lotto.view;

public interface InputView {
    String inputPurchasingMoney();

    String inputWinningLottoNumbers();

    String inputBonusNumber();

    void printMessage(String message);

    String inputMessage();

    void close();
}
