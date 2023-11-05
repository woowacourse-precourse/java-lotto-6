package lotto.domain;

import static lotto.domain.Util.toNumeric;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStoreClerk {

    public static final int MINIMUM_AMOUNT_IN_UNITS = 1000;
    public static final int NO_REMAINDER = 0;
    public static final int GENERATE_START_NUMBER = 0;
    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_MAXIMUM_NUMBER = 45;
    public static final int COUNT_OF_LOTTO_NUMBER = 6;


    public static List<Lotto> createLottoTickets(String orderInputAmount) {
        int lottoTicketsNumber = calculateNumberOfTickets(toNumeric(orderInputAmount));
        return lottoGenerater(lottoTicketsNumber);
    }

    public static int calculateNumberOfTickets(int lottoOrderAmount) {
        checkLottoOrderAmount(lottoOrderAmount);
        int numberOfLottoTickets = lottoOrderAmount / MINIMUM_AMOUNT_IN_UNITS;
        return numberOfLottoTickets;

    }

    public static void checkLottoOrderAmount(int lottoOrderAmount) {
        if (lottoOrderAmount < MINIMUM_AMOUNT_IN_UNITS || lottoOrderAmount % MINIMUM_AMOUNT_IN_UNITS
                != NO_REMAINDER) {
            throw new IllegalArgumentException();
        }

    }

    public static List<Lotto> lottoGenerater(int lottoTicketNumber) {
        List<Lotto> generatedLottoTickets = new ArrayList<>();
        for (int i = GENERATE_START_NUMBER; i < lottoTicketNumber; i++) {
            generatedLottoTickets.add(
                    new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER,
                            COUNT_OF_LOTTO_NUMBER)));
        }
        return generatedLottoTickets;
    }

}
