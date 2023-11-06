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

    public List<Integer> inputWinningLottoNumbers() {
        System.out.println(Message.WINNING_NUMBER_REQUEST_MESSAGE);

        String inputWinningLottoNumbers = Console.readLine();
        return parseUtils.parseStringToIntegerList(inputWinningLottoNumbers);

    }

    public int inputWinningBonusNumber(WinningLotto winningLotto) {
        System.out.println(Message.BONUS_NUMBER_REQUEST_MESSAGE);

        String winningBonusNumber = Console.readLine();
        return parseUtils.parseStringToInt(winningBonusNumber);
    }

}
