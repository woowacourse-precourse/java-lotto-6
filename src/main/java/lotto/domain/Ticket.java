package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);;

    public Ticket() {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        List<String> ticketNumbers = new ArrayList<>();
        for (Integer i : numbers) {
            ticketNumbers.add(i.toString());
        }
        String ticket = "[" + String.join(", ",ticketNumbers) + "]";
        return ticket;

    }
}
