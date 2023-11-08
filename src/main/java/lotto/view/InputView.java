package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.parser.InputParser;

public class InputView {
    private final InputParser inputParser;

    public InputView() {
        inputParser = new InputParser();
    }

    public long getUserMoney() {
        return inputParser.parseUserMoney(readLine());
    }

    public List<Integer> getWinningLottoNumbers() {
        return inputParser.parseWinningLottoNumbers(readLine());
    }

    public int getBonusNumber() {
        return inputParser.parseBonusNumber(readLine());
    }

    private String readLine() {
        return Console.readLine();
    }
}