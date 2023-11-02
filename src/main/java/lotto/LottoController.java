package lotto;

import static lotto.OutputView.printAmount;
import static lotto.OutputView.printBonus;
import static lotto.OutputView.printBuy;
import static lotto.OutputView.printNumbers;

import camp.nextstep.edu.missionutils.Console;

public class LottoController {

    LottoService lottoService;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void start() {
        requestAmount();
        requestMyLotto();
        requestLotto();
        requestBonus();
    }

    private void requestAmount() {
        printAmount();
        lottoService.setAmount(Console.readLine());
    }

    private void requestLotto() {
        printNumbers();
        lottoService.setLotto(Console.readLine());
    }

    private void requestBonus() {
        printBonus();
        lottoService.setBonus(Console.readLine());
    }

    private void requestMyLotto() {
        lottoService.setMyLotto();
    }

}
