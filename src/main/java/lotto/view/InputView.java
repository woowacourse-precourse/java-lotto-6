package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.InputMessage;

public interface InputView {

    public String inputMoney();

    public String inputWinNumbers();

    public String inputBonusNumber();

    public void inputTest();

    public void close();

}
