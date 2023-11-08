package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.exception.ErrorMessages;

public class LottoTickets {

    private static final int PRICE = 1000;
    private static final int ZERO = 0;
    private final List<Lotto> lottoTickets = new ArrayList<>();

    private int ticketsCount;

    public LottoTickets(int buyAmount) {
        validate(buyAmount);
        this.ticketsCount = buyAmount / PRICE;
        generateLottoNumbers(ticketsCount);
    }

    private void generateLottoNumbers(int ticketsCount) {
        for (int i = 0; i < ticketsCount; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottoTickets.add(lotto);
        }
    }

    private static void validate(int buyAmount) {
        validateMinimumAmount(buyAmount);
        validateDivisible(buyAmount);
    }

    private static void validateMinimumAmount(int buyAmount) {
        if ((buyAmount / PRICE <= ZERO)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_INVALID_MIN_AMOUNT.getMessage());
        }
    }

    private static void validateDivisible(int buyAmount) {
        if ((buyAmount % PRICE != ZERO)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DIVISIBLE.getMessage());
        }
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public int getTicketsCount() {
        return ticketsCount;
    }

    public int getPrice() {
        return PRICE;
    }
}
