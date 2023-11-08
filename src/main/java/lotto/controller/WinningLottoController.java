package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.utils.system.LottoException;

import java.util.Arrays;
import java.util.stream.Collectors;

import static lotto.controller.InputController.inputLottoBonusNumber;
import static lotto.controller.InputController.inputLottoNumber;
import static lotto.controller.InputValidatorController.inputLottoBonusNumberValidate;
import static lotto.controller.InputValidatorController.inputLottoNumberValidate;
import static lotto.view.OutputView.printEmptyLine;

public class WinningLottoController {

    public static WinningLotto enterLotto() {
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
}
