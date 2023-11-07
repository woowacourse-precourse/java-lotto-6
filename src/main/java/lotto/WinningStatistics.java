package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.UserInputHandler.DIVISION_ROLE;
import static lotto.messages.LottoInputMessages.COMPLETE_MESSAGE_LOTTO_COST;

public class WinningStatistics {
    private final List<Lotto> lottoTickets;
    private final List<Integer> matchingNumber = new ArrayList<>(Collections.nCopies(7, 0));

    public WinningStatistics() {
        this.lottoTickets = new ArrayList<>();
    }

    public List<Integer> getMatchingNumber() {
        return matchingNumber;
    }

    // 로또 구매
    public long purchaseLottoTickets(long totalAmount) {
        long ticket = totalAmount / DIVISION_ROLE; // 몇 장인지 확인
        System.out.printf(COMPLETE_MESSAGE_LOTTO_COST.getMessage() + "\n", ticket);

        return ticket;
    }

    public List<Integer> generateSaveLottoNumbers() {
        Lotto lotto = Lotto.generateLottoNumbers();
        List<Integer> numbers = lotto.getNumbers();
        lottoTickets.add(lotto);

        return numbers;
    }

    // 로또 당첨번호가 일치하는 경우 값 갱신
    public void calculateStatistics(List<Integer> winningNumber, int bonusNumber) {
        for (Lotto lotto : lottoTickets) {
            List<Integer> updateNumber = lotto.calculateMatchingNumbers(winningNumber, bonusNumber);
            updateMatchingNumber(updateNumber);
        }
    }

    // 실제 값 갱신하는 함수
    private void updateMatchingNumber(List<Integer> updateNumber) {
        for (int i = 0; i < updateNumber.size(); i++) {
            int originalValue = matchingNumber.get(i);
            int updateValue = updateNumber.get(i);
            matchingNumber.set(i, originalValue + updateValue);
        }
    }


    // 이득률 계산
    public double matchingTotal(long userCost) {
        long totalSum = matchingNumber.get(3) * 5_000 +
                matchingNumber.get(4) * 50_000 +
                matchingNumber.get(5) * 1_500_000 +
                matchingNumber.get(6) * 2_000_000_000 +
                matchingNumber.get(0) * 30_000_000;
        return (double) totalSum / userCost * 100;
    }

    public double matchingTotal(long userCost, List<Integer> matchingNumber) {
        long totalSum = matchingNumber.get(3) * 5_000 +
                matchingNumber.get(4) * 50_000 +
                matchingNumber.get(5) * 1_500_000 +
                matchingNumber.get(6) * 2_000_000_000 +
                matchingNumber.get(0) * 30_000_000;
        return (double) totalSum / userCost * 100;
    }
}
