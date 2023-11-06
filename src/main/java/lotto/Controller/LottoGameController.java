package lotto.Controller;

import java.util.List;
import lotto.Model.BonusNumber;
import lotto.Model.CalculateProfits;
import lotto.Model.Lotto;
import lotto.Model.LottoMatch;
import lotto.Model.RandomLottos;
import lotto.Model.Result;
import lotto.Model.TicketsAmount;
import lotto.View.OuputView;

public class LottoGameController {
    private  TicketsAmount ticketsAmount ;
    private  Lotto lotto ;
    private  BonusNumber bonusNumber;

    public void initializeGame() {
        ticketsAmount = new TicketsAmount(InputController.inputTicketsAmount());
        OuputView.printNumOfTicket(ticketsAmount.getTickets());
        List<List<Integer>> randomLottos = RandomLottos.SetRandomLottos(ticketsAmount.getTickets()); // 랜덤패
        RandomLottos.printLottoNumbers(randomLottos);
        lotto = new Lotto(InputController.inputWinningNumbers());
        List<Integer> winningNumbers = lotto.getNumbers();// 당첨패
        bonusNumber = new BonusNumber(InputController.inputBonusNumber(),winningNumbers);
        start(randomLottos);
    }

    public void start(List<List<Integer>> randomLottos) {
        List<Integer> countWinnings = LottoMatch.countMatchingNumbers(randomLottos, lotto.getNumbers(), bonusNumber.getBonus());
        Result.printResults(countWinnings);
        CalculateProfits.calculate(countWinnings, ticketsAmount.getTicketsPrice());
    }
}
