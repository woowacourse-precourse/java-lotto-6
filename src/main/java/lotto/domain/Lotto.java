package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> ticket;

    public Lotto(List<Integer> ticket) {
        validate(ticket);
        this.ticket = ticket;
        Collections.sort(ticket);
    }

    private void validate(List<Integer> ticket) {
        if (ticket.size() != 6) {
            throw new IllegalArgumentException("번호는 6개");
        }

        Set<Integer> uniqueSet = new HashSet<>(ticket);
        if (ticket.size() != uniqueSet.size()) {
            throw new IllegalArgumentException("중복된 번호");
        }
    }

    public int countMatch(Lotto ticket) {
        List<Integer> otherNumbers = new ArrayList<>(ticket.getLottoNumbers());
        otherNumbers.retainAll(this.ticket);
        return otherNumbers.size();
    }

    List<Integer> getLottoNumbers() {
        return ticket;
    }

    @Override
    public String toString() {
        return "["+ ticket.get(0)+", "+
                ticket.get(1)+", "+
                ticket.get(2)+", "+
                ticket.get(3)+", "+
                ticket.get(4)+", "+
                ticket.get(5)+"]";
    }
}