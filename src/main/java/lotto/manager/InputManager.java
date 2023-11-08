package lotto.manager;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.Value;
import lotto.domain.WinningLotto;
import lotto.utils.OutputUtils;
import lotto.utils.ParseUtils;

import java.util.List;

import static lotto.constants.ErrorMessage.*;

public class InputManager {

    private final ParseUtils parseUtils = new ParseUtils();
    private final OutputUtils outputUtils = new OutputUtils();

    public int inputPayMoney() {
        while (true) {
            try {
                String inputPayMoney = Console.readLine();
                int payMoney = parseUtils.parseStringToInt(inputPayMoney);
                validatePayMoney(payMoney);

                return payMoney;
            } catch (IllegalArgumentException e) {
                outputUtils.displayErrorMessage(e.getMessage());
            }
        }
    }

    private void validatePayMoney(int payMoney) {
        if (payMoney < Value.LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException(PAY_MONEY_RANGE_ERROR.getMessage());
        }

        if ((payMoney % Value.LOTTO_TICKET_PRICE) != 0) {
            throw new IllegalArgumentException(PAY_MONEY_UNIT_ERROR.getMessage());
        }
    }

    public WinningLotto inputWinningLotto() {
        WinningLotto winningLotto = inputWinningLottoNumbers();
        inputWinningBonusNumber(winningLotto);
        return winningLotto;
    }

    private WinningLotto inputWinningLottoNumbers() {
        outputUtils.displayWinningLottoRequestMessage();

        while (true) {
            try {
                String inputWinningLottoNumbers = Console.readLine();
                List<Integer> winningLottoNumbers = parseUtils.parseStringToIntegerList(inputWinningLottoNumbers);

                return new WinningLotto(winningLottoNumbers);
            } catch (IllegalArgumentException e) {
                outputUtils.displayErrorMessage(e.getMessage());
            }
        }
    }

    private void inputWinningBonusNumber(WinningLotto winningLotto) {
        outputUtils.displayBonusNumberRequestMessage();

        while (true) {
            try {
                String inputWinningBonusNumber = Console.readLine();
                int winningLottoNumbers = parseUtils.parseStringToInt(inputWinningBonusNumber);

                winningLotto.setBonusNumber(winningLottoNumbers);
                break;
            } catch (IllegalArgumentException e) {
                outputUtils.displayErrorMessage(e.getMessage());
            }
        }
    }

}
