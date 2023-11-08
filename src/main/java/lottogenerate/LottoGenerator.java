package lottogenerate;

import camp.nextstep.edu.missionutils.Randoms;
import inputdata.LottoTicketInput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Lotto;

public class LottoGenerator {
    private  final int MAX_LOTTO_NUMBER_RANGE = 45;
    private  final int MIN_LOTTO_NUMBER_RANGE = 1;
    private  final int MAX_LOTTO_NUMBER_COUNT = 6;
    private List<Lotto> lottoList = new ArrayList<>();
    public LottoGenerator() {
    }

    public void generateLotto(int lottoTicketPrice) {
        this.lottoList =  IntStream.range(0, lottoTicketPrice)
                .mapToObj(i -> createLotto())
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    private Lotto createLotto() {
        List<Integer> lottoNumbersList = getLottoNumbers();
        lottoNumbersList.sort(Comparator.naturalOrder());

        return new Lotto(lottoNumbersList);
    }

    private List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange
                (MIN_LOTTO_NUMBER_RANGE, MAX_LOTTO_NUMBER_RANGE, MAX_LOTTO_NUMBER_COUNT);
    }
}
