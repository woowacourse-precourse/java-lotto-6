package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.LottoParser;

public class WinningLottoGenerateStrategy implements LottoGenerateStrategy {
    @Override
    public Lotto generate(){
        return new Lotto(LottoParser.parseWinningInputs(Console.readLine()));

    }
}
