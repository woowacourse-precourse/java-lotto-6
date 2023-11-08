package lotto;

import lotto.console.Input;
import lotto.console.Output;
import lotto.domain.LottoGame;
import lotto.domain.LottoMachine;
import lotto.domain.Player;

public class Application {
    public static void main(String[] args) {
        Player player = new Player(Input.askMoney());

        LottoGame lottoGame = new LottoGame(Input.askWinningNum(), Input.askBonusNum());

        LottoMachine.judgeGrade(lottoGame, player);

        Output.printTickets(player.getLottoTickets(), player.getTicketNum());

        Output.printResult(player);
    }
}
