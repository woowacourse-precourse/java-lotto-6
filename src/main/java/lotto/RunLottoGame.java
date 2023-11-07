package lotto;

import java.util.List;

public class RunLottoGame {
    private int lottoQuantity;

    public void start() {
        prepareLotto();
        publishLotto();
    }

    public void prepareLotto() {
        InputManager inputManager = new InputManager();
        int moneyInput = inputManager.inputMoney();

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
}
