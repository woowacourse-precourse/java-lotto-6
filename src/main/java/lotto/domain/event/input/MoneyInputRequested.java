package lotto.domain.event.input;

import lotto.domain.event.Event;

public record MoneyInputRequested(int money) implements Event {


}
