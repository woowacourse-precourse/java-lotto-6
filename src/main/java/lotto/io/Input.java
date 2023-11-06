package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;

import java.util.Arrays;
import java.util.List;

public class Input {

    public String getUserAmount() {
        return Console.readLine();
    }

    public List<String> getWinningNumbers() {
        return Arrays.asList(Console.readLine().split(Constants.COMMA));
    }

    public String getBonusNumber() {
        return Console.readLine();
    }
}
