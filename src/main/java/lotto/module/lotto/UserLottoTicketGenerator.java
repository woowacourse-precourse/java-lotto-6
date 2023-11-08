package lotto.module.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 구매한 로또 번호를 생성하는 클래스
 */
public class UserLottoTicketGenerator implements LottoNumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int SIZE = 6;

    private UserLottoTicketGenerator() {
    }

    public static UserLottoTicketGenerator newInstance() {
        return new UserLottoTicketGenerator();
    }

    @Override
    public UserLottoTicket generateLottoNumber() {
        final List<Integer> RANDOM_NUMBER = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, SIZE));
        Collections.sort(RANDOM_NUMBER);

        return UserLottoTicket.newInstance(RANDOM_NUMBER);
    }

}
