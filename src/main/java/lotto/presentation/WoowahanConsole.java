package lotto.presentation;

import camp.nextstep.edu.missionutils.Console;

public class WoowahanConsole implements LottoConsole{
    @Override
    public String readLine() {
        return Console.readLine();
    }
}
