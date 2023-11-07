package lotto;

public class RunLottoGame {
    public void start() {
        InputManager inputManager = new InputManager();
        int moneyInput = inputManager.inputMoney();

        LottoQuantityManager lottoquantitymanager = new LottoQuantityManager();
        int lottoQuantity = lottoquantitymanager.calculateLottoQuantity(moneyInput);

        LottoNumberGenerator lottonumbergenerator = new LottoNumberGenerator();
        lottonumbergenerator.generateLottoNumbers(lottoQuantity);
    }
}
