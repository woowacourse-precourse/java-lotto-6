package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {

    public String getUserAmount() {
        return Console.readLine();
    }

    public List<String> getWinningNumbers() {
        return Arrays.asList(Console.readLine().split(IoConstants.COMMA));
    }

    public String getBonusNumber() {
        return Console.readLine();
    }
}
