package lotto.Controller;

import java.util.List;
import lotto.Model.BonusNumber;
import lotto.Model.CalculateProfits;
import lotto.Model.Lotto;
import lotto.Model.LottoMatch;
import lotto.Model.RandomLottos;
import lotto.Model.Result;
import lotto.Model.TicketsAmount;
import lotto.View.InputVIew;
import lotto.View.OuputView;

public class LottoGameController {
    private TicketsAmount ticketsAmount;
    private Lotto lotto;
    private BonusNumber bonusNumber;

    public void initializeGame() {
        // 로또 수, 랜덤 패, 당첨 패 셋팅
        int inputTicketAmount = InputVIew.inputTicketsAmount();
        ticketsAmount = new TicketsAmount(inputTicketAmount);
        OuputView.printNumOfTicket(ticketsAmount.getTickets());
        List<List<Integer>> randomLottos = RandomLottos.SetRandomLottos(ticketsAmount.getTickets()); // 랜덤패
        RandomLottos.printLottoNumbers(randomLottos);
        List<Integer> winningNumbers = InputVIew.inputWinningNumbers(); // 당첨패
        lotto = new Lotto(winningNumbers);
        int bonus = InputVIew.inputBonusNumber();
        bonusNumber = new BonusNumber(bonus);
        start(randomLottos);
    }

    public void start(List<List<Integer>> randomLottos) {
        List<Integer> countWinnings = LottoMatch.countMatchingNumbers(randomLottos, lotto.getNumbers(), bonusNumber.getBonus());
        String profits = CalculateProfits.calculate(countWinnings, ticketsAmount.getTicketsPrice());
        System.out.println(profits);
    }
}
