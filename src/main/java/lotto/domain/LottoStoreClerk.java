package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStoreClerk {

    public static List<Lotto> createLottoTickets(int lottoPurchase) {
        int lottoTicketsNumber = calculateNumberOfTickets(lottoPurchase);
        return lottoGenerater(lottoTicketsNumber);
    }

    public static int calculateNumberOfTickets(int lottoOrderAmount) {
        checkLottoOrderAmount(lottoOrderAmount);
        return lottoOrderAmount / Constant.MINIMUM_AMOUNT_IN_UNITS.getValue();
    }

    public static void checkLottoOrderAmount(int lottoOrderAmount) {
        checkMinimumAmount(lottoOrderAmount);
        checkDividableThousand(lottoOrderAmount);
    }

    public static void checkMinimumAmount(int lottoOrderAmount) {
        if (lottoOrderAmount < Constant.MINIMUM_AMOUNT_IN_UNITS.getValue()) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력해주세요");
        }
    }

    public static void checkDividableThousand(int lottoOrderAmount) {
        if (lottoOrderAmount % Constant.MINIMUM_AMOUNT_IN_UNITS.getValue() != Constant.NO_REMAINDER.getValue()) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요");
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
