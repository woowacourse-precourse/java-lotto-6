package lottogenerate;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import user.User;

public class LottoGenerator {
    private static final int MAX_LOTTO_NUMBER_RANGE = 45;
    private static final int MIN_LOTTO_NUMBER_RANGE = 1;
    private static final int MAX_LOTTO_NUMBER_COUNT = 6;
    private User user;

    public LottoGenerator(User user) {
        this.user = user;
    }
    public Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange
                (MIN_LOTTO_NUMBER_RANGE, MAX_LOTTO_NUMBER_RANGE, MAX_LOTTO_NUMBER_COUNT);
        return new Lotto(numbers);
    }

    public List<Lotto> generateLotto() {

        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < lottoTicket(); i++) {
            lottoList.add(createLotto());
        }
        return lottoList;
        // 반환한 로또 정보를 뒤져가지고 사용자가 입력한 위닝넘버와 비교를 해야함.

    }
    private int lottoTicket() {
        return Integer.parseInt(user.getInputBuyLottoTicket()) / 100;
    }
}
