package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoGameResult;
import lotto.domain.UserMoney;
import lotto.domain.WinningLottoNumbers;
import lotto.view.parser.InputParser;

public class InputView {

    private final InputParser inputParser;

    public InputView(){
        inputParser = new InputParser();
    }

    public UserMoney getUserMoney(){
        return inputParser.parseUserMoney(readLine());
    }

    public void /* LottoGameResult */ getLottoGameResult(){
        WinningLottoNumbers winningLottoNumbers = getWinningLottoNumbers();
    }

    public WinningLottoNumbers getWinningLottoNumbers(){
        return inputParser.parseWinningLottoNumbers(readLine());
    }

    private String readLine(){
        return Console.readLine();
    }
}