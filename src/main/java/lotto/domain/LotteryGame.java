package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.collections.LotteryResultCollection;
import lotto.domain.collections.UserTicketCollection;
import lotto.message.ErrorMessageFormatter;
import lotto.validator.UserTicketValidator;

import java.util.List;
import java.util.Optional;

import static lotto.message.ErrorMessageFormatter.*;
import static lotto.validator.UserTicketValidator.*;

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
        boolean inputFail = false;
        Optional<Integer> price = Optional.empty();
        do {
            try {
                System.out.println("구입 금액을 입력해주세요");
                String input = Console.readLine();
                validateTicketPrice(input);
                price = Optional.of(Integer.parseInt(input));
                inputFail = false;
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage("복권 금액은 1,000단위로 양의정수를 입력해주세요."));
                inputFail = true;
            }
        } while (inputFail);

        return price.orElseThrow(() -> new IllegalStateException("복권 가격을 정할 수 없습니다."));
    }

    private LuckyTicket makeLuckyTicket() {
        return machine.makeLuckyTicket();
    }

    private void printResultOf(LotteryResultCollection results) {
        results.printResults();
    }
}
