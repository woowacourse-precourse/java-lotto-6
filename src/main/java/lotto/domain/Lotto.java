package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private static List<Integer> issueTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static List<List<Integer>> issueTickets(int ticketCount) {
        List<List<Integer>> lotteryTickets = new ArrayList<>();
        for(int i =0; i<ticketCount; i++) {
            lotteryTickets.add(issueTicket());
        }
        return lotteryTickets;
    }

    public Lotto(List<Integer> numbers) {

        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 티켓 한 장에는 6개의 숫자를 입력해야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
