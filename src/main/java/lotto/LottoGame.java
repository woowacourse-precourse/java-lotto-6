package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    public void play() {
        //request price
        String userPrice = InputView.requestPrice();

        //parseToInt
        Integer ticketCount = Integer.parseInt(userPrice) / 1000;

        //create Lottos
        Lottos randomLottos = Lottos.create(ticketCount);

        //request lotto numbers
        String userNumbers = InputView.requestNumbers();

        List<Integer> numbers = Arrays.stream(userNumbers.split(","))
                .map(Integer::parseInt)
                .toList();

        Lotto userLotto = Lotto.create(numbers);

        //request bonus number
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer userBonus = Integer.parseInt(Console.readLine());

        //compare lotto and bonusNumber
        Buyer buyer = Buyer.create(userLotto, userBonus);

        Result result = randomLottos.calcuateResult(buyer);
    }
}
