package lotto.view.input;

public interface InputView {
    default String inputMoney() {
        return "";
    }

    default String inputWinningNumbers() {
        return "";
    }

    default String inputBonusNumber() {
        return "";
    }
}
