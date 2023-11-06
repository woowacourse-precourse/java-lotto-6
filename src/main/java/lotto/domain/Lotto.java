package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.enums.LottoPrize;
import lotto.utils.ValidateUtils;

import java.util.*;

public class Lotto {
    private static final int LOWER_BOUND_NUMBER = 1;
    private static final int UPPER_BOUND_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    private ValidateUtils validateUtils = new ValidateUtils();

    public Lotto(List<Integer> numbers) {
        validateUtils.validateSize(numbers, LOTTO_SIZE);
        validateUtils.validateDuplicated(numbers);
        this.numbers = numbers;
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

    public List<LottoPrize> getAllLottoPrizes(List<Lotto> autoLottoTickets, BonusNumber bonusNumber) {
        List<LottoPrize> lottoPrizes = new ArrayList<>();

        for (Lotto autoLottoTicket : autoLottoTickets) {
            int count = countMatchingLottoNumbers(autoLottoTicket);
            int number = bonusNumber.getBonusNumber();
            boolean bonusMatch = autoLottoTicket.lottoContainNumber(number);
            LottoPrize lottoPrize = LottoPrize.valueOf(count, bonusMatch);
            lottoPrizes.add(lottoPrize);
        }
        return lottoPrizes;
    }

    public int countMatchingLottoNumbers(Lotto autoLottoTicket) {
        int count = 0;

        for (Integer number : numbers) {
            if (autoLottoTicket.lottoContainNumber(number)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean lottoContainNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return "" + numbers;
    }
}
