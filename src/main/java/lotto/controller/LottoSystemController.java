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
import static lotto.domain.LottoSystem.calculateRateOfReturn;
import static lotto.view.OutputView.*;
import static lotto.view.OutputView.printEmptyLine;

public class LottoSystemController {

    public static void startLottoSystem() {
        LottoSystem lottoSystem = buyLotto();
        printBuyLotto(lottoSystem.getPurchaseLottoCount(), lottoSystem.getPurchaseLottos());

        WinningLotto winningLotto = enterLotto();

        Map<WinningResult, Integer> result = lottoSystem.compareWinningLotto(winningLotto);
        printWinningResult(result, calculateRateOfReturn(result));
    }

    private static void printWinningResult(Map<WinningResult, Integer> result, float calculateRateOfReturn) {
        printEmptyLine();
        printLottoStatistics(result, calculateRateOfReturn);
    }

    private static WinningLotto enterLotto() {
        return new WinningLotto(enterLottoNumber(), enterLottoBonusNumber());
    }

    private static Lotto enterLottoNumber() {
        String lottoNumbers = "";

        try {
            printEmptyLine();

            lottoNumbers = inputLottoNumber();
            inputLottoNumberValidate(lottoNumbers);
            return parseToLotto(lottoNumbers);
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return enterLottoNumber();
        }
    }

    private static int enterLottoBonusNumber() {
        String lottoBonusNumber = "";

        try {
            printEmptyLine();

            lottoBonusNumber = inputLottoBonusNumber();
            inputLottoBonusNumberValidate(lottoBonusNumber);
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return enterLottoBonusNumber();
        }
        return Integer.parseInt(lottoBonusNumber);
    }

    private static Lotto parseToLotto(String lottoNumbers) {
        return new Lotto(Arrays.stream(lottoNumbers.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
    }

    private static LottoSystem buyLotto() {
        String money = "";

        try {
            printEmptyLine();
            money = inputMoney();
            inputMoneyValidate(money);
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return buyLotto();
        }
        return new LottoSystem(Long.parseLong(money));
    }

    private static void printBuyLotto(int purchaseLottoCnt, List<Lotto> purchaseLottos) {
        printEmptyLine();
        printLottoCnt(purchaseLottoCnt);

        for (Lotto lotto : purchaseLottos) {
            printLottoNumbers(lotto);
        }
    }
}
