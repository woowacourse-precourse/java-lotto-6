package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.LottoStore;
import lotto.model.WinningLottoNumbers;
import lotto.service.LottoGameService;
import lotto.util.ListConverter;

import static lotto.constant.ConsoleMessage.*;

public class LottoGameController {

    public void run() {
        LottoStore lottoStore = buyLotto();
        WinningLottoNumbers winningNumber = getWinningNumber();
        LottoGameService lottoGame = new LottoGameService(lottoStore, winningNumber);
        lottoGame.printResult();
    }

    private LottoStore buyLotto() {
        while (true) {
            try {
                INPUT_BUY_PRICE.print();
                String buyPrice = Console.readLine();
                LottoStore lottoStore = new LottoStore(buyPrice);
                int lottoCount = lottoStore.automationMachineStart();
                BUY.print(lottoCount);
                lottoStore.printLottos();
                return lottoStore;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLottoNumbers getWinningNumber() {
        Lotto inputWinningNumber = inputWinningNumber();
        while (true) {
            try {
                int bonusNumber = inputBonusNumber();
                return new WinningLottoNumbers(inputWinningNumber, bonusNumber);
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
                return new Lotto(ListConverter.toIntegerList(inputNumber));
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

                return Integer.parseInt(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
