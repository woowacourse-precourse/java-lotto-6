package lotto.Controller;

import java.util.List;
import lotto.Model.BonusNumber;
import lotto.Model.Lotto;
import lotto.Model.LottoMatch;
import lotto.Model.RandomLottos;
import lotto.Model.TicketsAmount;
import lotto.View.InputVIew;

public class LottoGameController {
    //TODO : 랜덤 패, 당첨 패 셋팅
    //TODO : 비교해서 일치개수 리스트 반환
    //TODO : 리스트 요소 분류 -> 3미만 n개, 3 n개,4 n개 ...
    //TODO : enum value + 개수 반환
    //TODO : 수익률 계산
    TicketsAmount ticketsAmount = new TicketsAmount(InputVIew.inputTicketsAmount());
    int tickets = ticketsAmount.getTickets();
    List<List<Integer>> randomLottos = RandomLottos.SetRandomLottos(tickets);
    Lotto lotto = new Lotto(InputVIew.inputWinningNumbers());
    List<Integer>winningNumbers = lotto.getNumbers();


    BonusNumber bonusNumber = new BonusNumber(InputVIew.inputBonusNumber());
        //System.out.println(LottoMatch.getHasBonus());

    List<Integer> countWinnings = LottoMatch.countMatchingNumbers(RandomLottos.SetRandomLottos(ticketsAmount.getTickets()),lotto.getNumbers(),
            bonusNumber.getBonus());
        //System.out.println(countWinnings);
    public void start(){

    }







}
