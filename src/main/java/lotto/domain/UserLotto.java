package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserLotto {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Lotto> userLottoNumbers;

    public UserLotto(int numberOfTickets) {
        this.userLottoNumbers = new ArrayList<>();

        setUserLottoNumbers(numberOfTickets);
    }

    private void setUserLottoNumbers(int numberOfTickets) {
        userLottoNumbers.addAll(IntStream.range(0, numberOfTickets)
                .mapToObj(i -> new Lotto(generatedNumbers()))
                .collect(Collectors.toList()));
    }

    private List<Integer> generatedNumbers() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_SIZE);
    }

    public List<Lotto> getUserLottoNumbers() {
        return userLottoNumbers;
    }

}
