package lotto.domain;

import static lotto.ApplicationContext.getDataModel;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.constant.LottoConstant;
import lotto.exception.ExceptionType;
import lotto.exception.InputException;
import lotto.output.MessageType;
import lotto.output.OutputMessage;

public class Tickets {
    private final int wallet;
    private int ticketCount;
    private List<List<Integer>> tickets = new ArrayList<>();

    public Tickets(int wallet) {
        validate(wallet);
        this.wallet = wallet;
        this.ticketCount = wallet / LottoConstant.PRICE_PER_TICKET;

        OutputMessage.printf(MessageType.INPUT_BUYER_FORMAT, this.wallet);
        OutputMessage.printf(MessageType.INPUT_BUY_END, this.ticketCount);
    }

    private void validate(int wallet) {
        if (isGenerate(wallet)) {
            throw new InputException(ExceptionType.ERROR_TICKETS_GENERATE);
        }
    }

    private boolean isGenerate(int wallet) {
        return wallet % LottoConstant.PRICE_PER_TICKET > 0;
    }

    public void generate() {
        this.tickets = IntStream.range(0, this.ticketCount)
                .mapToObj(i -> randomNumbers())
                .map(this::ascendingNumber)
                .peek(ticket -> OutputMessage.printf(MessageType.INPUT_BUYER_FORMAT, ticket))
                .collect(Collectors.toList());
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

    public void saveWallet() {
        getDataModel().saveWallet(this.wallet);
    }

    public void saveTickets() {
        getDataModel().saveTicktet(this.tickets);
    }
}
