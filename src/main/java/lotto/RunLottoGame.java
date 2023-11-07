package lotto;

import java.util.List;

public class RunLottoGame {
    private int lottoQuantity;

    public void start() {
        prepareLotto();
        publishLotto();
        winningLotto();
    }

    public void prepareLotto() {
        InputManager inputMoneyManager = new InputManager();
        int moneyInput = inputMoneyManager.inputMoney();

        LottoQuantityManager lottoquantitymanager = new LottoQuantityManager();
        lottoQuantity = lottoquantitymanager.calculateLottoQuantity(moneyInput);
    }

    public void publishLotto() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<List<Integer>> allRandomLottoNumbers = lottoNumberGenerator.generateLottoNumbers(lottoQuantity);

        OutputManager outputManager = new OutputManager();
        outputManager.printLottoQuantity(lottoQuantity);
        outputManager.printAllLottoNumbers(allRandomLottoNumbers);
    }

    public void winningLotto() {
        InputManager inputWinningManager = new InputManager();
        List<Integer> winningLottoNumbers = inputWinningManager.inputWinningNumbers();
    }
}
