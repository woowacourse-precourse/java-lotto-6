package lotto.controller;

import static lotto.view.messagePrinter.printLottoResults;
import java.util.List;
import lotto.model.WinningLotto;
import lotto.util.ErrorCode;
import lotto.view.userInput;
import lotto.view.messagePrinter;
import lotto.model.Cash;
import lotto.service.lottoService;

public class lottoController {
    private final lottoService service;

    final int LOTTO_LOWER_BOUND = 1;
    final int LOTTO_UPPER_BOUND = 45;

    public lottoController(){
        this.service = new lottoService();
    }

    public void run(){
        buyLotto();
        generateAnswerLotto();
        showResult();
    }

    private void buyLotto(){
        try {
            messagePrinter.printPurchaseAmountInstruction();
            Cash cash = new Cash(userInput.getInteger());
            messagePrinter.printPurchaseAmount(cash.getCount());
            lottoService.publishLottos(cash.getCount());
            messagePrinter.printPurchasedLottos();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyLotto();
        }
    }

    private void generateAnswerLotto(){
        try {
            messagePrinter.printWinningNumInstruction();
            List<Integer> winningNumber = userInput.getIntegerList();
            validateWinningNumberRange(winningNumber);
            messagePrinter.printBonusNumInstruction();
            int bonusNum = userInput.getInteger();
            WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNum);
            lottoService.compareLottos(winningLotto);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            generateAnswerLotto();
        }
    }

    private void showResult(){
        printLottoResults(lottoService.getLottoHashMap());
        messagePrinter.printProfitRate();
    }

    private void validateWinningNumberRange(List<Integer> numbers) {
        for(int number : numbers){
            if(!(number>=LOTTO_LOWER_BOUND && number<=LOTTO_UPPER_BOUND)){
                throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
            }
        }
    }
}
