package lotto;

import lotto.Domain.GameInfo;
import lotto.Domain.Lotto;
import lotto.Service.InputService;
import lotto.Service.LottoService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputService inputService = new InputService();
        List<Lotto> lottoTickets = inputService.createLottoTickets();
        GameInfo gameInfo = inputService.createGameInfo();

        LottoService lottoService = new LottoService(lottoTickets, gameInfo);
        lottoService.checkLottoResult();
    }
}
