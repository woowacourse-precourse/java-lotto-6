package lotto.domain.User;

import lotto.domain.Constants;
import lotto.domain.Lotto.Lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Result.Result;
import lotto.domain.WinningNumber.WinningNumber;
import lotto.util.InputUtil;
import lotto.validator.InputValidator;

public class User {
    private int lottoCount;
    private List<Lotto> lotties = new ArrayList<>();

    InputUtil inputUtil = new InputUtil();
    InputValidator validator = new InputValidator();
    WinningNumber winningNumber = new WinningNumber();
    Result result = new Result();
    Constants constants = new Constants();

    public User() {
        inputLottoAmount();
        createLotties();
        printLotties();
        winningNumber.setWinningNumbers();
        winningNumber.setBonusNumber();
        result.printResult(lotties, winningNumber);
    }

    private void inputLottoAmount() {
        String lottoAmountInput;
        while (true) {
            lottoAmountInput = inputUtil.inputLottoAmount();
            try {
                validator.checkAmount(lottoAmountInput);
                break;
            } catch (IllegalArgumentException e) {

            }
        }
        lottoCount = Integer.parseInt(lottoAmountInput) / 1000;
    }

    public void createLotties() {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = createLottoNumber();
            Lotto lotto = new Lotto(lottoNumber);
            lotties.add(lotto);
        }
    }

    private void printLotties() {
        System.out.printf(Constants.LOTTO_NUMBER_OUTPUT_MESSAGE, lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            System.out.println(lotties.get(i).getNumbers());
        }
    }

    private List<Integer> createLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(constants.LOTTO_NUMBER_MIN, constants.LOTTO_NUMBER_MAX,constants.LOTTO_NUMBER);
        return lottoNumber;
    }

}
