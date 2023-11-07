package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.enums.ViewMessage;

public class LottoView {

    public String inputNormalNumber(){
        System.out.println(ViewMessage.INPUT_LOTTO_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber(){
        System.out.println(ViewMessage.INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

}
