package lotto;

import static lotto.OutputView.printAmount;
import static lotto.OutputView.printBonus;
import static lotto.OutputView.printBuy;
import static lotto.OutputView.printDash;
import static lotto.OutputView.printNumbers;
import static lotto.OutputView.printResult;
import static lotto.OutputView.printStats;

import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;
import java.util.List;

public class LottoController {

    private LottoService lottoService;
    private List<Integer> matchingLotto;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void start() {
        requestAmount();
        requestMyLotto();
        requestLotto();
        requestBonus();
        matchLotto();
        result();
        rateOfReturn();
    }

    private void requestAmount() {
        printAmount();
        try {
            lottoService.setAmount(Console.readLine());
        } catch (IllegalArgumentException e) {
            requestAmount();
        }
    }

    private void requestLotto() {
        printNumbers();
        try {
            lottoService.setLotto(Console.readLine());
        } catch (IllegalArgumentException e) {
            requestLotto();
        }
    }

    private void requestBonus() {
        printBonus();
        try {
            lottoService.setBonus(Console.readLine());
        } catch (IllegalArgumentException e) {
            requestBonus();
        }
    }

    private void requestMyLotto() {
        printBuy(lottoService.numberOfPurchase());
        lottoService.setMyLotto();
    }

    private void matchLotto() {
        matchingLotto = lottoService.resultLotto();
    }

    private void result() {
        printStats();
        printDash();
        int match = 3;
        for (OutputLine outputLine : OutputLine.values()) {
            if (match == 6) {
                System.out.printf(outputLine.getCorrect(), Collections.frequency(matchingLotto, 7));
                continue;
            }
            System.out.printf(outputLine.getCorrect(), Collections.frequency(matchingLotto, match++));
        }
    }

    private void rateOfReturn() {
        printResult(lottoService.rateReturn());
    }

}
