package lotto;

import java.util.List;
import lotto.config.ObjectFactory;
import lotto.controller.LottoController;
import lotto.domain.WinningLottoTable;
import lotto.dto.BuyLottoDto;
import lotto.dto.LottoInfoDto;
import lotto.dto.LottoRanksDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ObjectFactory objectFactory = new ObjectFactory();
        LottoController controller = objectFactory.lottoController();
        InputView inputView = objectFactory.inputView();
        OutputView outputView = objectFactory.outputView();

        run(inputView, controller, outputView);
    }

    private static void run(InputView inputView, LottoController controller, OutputView outputView) {
        BuyLottoDto buyLottoDto = createBuyLottoDto(inputView, controller, outputView);
        WinningLottoTable winningLottoTable = createWinningLottoTable(inputView, buyLottoDto.getLottoBundle(),
                controller, outputView);
        totalLotteriesYield(winningLottoTable, buyLottoDto.getLottoCnt(), controller);
    }

    private static BuyLottoDto createBuyLottoDto(InputView inputView, LottoController controller,
                                                 OutputView outputView) {
        try {
            return controller.buyLotteries(inputView.number());
        } catch (IllegalArgumentException | IllegalStateException | IndexOutOfBoundsException e) {
            outputView.printErrorMessage(e.getMessage());
            return createBuyLottoDto(inputView, controller, outputView);
        }
    }

    private static WinningLottoTable createWinningLottoTable(InputView inputView, List<List<Integer>> lotteries,
                                                             LottoController controller, OutputView outputView) {
        try {
            return controller.informLottoResult(createLottoInfoDto(inputView, lotteries));
        } catch (IllegalArgumentException | IllegalStateException | IndexOutOfBoundsException e) {
            outputView.printErrorMessage(e.getMessage());
            return createWinningLottoTable(inputView, lotteries, controller, outputView);
        }
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
