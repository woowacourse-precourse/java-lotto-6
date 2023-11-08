package lotto.domain.event.input;

import lotto.domain.event.Event;

public record BonusNumber(int number) implements Event {
}
