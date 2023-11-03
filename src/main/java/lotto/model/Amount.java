package lotto.model;

import static lotto.enumerate.ErrorCode.AMOUNT_IS_UNDER_THOUSAND_WON;
import static lotto.enumerate.ErrorCode.AMOUNT_UNIT_IS_NOT_1000_WON;
import static lotto.util.ExceptionCodeThrow.exceptionCodeThrow;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        validAmount(amount);
        this.amount = amount;
    }

    public List<Lotto> buyLotto(int amount) {
        return getLottos(amount);
    }

    private ArrayList<Lotto> getLottos(int amount) {
        ArrayList<Lotto> list = new ArrayList<>();
        int lottoVolume = amount / 1000;
        getLottoList(lottoVolume, list);
        return list;
    }

    private void getLottoList(int lottoVolume, ArrayList<Lotto> list) {
        for (int i = 0; i < lottoVolume; i++) {
            List<Integer> numbers = Randoms
                    .pickUniqueNumbersInRange(1, 45, 6);
            list.add(new Lotto(numbers));
        }
    }

    private void validAmount(int amount) {
        unitThousandWonValid(amount);
        amountUnderThousandWonValid(amount);
    }

    private static void amountUnderThousandWonValid(int amount) {
        if (amount <= 0) {
            exceptionCodeThrow(AMOUNT_IS_UNDER_THOUSAND_WON);
        }
    }

    private static void unitThousandWonValid(int amount) {
        if (amount % 1000 != 0) {
            exceptionCodeThrow(AMOUNT_UNIT_IS_NOT_1000_WON);
        }
    }
}
