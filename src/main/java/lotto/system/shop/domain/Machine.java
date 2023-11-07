package lotto.system.shop.domain;

import java.util.List;
import lotto.system.shop.domain.ticket.Ticket;

public interface Machine<T extends Ticket<?>, R> {

    void initialize();

    void set(List<Integer> source);

    void set(Integer source);

    T buy();

    List<T> buy(Integer money);

    R match(T ticket);

    List<R> match(List<T> tickets);
}
