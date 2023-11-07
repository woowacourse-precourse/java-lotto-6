package lotto.domain.strategy;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.util.LottoParser;

public class WinningLottoGenerateStrategy implements LottoGenerateStrategy {
    @Override
    public Lotto generate() {
        return new Lotto(LottoParser.parseWinningInputs(Console.readLine()));
    }
}
