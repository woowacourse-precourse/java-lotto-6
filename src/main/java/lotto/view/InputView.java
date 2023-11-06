package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String inputAmount() {
        return readLine().trim();
    }

    public String inputWinningNumbers() {
        return readLine().trim();
    }

    public String inputBonusNumber() {
        return readLine().trim();
    }
}