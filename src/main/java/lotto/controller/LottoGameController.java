package lotto.controller;

import static lotto.constant.ConsoleMessage.BUY;
import static lotto.constant.ConsoleMessage.INPUT_BONUS_NUMBER;
import static lotto.constant.ConsoleMessage.INPUT_BUY_PRICE;
import static lotto.constant.ConsoleMessage.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.RegexValidator;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.repository.LottoStore;
import lotto.service.LottoGame;
import lotto.util.ListConverter;

public class LottoGameController {
    private static final LottoGameController instance = new LottoGameController();

    private LottoGameController() {
    }

    public static LottoGameController getInstance() {
        return instance;
    }

    public void run() {
        LottoStore lottoStore = buyLottos();
        WinningNumber winningNumber = getWinningNumber();

        LottoGame lottoGame = new LottoGame(lottoStore, winningNumber);

        lottoGame.printResult();
    }

    private WinningNumber getWinningNumber() {
        Lotto inputWinningNumber = inputWinningNumber();
        while (true) {
            try {
                int bonusNumber = inputBonusNumber();
                return new WinningNumber(inputWinningNumber, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private int inputBonusNumber() {
        while (true) {
            try {
                INPUT_BONUS_NUMBER.print();
                String inputBonusNumber = Console.readLine();
                RegexValidator.LOTTO_NUMBER.validate(inputBonusNumber);

                return Integer.parseInt(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto inputWinningNumber() {
        while (true) {
            try {
                INPUT_WINNING_NUMBERS.print();
                String inputNumber = Console.readLine();
                RegexValidator.COUNT.validate(inputNumber);
                return new Lotto(ListConverter.toIntegerList(inputNumber));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoStore buyLottos() {
        while (true) {
            try {
                INPUT_BUY_PRICE.print();
                String buyPrice = Console.readLine();
                LottoStore lottoStore = new LottoStore(buyPrice);

                int lottoCount = lottoStore.buy();
                BUY.print(lottoCount);
                lottoStore.printLottos();
                return lottoStore;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
