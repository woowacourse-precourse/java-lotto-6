package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoGame {
    public void play() {
        //request price
        String userPrice = InputView.requestPrice();

        //parseToInt
        Integer ticketCount = ConvertingUtil.convertToTicket(userPrice);

        OutputView.noticeTicketCount(ticketCount);

        //create Lottos
        Lottos randomLottos = Lottos.create(ticketCount);

        //request lotto numbers
        String userNumbers = InputView.requestNumbers();

        List<Integer> numbers = Arrays.stream(userNumbers.split(","))
                .map(Integer::parseInt)
                .toList();

        Lotto userLotto = Lotto.create(numbers);

        //request bonus number
        String userBonus = InputView.requestBonus();

        Integer bonus = ConvertingUtil.convertToInteger(userBonus);

        //compare lotto and bonusNumber
        Buyer buyer = Buyer.create(userLotto, bonus);

        Result result = randomLottos.calcuateResult(buyer);
    }
}
