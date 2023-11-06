package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessage;
import lotto.constants.Message;
import lotto.constants.Value;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.utils.ParseUtils;

import java.util.List;

public class InputService {

    ParseUtils parseUtils = new ParseUtils();


    public int inputPayMoney() {
        System.out.println(Message.PAY_MONEY_REQUEST_MESSAGE);
        String payMoney = Console.readLine();

        return parseUtils.parseStringToInt(payMoney);
    }

    private void amountValidate(int amount) {
        if (amount < Value.LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException();
        }

        if ((amount % Value.LOTTO_TICKET_PRICE) != 0) {
            throw new IllegalArgumentException();
        }
    }

    public WinningLotto inputWinningLotto() {
        WinningLotto winningLotto = inputWinningLottoNumbers();
        inputBonusNumber(winningLotto);

        return winningLotto;
    }

    private WinningLotto inputWinningLottoNumbers() {
        System.out.println(Message.WINNING_NUMBER_REQUEST_MESSAGE);

        while (true) {
            try {
                String inputWinningNumbers = Console.readLine();
                List<Integer> winningLottoNumbers = parseUtils.parseStringToIntegerList(inputWinningNumbers);

                return new WinningLotto(winningLottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.WINNING_NUMBER_FORMAT.getMessage());
            }
        }
    }

    private void inputBonusNumber(WinningLotto winningLotto) {
        System.out.println(Message.BONUS_NUMBER_REQUEST_MESSAGE);

        while (true) {
            try {
                String inputBonusNumber = Console.readLine();
                int bonusNumber = parseUtils.parseStringToInt(inputBonusNumber);
                winningLotto.setBonusNumber(bonusNumber);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.BONUS_NUMBER_FORMAT.getMessage());
            }
        }
    }

}
