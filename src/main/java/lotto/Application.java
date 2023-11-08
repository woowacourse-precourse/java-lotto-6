package lotto;

import java.util.List;
import lotto.config.ObjectFactory;
import lotto.controller.LottoController;
import lotto.domain.WinningLottoTable;
import lotto.dto.BuyLottoDto;
import lotto.dto.LottoInfoDto;
import lotto.dto.LottoRanksDto;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ObjectFactory objectFactory = new ObjectFactory();
        LottoController controller = objectFactory.lottoController();
        InputView inputView = objectFactory.inputView();

        run(inputView, controller);
    }

    private static void run(InputView inputView, LottoController controller) {
        BuyLottoDto buyLottoDto = createBuyLottoDto(inputView, controller);
        WinningLottoTable winningLottoTable = createWinningLottoTable(inputView, buyLottoDto.getLottoBundle(),
                controller);
        totalLotteriesYield(winningLottoTable, buyLottoDto.getLottoCnt(), controller);
    }

    private static BuyLottoDto createBuyLottoDto(InputView inputView, LottoController controller) {
        return controller.buyLotteries(inputView.number());
    }

    private static WinningLottoTable createWinningLottoTable(InputView inputView, List<List<Integer>> lotteries,
                                                             LottoController controller) {
        return controller.informLottoResult(createLottoInfoDto(inputView, lotteries));
    }

    private static LottoInfoDto createLottoInfoDto(InputView inputView, List<List<Integer>> lotteries) {
        List<Integer> winnerNumbers = inputView.numbers();
        int bonusNumber = inputView.bonus();
        return LottoInfoDto.valueOf(lotteries, winnerNumbers, bonusNumber);
    }

    private static void totalLotteriesYield(WinningLottoTable winningLottoTable, long lottoCnt,
                                            LottoController controller) {
        controller.informYield(LottoRanksDto.valueOf(winningLottoTable, lottoCnt));
    }
}
