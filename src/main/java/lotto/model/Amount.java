package lotto.model;

import static lotto.enumerate.ConfigInteger.LOTTO_END_NUMBER;
import static lotto.enumerate.ConfigInteger.LOTTO_NUMBER_COUNT;
import static lotto.enumerate.ConfigInteger.LOTTO_PRICE;
import static lotto.enumerate.ConfigInteger.LOTTO_START_NUMBER;
import static lotto.enumerate.ConfigInteger.ZERO;
import static lotto.enumerate.ErrorCode.AMOUNT_IS_NOT_LONG;
import static lotto.enumerate.ErrorCode.AMOUNT_IS_UNDER_THOUSAND_WON;
import static lotto.enumerate.ErrorCode.AMOUNT_UNIT_IS_NOT_1000_WON;
import static lotto.util.ExceptionCodeThrow.exceptionCodeThrow;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.enumerate.ConfigInteger;
import lotto.record.AmountRecord;

public class Amount {

    private final long amount;

    public Amount(String amount) {
        validAmount(amount);
        this.amount = convertValid(amount);
    }

    private static void amountUnderThousandWonValid(long convertedAmount) {
        if (convertedAmount <= ZERO.getInt()) {
            exceptionCodeThrow(AMOUNT_IS_UNDER_THOUSAND_WON);
        }
    }

    private static void unitThousandWonValid(long convertedAmount) {
        if (convertedAmount % LOTTO_PRICE.getInt() != ZERO.getInt()) {
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
        long lottoVolume = amount / LOTTO_PRICE.getInt();
        getLottoList(lottoVolume, list);
        return list;
    }

    private void getLottoList(long lottoVolume, ArrayList<Lotto> list) {
        for (int i = 0; i < lottoVolume; i++) {
            List<Integer> numbers = Randoms
                    .pickUniqueNumbersInRange(LOTTO_START_NUMBER.getInt(), LOTTO_END_NUMBER.getInt(), LOTTO_NUMBER_COUNT.getInt());
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
        return ZERO.getInt();
    }
}
