package lotto;

import lotto.domain.Lotto;
import lotto.domain.Seller;
import lotto.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        User user = new User();
        System.out.println("구입금액을 입력해 주세요.");
        int numberOfLottoTickets = user.countLottoTicketIssues(user.userInput());

        System.out.println(numberOfLottoTickets + "개를 구매했습니다.");
        List<List<Integer>> purchasedLottoTickets = new ArrayList<>();

        Seller seller = new Seller();

        for (int i = 0; i < numberOfLottoTickets; i++) {
            List<Integer> numbers = seller.issueSixNumbers();
            Lotto lotto = new Lotto(numbers);
            lotto.issueTicket(purchasedLottoTickets);
        }



    }
}
