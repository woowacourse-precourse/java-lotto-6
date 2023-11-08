package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoSystem;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.utils.system.LottoException;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.controller.InputController.*;
import static lotto.controller.InputValidatorController.*;
import static lotto.controller.LottoController.*;
import static lotto.controller.WinningLottoController.enterLotto;
import static lotto.controller.WinningResultController.printWinningResult;
import static lotto.domain.LottoSystem.calculateRateOfReturn;
import static lotto.view.OutputView.*;
import static lotto.view.OutputView.printEmptyLine;

public class LottoSystemController {

    public static void startLottoSystem() {
        LottoSystem lottoSystem = generateLottoSystem();
        printGenerateLotto(lottoSystem.getPurchaseLottoCount(), lottoSystem.getPurchaseLottos());

        WinningLotto winningLotto = enterLotto();

        Map<WinningResult, Integer> result = lottoSystem.compareWinningLotto(winningLotto);
        printWinningResult(result, calculateRateOfReturn(result));
    }

    private static LottoSystem generateLottoSystem() {
        String money = "";

        try {
            printEmptyLine();
            money = inputMoney();
            inputMoneyValidate(money);
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return generateLottoSystem();
        }
        return new LottoSystem(Long.parseLong(money));
    }
}
