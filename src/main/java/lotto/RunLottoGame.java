package lotto;

import java.util.List;

public class RunLottoGame {
    public void start() {
        InputManager inputManager = new InputManager();
        int moneyInput = inputManager.inputMoney();

        LottoQuantityManager lottoquantitymanager = new LottoQuantityManager();
        int lottoQuantity = lottoquantitymanager.calculateLottoQuantity(moneyInput);

        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<List<Integer>> allRandomLottoNumbers = lottoNumberGenerator.generateLottoNumbers(lottoQuantity);

        OutputManager outputManager = new OutputManager();
        outputManager.printLottoQuantity(lottoQuantity);
        outputManager.printAllLottoNumbers(allRandomLottoNumbers);
    }
}
