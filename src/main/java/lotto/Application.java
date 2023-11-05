package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.service.Service;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;

public class Application {
    public static void main(String[] args) {

        InputMessage.inputPurchaseAmount();
        int purchaseAmount = Integer.parseInt(Console.readLine());
        Buyer buyer = Buyer.from(purchaseAmount);

        Service.buyLotteries(buyer);
        List<Lotto> example = buyer.getPurchasedLotto();

        OutputMessage.purchasedLotto(example.size());
        example.forEach(lotto -> OutputMessage.showLottoNumbers(lotto.getNumbers()));
    }
}
