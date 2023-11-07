package lotto;

import lotto.domain.*;

import java.util.*;

public class Application {


    public static void main(String[] args) {

        List<List<Integer>> purchasedLottoTickets = new ArrayList<>();

        List<Integer> winningNumbers;

        int bonusNumber;

        int numberOfLottoTickets;
        User user = new User();
        NumberPicker numberPicker = new NumberPicker();

        System.out.println("구입금액을 입력해 주세요.");
        numberOfLottoTickets = user.countLottoTicketIssues(user.input());

        System.out.println(numberOfLottoTickets + "개를 구매했습니다.");


        Seller seller = new Seller();

        // 구입 횟수만큼 로또 발행
        for (int index = 0; index < numberOfLottoTickets; index++) {
            List<Integer> numbers = seller.issueSixNumbers();
            Lotto lotto = new Lotto(numbers);
            lotto.issueTicket(purchasedLottoTickets);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbers = numberPicker.stringToNumbers(user.input());


        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = numberPicker.pickBonusNumber(user.input());


        System.out.println("당첨 통계");
        System.out.println("---");

        // 당첨 내역 저장, 일치 갯수를 계산하여 해당 인덱스의 값에 +1 (일치 갯수 = 인덱스)
        int[] winningRecord = new int[7];
        int matchFiveWithBonus = 0;

        for (List<Integer> ticket : purchasedLottoTickets) {
            Set<Integer> findSameNumbers = new HashSet<>(winningNumbers);
            findSameNumbers.addAll(ticket);
            int result = 13 - findSameNumbers.size();

            if (result == 5 && ticket.contains(bonusNumber)) {
                matchFiveWithBonus++;
            } else if (result > 0) {
                winningRecord[result] += 1;
            }
        }

        int winningPrize = (winningRecord[3] * 5000) + (winningRecord[4] * 50000) + (winningRecord[5] * 1500000) + (winningRecord[6] * 2000000000);
        double RateOfReturn = (double) winningPrize / (numberOfLottoTickets * 1000) * 100;

        System.out.println(String.format("3개 일치 (5,000원) - %d개", winningRecord[3]));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", winningRecord[4]));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", winningRecord[5]));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", matchFiveWithBonus));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", winningRecord[6]));
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", RateOfReturn));
    }

}
