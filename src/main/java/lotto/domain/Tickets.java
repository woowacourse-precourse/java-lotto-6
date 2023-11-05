package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constant.LottoConstant;
import lotto.exception.ExceptionType;
import lotto.exception.InputException;

public class Tickets {
    private final int wallet;
    private int ticketCount;
    private List<List<Integer>> tickets = new ArrayList<>();

    public Tickets(int wallet) {
        validate(wallet);
        this.wallet = wallet;
        this.ticketCount = wallet / LottoConstant.PRICE_PER_TICKET;
    }

    public List<List<Integer>> getTickets() {
        return Collections.unmodifiableList(tickets);
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
}
