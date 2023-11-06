package lottogenerate;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Lotto;
import user.User;

public class LottoGenerator {
    private static final int MAX_LOTTO_NUMBER_RANGE = 45;
    private static final int MIN_LOTTO_NUMBER_RANGE = 1;
    private static final int MAX_LOTTO_NUMBER_COUNT = 6;
    private final User user;
    private final List<Lotto> lottoList;

    public LottoGenerator(User user) {
        this.lottoList = new ArrayList<>();
        this.user = user;
    }
    public List<Lotto> generateLotto() {
        return IntStream.range(0, lottoTicket())
                .mapToObj(i -> createLotto())
                .collect(Collectors.toList());
        // 반환한 로또 정보를 뒤져가지고 사용자가 입력한 위닝넘버와 비교를 해야함.
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    private int lottoTicket() {
        return user.inputLottoTicketPrice();
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
