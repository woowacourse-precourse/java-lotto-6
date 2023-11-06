package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.collections.LotteryResultCollection;
import lotto.domain.collections.UserTicketCollection;
import lotto.validator.UserTicketValidator;

import java.util.List;

public class LotteryGame {

    private final Merchant merchant;
    private final LotteryMachine machine;

    public LotteryGame(Merchant merchant, LotteryMachine machine) {
        this.merchant = merchant;
        this.machine = machine;
    }

    public void start() {
        UserTicketCollection userTicketCollection = makeUserTicket();
        userTicketCollection.printUserTicketList();
        LuckyTicket luckyTicket = makeLuckyTicket();
        LotteryResultCollection lotteryResult = luckyTicket.matchWith(userTicketCollection);
        printResultOf(lotteryResult);
    }

    private UserTicketCollection makeUserTicket() {
        int price = getUserPrice();
        return UserTicketCollection.of(getUserLottoNumbers(price));
    }

    private List<Lotto> getUserLottoNumbers(int price) {
        return merchant.getLotteryNumberWith(price);
    }

    private int getUserPrice() {
        System.out.println("구입 금액을 입력해주세요");
        String input = Console.readLine();
        UserTicketValidator.validateTicketPrice(input);
        int price = Integer.parseInt(input);

        return price;
    }

    private LuckyTicket makeLuckyTicket() {
        return machine.makeLuckyTicket();
    }

    private void printResultOf(LotteryResultCollection results) {
        results.printResults();
    }
}
