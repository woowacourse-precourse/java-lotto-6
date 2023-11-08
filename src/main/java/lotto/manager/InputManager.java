package lotto.manager;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessage;
import lotto.constants.Value;
import lotto.domain.WinningLotto;
import lotto.utils.OutputUtils;
import lotto.utils.ParseUtils;

import java.util.List;

public class InputManager {

    ParseUtils parseUtils = new ParseUtils();
    OutputUtils outputUtils = new OutputUtils();

    public int inputPayMoney() {
        outputUtils.displayPayMoneyRequestMessage();

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
            throw new IllegalArgumentException(ErrorMessage.PAY_MONEY_RANGE.getMessage());
        }

        if ((payMoney % Value.LOTTO_TICKET_PRICE) != 0) {
            throw new IllegalArgumentException(ErrorMessage.PAY_MONEY_UNIT.getMessage());
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
