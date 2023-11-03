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

public class LottoGameController {
    //TODO : 로또 수, 랜덤 패, 당첨 패 셋팅
    TicketsAmount ticketsAmount = new TicketsAmount(InputVIew.inputTicketsAmount());
    int tickets = ticketsAmount.getTickets();
    List<List<Integer>> randomLottos = RandomLottos.SetRandomLottos(tickets); //랜덤패
    Lotto lotto = new Lotto(InputVIew.inputWinningNumbers());
    List<Integer>winningNumbers = lotto.getNumbers(); //당첨패

    BonusNumber bonusNumber = new BonusNumber(InputVIew.inputBonusNumber());
        //System.out.println(LottoMatch.getHasBonus());
    int bonus = bonusNumber.getBonus();
    public void start(){
        //TODO : 패 비교해서 일치개수 리스트 반환
        List<Integer> countWinnings = LottoMatch.countMatchingNumbers(randomLottos,winningNumbers,bonus);
        //TODO : 당첨 결과
        Result.printResults(countWinnings);
        //TODO : 수익률 계산
        double profits = CalculateProfits.calculate(countWinnings,ticketsAmount.getTicketsPrice());
        System.out.println(profits);
    }









}
