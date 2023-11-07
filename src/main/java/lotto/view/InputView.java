package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.parser.InputParser;

public class InputView {

    private final InputParser inputParser;

    public InputView() {
        inputParser = new InputParser();
    }

    public String getUserMoney() {
        return inputParser.parseUserMoney(readLine());
    }

    public List<String> getWinningLottoNumbers() {
        return inputParser.parseWinningLottoNumbers(readLine());
    }

    public String getBonusNumber() {
        return inputParser.parseBonusNumber(readLine());
    }

    private String readLine() {
        return Console.readLine();
    }
}