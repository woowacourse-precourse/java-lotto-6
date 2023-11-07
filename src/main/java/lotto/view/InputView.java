package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.message.ExceptionMessage;
import lotto.common.message.InputMessage;
import lotto.common.utils.NumberUtil;
import lotto.domain.WinnerNumbers;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public String inputPrice(){
        System.out.println(InputMessage.INPUT_PRICE);
        return Console.readLine();
    }

    // 당첨 번호를 6개 입력 받는 기능
    public List<String> inputWinnerNumbers() {
        System.out.println(InputMessage.INPUT_WINNER_NuMBERS);
        return winnerNumbersCountCheck(Arrays.asList(Console.readLine().split(",")));
    }

    public List<String> winnerNumbersCountCheck(List<String> winnerNumbers){
        if (winnerNumbers.size() != NumberUtil.LOTTO_NUMBER_COUNT) {
            System.out.println(ExceptionMessage.NUMERIC_LENGTH_CHECK);
            inputWinnerNumbers();
        }
        return winnerNumbers;
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return WinnerNumbers.bonusNumbersValidateCheck(Console.readLine());

    }


}
