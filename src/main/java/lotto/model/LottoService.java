package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.controller.InputController;

public class LottoService {

    public int calculateTicketCount() {
        return InputController.inputPlayerAmount();
    }
    public List<Lotto> createLottos(int ticketCount) {
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> new Lotto(LottoNumbers.generateRandomNum()))
                .collect(Collectors.toList());
    }
}
