package lotto.Service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {
    private final int TICKET_PRICE = 1000;
    public int getTicketCount(int money) {
        if (money % TICKET_PRICE == 0) return money / TICKET_PRICE;
        throw new IllegalArgumentException("1000원으로 나누어 떨어지지 않습니다.");
    }
    public List<Integer> CompareNumbers(List<Lotto> purchasedLottos, List<Integer> winningNumbers) {
        List<Integer> matchedNumbers = new ArrayList<>();
        for (Lotto lotto : purchasedLottos) {
            int matchedNumber = countCommonElements(lotto.getNumbers(), winningNumbers);
            matchedNumbers.add(matchedNumber);
        }
        return matchedNumbers;
    }
    private static <T> int countCommonElements(List<T> lottoNumbers, List<T> winningNumbers) {
        Set<T> matchingLottoNumbers = new HashSet<>(lottoNumbers);
        Set<T> comparison = new HashSet<>(winningNumbers);

        matchingLottoNumbers.retainAll(comparison); // set1과 set2에서 공통된 요소만 남김
        return matchingLottoNumbers.size();
    }
    public boolean CompareBonusNumbers(List<Lotto> purchasedLottos, int bonusBall) {
        boolean isBonusBall = false;
        for (Lotto lotto : purchasedLottos) {
            isBonusBall = hasBonusBall(lotto.getNumbers(), bonusBall);
        }
        return isBonusBall;
    }
    private boolean hasBonusBall(List<Integer> numbers, int bonusNumber) {
        for (int number : numbers) {
            if (number == bonusNumber) {
                return true;
            }
        }
        return false;
    }
}
