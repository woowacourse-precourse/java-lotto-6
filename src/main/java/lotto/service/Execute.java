package lotto.service;

import lotto.console.Input;
import lotto.console.Output;
import lotto.domain.Asset;
import lotto.domain.Lotto;
import lotto.domain.State;
import java.util.List;

public class Execute {
    public static State state = new State();
    public static Asset asset;
    public static void start(){
        asset = Input.askMoney();

        Lotto winningNum = Input.askWinningNum();

        Integer bonusNum = Input.askBonusNum();

        List<Lotto> lottoTickets = LottoMachine.buyLotto(asset.getMoney());

        lottoTickets.forEach(tickets -> LottoMachine.judgeGrade(winningNum, bonusNum, tickets));

        Output.printResult(state.getGradeState());

        Output.printRate(asset);
    }
}
