package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.result.Result;
import lotto.domain.userpick.UserPick;
import lotto.domain.purchase.Purchase;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Purchase purchase = new Purchase();
        UserPick userPick = new UserPick();
        Result result = new Result();

        Integer quantity = purchase.makePurchase();

        List<Lotto> lottoTicketList = Lotto.gatherLottoTickets(quantity);

        List<Integer> userLottoNumbers = userPick.userLottoNumbers();
        Integer userBonusNumber = userPick.userBonusNumber(userLottoNumbers);

        result.showTotalResult(lottoTicketList, userLottoNumbers, userBonusNumber, quantity);
    }
}
