package lotto.domain;

import static lotto.domain.ValidateUtil.toNumeric;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStoreClerk {
    public static List<Lotto> createLottoTickets(String orderInputAmount) {
        int lottoTicketsNumber = calculateNumberOfTickets(toNumeric(orderInputAmount));
        return lottoGenerater(lottoTicketsNumber);
    }

    public static int calculateNumberOfTickets(int lottoOrderAmount) {
        checkLottoOrderAmount(lottoOrderAmount);
        int numberOfLottoTickets = lottoOrderAmount / Constant.MINIMUM_AMOUNT_IN_UNITS.getValue();
        return numberOfLottoTickets;

    }

    public static void checkLottoOrderAmount(int lottoOrderAmount) {
        if (lottoOrderAmount < Constant.MINIMUM_AMOUNT_IN_UNITS.getValue()
                || lottoOrderAmount % Constant.MINIMUM_AMOUNT_IN_UNITS.getValue()
                != Constant.NO_REMAINDER.getValue()) {
            throw new IllegalArgumentException();
        }

    }

    public static List<Lotto> lottoGenerater(int lottoTicketNumber) {
        List<Lotto> generatedLottoTickets = new ArrayList<>();
        for (int i = Constant.GENERATE_START_NUMBER.getValue(); i < lottoTicketNumber; i++) {
            generatedLottoTickets.add(
                    new Lotto(Randoms.pickUniqueNumbersInRange(Constant.LOTTO_MINIMUM_NUMBER.getValue(),
                            Constant.LOTTO_MAXIMUM_NUMBER.getValue(),
                            Constant.COUNT_OF_LOTTO_NUMBER.getValue())));
        }
        return generatedLottoTickets;
    }

}
