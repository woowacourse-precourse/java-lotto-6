package lotto.lottosystem.presentation.printer;

import lotto.lottosystem.bussiness.Lotto;

import java.util.List;

public record TicketsVO(List<Lotto> tickets) {
}
