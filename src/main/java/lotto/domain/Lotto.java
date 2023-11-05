package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private static final int LOWER_BOUND_NUMBER = 1;
    private static final int UPPER_BOUND_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto makeWinningNumbers(String inputString) {
        WinningNumbers winningNumbers = WinningNumbers.from(inputString);
        return new Lotto(winningNumbers.getWinningNumbers());
    }

    public static Lotto makeAutoLottoTicket() {
        List<Integer> lottoTicket = Randoms.pickUniqueNumbersInRange(LOWER_BOUND_NUMBER, UPPER_BOUND_NUMBER, LOTTO_SIZE);
        sortLottoNumbers(lottoTicket);
        return new Lotto(lottoTicket);
    }

    public static void sortLottoNumbers(List<Integer> lottoTicket) {
        Collections.sort(lottoTicket);
    }

    public static List<Lotto> getAutoLottoTickets(LottoCount lottoCount) {
        int count = lottoCount.getLottoCount();
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoTickets.add(makeAutoLottoTicket());
        }
        return lottoTickets;
    }

    @Override
    public String toString() {
        return "" + numbers;
    }
}
