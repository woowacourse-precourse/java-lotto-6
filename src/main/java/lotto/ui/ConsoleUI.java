package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.ui.ConsoleMessage.PRINT_LOTTOS;
import static lotto.ui.ConsoleMessage.REQUEST_PURCHASE_AMOUNT;

import java.util.List;
import lotto.error.exception.InvalidInputException;
import lotto.input.InputProcessor;
import lotto.lotto.Lotto;
import lotto.lotto.LottoVendor;

public class ConsoleUI {
    private InputProcessor inputProcessor = new InputProcessor();
    private LottoVendor lottoVendor = new LottoVendor();

    public void start() {
        Integer purchaseAmount = inputPurchaseAmount();

        List<Lotto> lottos = lottoVendor.generateLottos(purchaseAmount);
        printLottosInfo(lottos);


    }

    private Integer inputPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT.getMessage());
        while (true) {
            String input = readLine();
            try {
                Integer purchaseAmount = inputProcessor.processPurchaseAmount(input);
                System.out.println();
                return purchaseAmount;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printLottosInfo(List<Lotto> lottos) {
        System.out.println(lottos.size() + PRINT_LOTTOS.getMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
        System.out.println();
    }
}
