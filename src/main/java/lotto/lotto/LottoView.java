package lotto.lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.ViewMessage;

public class LottoView {

    public String inputLottoNumber(){
        System.out.println(ViewMessage.INPUT_LOTTO_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber(){
        System.out.println(ViewMessage.INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
