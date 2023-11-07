package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

public class Purchase {
    public List[] automaticNum(List[] allTickets, int ticketNumber) {
        for (int i = 0; i < ticketNumber; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Comparator.naturalOrder());
            allTickets[i] = numbers;
            System.out.println(numbers);
        }
        return allTickets;
    }
}
