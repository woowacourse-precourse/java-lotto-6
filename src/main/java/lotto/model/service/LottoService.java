package lotto.model.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.controller.InputController;
import lotto.model.LottoNumbers;
import lotto.model.entity.Lotto;
import lotto.utils.Constants;

public class LottoService {

    public int calculateTicketCount() {
        return InputController.inputValidPlayerAmount();
    }
    public List<Lotto> createLottos(int ticketCount) {
        return IntStream.range(Constants.ZERO, ticketCount)
                .mapToObj(i -> new Lotto(LottoNumbers.generateRandomNum()))
                .collect(Collectors.toList());
    }
}
