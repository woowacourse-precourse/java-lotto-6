package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoSystem;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.controller.InputController.*;
import static lotto.controller.InputValidatorController.*;
import static lotto.domain.LottoSystem.calculateRateOfReturn;
import static lotto.view.OutputView.*;

public class LottoSystemController {

    public static void startLottoSystem() {
        LottoSystem lottoSystem = buyLotto();
        printBuyLotto(lottoSystem);

        WinningLotto winningLotto = enterLotto();
        printWinningStatus(calculateWinningStatus(lottoSystem, winningLotto));
    }

    private static List<WinningResult> calculateWinningStatus(LottoSystem lottoSystem, WinningLotto winningLotto) {
        return lottoSystem.compareWinningLotto(winningLotto);
    }

    private static void printWinningStatus(List<WinningResult> result) {
        printLottoStatistics(calculateRateOfReturn(result));
    }

    private static WinningLotto enterLotto() {
        return new WinningLotto(enterLottoNumber(), enterLottoBonusNumber());
    }

    private static int enterLottoBonusNumber() {
        String lottoBonusNumber = inputLottoBonusNumber();
        inputLottoBonusNumberValidate(lottoBonusNumber);

        return Integer.parseInt(lottoBonusNumber);
    }

    private static Lotto enterLottoNumber() {
        String lottoNumbers = inputLottoNumber();
        inputLottoNumberValidate(lottoNumbers);

        return parseStringToList(lottoNumbers);
    }

    private static Lotto parseStringToList(String lottoNumbers) {
        List<Integer> lottos = new ArrayList<>();

        String[] lottoNumber = lottoNumbers.split(",");
        for (int i = 0; i < lottoNumber.length; i++) {
            lottos.add(Integer.parseInt(lottoNumber[i]));
        }

        return new Lotto(lottos);
    }

    private static LottoSystem buyLotto() {
        String money = inputMoney();
        inputMoneyValidate(money);

        return new LottoSystem(Long.parseLong(money));
    }

    private static void printBuyLotto(LottoSystem lottoSystem) {
        printLottoCnt(lottoSystem.getPurchaseLottoCount());

        for (Lotto lotto : lottoSystem.getPurchaseLottos()) {
            printLottoNumbers(lotto);
        }
    }
}
