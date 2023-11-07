package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.config.exception.ExceptionType;
import lotto.config.exception.InputException;
import lotto.config.output.MessageType;
import lotto.config.output.OutputMessage;
import lotto.domain.constant.LottoConstant;

public class Ticket {
    private List<Integer> ticket;
    private final int money;

    public Ticket(int money) {
        validate(money);
        this.money = money;
        OutputMessage.printf(MessageType.INPUT_BUYER_FORMAT, this.money);
        OutputMessage.printf(MessageType.INPUT_BUY_END, ticketCount());
    }

    private void validate(int wallet) {
        if (isGenerate(wallet)) {
            throw new InputException(ExceptionType.ERROR_TICKETS_GENERATE);
        }
    }

    private boolean isGenerate(int wallet) {
        return wallet % LottoConstant.PRICE_PER_TICKET > 0;
    }

    public int ticketCount(){
        return this.money / LottoConstant.PRICE_PER_TICKET;
    }

    public Ticket generate(){
        List<Integer> disorderTicket = randomNumbers();
        this.ticket = ascendingNumber(disorderTicket);
        return this;
    }

    private List<Integer> randomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_START_NUMBER,
                LottoConstant.LOTTO_END_NUMBER, LottoConstant.LOTTO_PICK_NUMBER);
    }

    private List<Integer> ascendingNumber(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        return sortedNumbers;
    }

    public List<Integer> get(){
        return this.ticket;
    }

}
