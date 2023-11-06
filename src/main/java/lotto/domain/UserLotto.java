package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class UserLotto {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Lotto> userLottoNumber;

    public UserLotto(int numberOfTickets) {
        this.userLottoNumber = new ArrayList<>();

        setUserLottoNumber(numberOfTickets);
    }

    private void setUserLottoNumber(int numberOfTickets) {
        for (int i = 0; i < numberOfTickets; i++) {
            userLottoNumber.add(new Lotto(generatedNumbers()));
        }
    }

    private List<Integer> generatedNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, LOTTO_SIZE);
    }

    public List<Lotto> getUserLottoNumber() {
        return userLottoNumber;
    }

}
