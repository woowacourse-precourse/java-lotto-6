package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;

import java.util.List;

public class InputUtils {

    ParseUtils parseUtils = new ParseUtils();

    public int inputPayMoney() {
        String payMoney = Console.readLine();
        return parseUtils.parseStringToInt(payMoney);
    }

    public List<Integer> inputWinningLottoNumbers() {
        String inputWinningLottoNumbers = Console.readLine();
        return parseUtils.parseStringToIntegerList(inputWinningLottoNumbers);
    }

    public int inputWinningBonusNumber() {
        String winningBonusNumber = Console.readLine();
        return parseUtils.parseStringToInt(winningBonusNumber);
    }
}
