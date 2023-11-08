package lotto;

import java.util.List;

public class RunLottoGame {
    private int lottoQuantity;
    private List<Integer> winningLottoNumbers;
    private String winningNumbers;
    private List<Integer> randomLottoNumbers;

    private int bonusNumber;

    public void start() {
        prepareLotto();
        publishLotto();
        winningLotto();
        processLotto();
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
        winningLottoNumbers = inputWinningManager.inputWinningNumbers();
        bonusNumber = inputWinningManager.inputBonusNumber(winningLottoNumbers);
    }

    public void processLotto() {
        LottoMatch lottoMatch = new LottoMatch();
        lottoMatch.checkLotto(randomLottoNumbers, winningLottoNumbers, bonusNumber);
    }
}
