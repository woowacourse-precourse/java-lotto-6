package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    public String readInput() {
        return Console.readLine();
    }

    public void closeInput() {
        Console.close();
    }
}
