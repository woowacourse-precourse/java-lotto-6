package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Seller {

    private int numberOfLottoTickets;
    private List<Integer> numbers = new ArrayList<>();

    private void issueSixNumbers() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void issueTicket() {
        User user = new User();
        System.out.println("구입금액을 입력해 주세요.");
        int numberOfLottoTickets = user.countLottoTicketIssues(user.userInput());

        System.out.println(numberOfLottoTickets + "개를 구매했습니다.");
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottoTickets; i++) {
            issueSixNumbers();

            lottos.add(numbers);
            System.out.println(numbers);
        }

    }

}
