package lottomachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import service.Inputter;

public class CalculatorLottoAmount {


    public CalculatorLottoAmount() {

    }

    public int getLottoAmount(int money) {
        return money / 1000;
    }


}
