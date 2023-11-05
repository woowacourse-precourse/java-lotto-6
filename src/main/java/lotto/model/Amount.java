package lotto.model;

import static lotto.enumerate.ErrorCode.AMOUNT_IS_NOT_LONG;
import static lotto.enumerate.ErrorCode.AMOUNT_IS_UNDER_THOUSAND_WON;
import static lotto.enumerate.ErrorCode.AMOUNT_UNIT_IS_NOT_1000_WON;
import static lotto.util.ExceptionCodeThrow.exceptionCodeThrow;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.record.AmountRecord;

public class Amount {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final long amount;

    public Amount(String amount) {
        validAmount(amount);
        this.amount = convertValid(amount);
    }

    private static void amountUnderThousandWonValid(long convertedAmount) {
        if (convertedAmount <= ZERO) {
            exceptionCodeThrow(AMOUNT_IS_UNDER_THOUSAND_WON);
        }
    }

    private static void unitThousandWonValid(long convertedAmount) {
        if (convertedAmount % LOTTO_PRICE != ZERO) {
            exceptionCodeThrow(AMOUNT_UNIT_IS_NOT_1000_WON);
        }
    }

    public List<Lotto> buyLotto() {
        return getLottos(amount);
    }

    public AmountRecord toRecord() {
        return new AmountRecord(amount);
    }

    private ArrayList<Lotto> getLottos(long amount) {
        ArrayList<Lotto> list = new ArrayList<>();
        long lottoVolume = amount / LOTTO_PRICE;
        getLottoList(lottoVolume, list);
        return list;
    }

    private void getLottoList(long lottoVolume, ArrayList<Lotto> list) {
        for (int i = 0; i < lottoVolume; i++) {
            List<Integer> numbers = Randoms
                    .pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNT);
            list.add(new Lotto(numbers));
        }
    }

    private void validAmount(String amount) {
        long convertedAmount = convertValid(amount);
        unitThousandWonValid(convertedAmount);
        amountUnderThousandWonValid(convertedAmount);
    }

    private long convertValid(String amount) {
        try {
            return Long.parseLong(amount);
        } catch (NumberFormatException e) {
            exceptionCodeThrow(AMOUNT_IS_NOT_LONG);
        }
        return ZERO;
    }
}
