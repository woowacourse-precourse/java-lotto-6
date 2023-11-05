package lotto.model;

import static lotto.enumerate.ConfigInteger.LOTTO_END_NUMBER;
import static lotto.enumerate.ConfigInteger.LOTTO_NUMBER_COUNT;
import static lotto.enumerate.ConfigInteger.LOTTO_PRICE;
import static lotto.enumerate.ConfigInteger.LOTTO_START_NUMBER;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_DUPLICATE;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_OVER_OR_UNDER_SIZE;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_UNDER_OR_OVER;
import static lotto.util.ExceptionCodeThrow.exceptionCodeThrow;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.record.LottoNumberRecord;

public class Lotto {
    private final List<Integer> numbers; // TODO : NumbersList 일급 컬렉션 구현
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public LottoNumberRecord toRecord() {
        return new LottoNumberRecord(numbers);
    }

    public String makeLottoNumberString() {
        return numbers
                .stream().sorted()
                .toList()
                .toString();
    }

    private static void getLottoNumber(ArrayList<Lotto> list) {
        List<Integer> numbers = Randoms
                .pickUniqueNumbersInRange(LOTTO_START_NUMBER.getInt(), LOTTO_END_NUMBER.getInt(),
                        LOTTO_NUMBER_COUNT.getInt());
        list.add(new Lotto(numbers));
    }

    private void getLottoList(long lottoVolume, ArrayList<Lotto> list) {
        for (int i = 0; i < lottoVolume; i++) {
            getLottoNumber(list);
        }
    }

    private ArrayList<Lotto> getLottos(Cash amountCash) {
        ArrayList<Lotto> list = new ArrayList<>();
        long lottoVolume = amountCash.cash() / LOTTO_PRICE.getInt();
        getLottoList(lottoVolume, list);
        return list;
    }

    public List<Lotto> buyLotto(Cash amountCash) {
        return getLottos(amountCash);
    }

    private void validate(List<Integer> numbers) {
        lottoNumberSizeValidate(numbers);
        LottoNumberDuplicateValidate(numbers);
        lottoNumberUnderOverValidate(numbers);
    }

    private void lottoNumberUnderOverValidate(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LOTTO_START_NUMBER.getInt() || number > LOTTO_END_NUMBER.getInt())) {
            exceptionCodeThrow(LOTTO_NUMBER_UNDER_OR_OVER);
        }
    }

    private void LottoNumberDuplicateValidate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            exceptionCodeThrow(LOTTO_NUMBER_DUPLICATE);
        }
    }

    private void lottoNumberSizeValidate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getInt()) {
            exceptionCodeThrow(LOTTO_NUMBER_OVER_OR_UNDER_SIZE);
        }
    }
}
