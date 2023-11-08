package lotto.input;

import java.util.List;

public final class InputManager {

    public static List<Integer> getLottoNumbers() {
        InputRetryHelper<List<Integer>> inputRetryHelper = new InputRetryHelper<>();
        return inputRetryHelper.retry(LottoNumberInputManager::fromConsole);
    }

    public static int getLottoMoney() {
        InputRetryHelper<Integer> inputRetryHelper = new InputRetryHelper<>();
        return inputRetryHelper.retry(LottoMoneyInputManager::fromConsole);
    }

    public static int getBonusNumber(List<Integer> answerNumber) {
        InputRetryHelper<Integer> inputRetryHelper = new InputRetryHelper<>();
        return inputRetryHelper.retry(() -> LottoBonusNumberInputManager.fromConsole(answerNumber));
    }
}
