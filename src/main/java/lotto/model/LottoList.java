package lotto.model;

import static lotto.enumerate.ConfigInteger.LOTTO_END_NUMBER;
import static lotto.enumerate.ConfigInteger.LOTTO_NUMBER_COUNT;
import static lotto.enumerate.ConfigInteger.LOTTO_PRICE;
import static lotto.enumerate.ConfigInteger.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    private static void getLottoNumber(ArrayList<Lotto> list) {
        List<Integer> numbers = Randoms
                .pickUniqueNumbersInRange(LOTTO_START_NUMBER.getInt(), LOTTO_END_NUMBER.getInt(),
                        LOTTO_NUMBER_COUNT.getInt());
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        list.add(new Lotto(lottoNumbers));
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
}
