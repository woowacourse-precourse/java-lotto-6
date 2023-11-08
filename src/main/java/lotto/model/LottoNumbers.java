package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final int CNT_LOTTO_NUMBER = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static List<Integer> lotto = new ArrayList<>();

    private static List<Integer> lottoNumberList;
    private static List<Lotto> lottos;

    public LottoNumbers() {
    }

    public LottoNumbers(int number) {
        lottos = new ArrayList<>();
        IntStream.range(0, number).forEach(i ->  lottos.add(makeLotto()));
    }

    private static Lotto makeLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = new ArrayList<>();
        lotto = lottoNumbers.setRandomNumbers();
        return new Lotto(lotto);
    }

    public static List<Lotto> getLottos() {
        return lottos;
    }

    public static List<Integer> setRandomNumbers() {
        lottoNumberList = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, CNT_LOTTO_NUMBER);
        List<Integer> lottoTicketNumberList = new ArrayList<>(lottoNumberList);
        Collections.sort(lottoTicketNumberList);
        return lottoTicketNumberList;
    }
}
