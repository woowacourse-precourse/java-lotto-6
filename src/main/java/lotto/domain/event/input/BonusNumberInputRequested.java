package lotto.domain.event.input;

import lotto.domain.event.Event;

public record BonusNumberInputRequested(LottoInputRequested lottoInputReceive, BonusNumber bonusNumber) implements Event {
}
