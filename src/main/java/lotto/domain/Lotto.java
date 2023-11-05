package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.enums.LottoPrize;

import java.util.*;

public class Lotto {
    private static final int LOWER_BOUND_NUMBER = 1;
    private static final int UPPER_BOUND_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        boolean isUnique = numbers.stream().allMatch(n -> uniqueNumbers.add(n));

        if (!isUnique) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

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

    public List<Integer> getAllLottoRanks(List<Lotto> autoLottoTickets, Lotto winningLotto, BonusNumber bonusNumber) {
        List<Integer> lottoRanks = new ArrayList<>();

        for (Lotto autoLottoTicket : autoLottoTickets) {
            int count = countMatchingLottoNumbers(autoLottoTicket, winningLotto);
            boolean bonusMatch = bonusNumber.lottoNumbersContainBonusNumber(autoLottoTicket.numbers);
            LottoPrize.valueOf(count, bonusMatch);
            lottoRanks.add(count);
        }
        return lottoRanks;
    }

    public int countMatchingLottoNumbers(Lotto autoLottoTicket, Lotto winningLotto) {
        List<Integer> autoLottoNumbers = autoLottoTicket.numbers;
        List<Integer> winningNumbers = winningLotto.numbers;
        int count = 0;

        for (Integer winningNumber : winningNumbers) {
            if (autoLottoNumbers.contains(winningNumber)) {
                count += 1;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "" + numbers;
    }
}
