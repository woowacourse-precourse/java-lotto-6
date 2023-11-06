package lotto.controller;

import lotto.domain.Counter;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerate;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class GameController {

    public static void start(){
        int userMoney = getUserMoney();
        int lottoAmount = calculateLottoAmount(userMoney);
        printLottoCount(lottoAmount);
        List<Lotto> lottoList = generateLottoList(lottoAmount);
        printLottoList(lottoList);
        List<Integer> winNumbers = getWinNumbers();
        int bonusNumber = getBonusNumber();

    }

    private static int getUserMoney() {
        return InputView.inputMoney();
    }

    private static int calculateLottoAmount(int userMoney) {
        Counter counter = new Counter();
        return counter.generateLottoCount(userMoney);
    }

    private static void printLottoCount(int lottoAmount) {
        OutputView outputView = new OutputView();
        outputView.printLottoCount(lottoAmount);
    }

    private static List<Lotto> generateLottoList(int lottoAmount) {
        LottoGenerate lottoGenerate = new LottoGenerate();
        return lottoGenerate.generateLottoNumbers(lottoAmount);
    }
    private static void printLottoList(List<Lotto> lottoList) {
        OutputView outputView = new OutputView();
        outputView.printLottoList(lottoList);
    }

    private static List<Integer> getWinNumbers() {
        InputView inputView = new InputView();
        return inputView.inputWinNumbers();
    }

    private static int getBonusNumber() {
        InputView inputView = new InputView();
        return inputView.inputBonusNumber();
    }

}

