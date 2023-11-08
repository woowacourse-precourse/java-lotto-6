package lotto.controller;

import java.util.List;
import lotto.domain.purchasingMoney.PurchasingMoney;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbersGenerator;
import lotto.domain.lotto.WinningLottoNumbers;
import lotto.domain.lotto.strategy.PickNumbersStrategy;
import lotto.domain.lotto.strategy.PickRandomNumbersStrategy;
import lotto.domain.message.Messenger;
import lotto.domain.prize.Prize;
import lotto.domain.win.WinStatesCounter;
import lotto.dto.LottoNumbersDTO;
import lotto.dto.WinStateInformationDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final PickNumbersStrategy pickNumbersStrategy = new PickRandomNumbersStrategy();
    private final LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator(pickNumbersStrategy);

    private final Messenger messenger = new Messenger();

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchasingMoney purchasingMoney = requestPurchaseCash();
        List<Lotto> lotteries = purchaseLotteries(purchasingMoney);

        WinningLottoNumbers winningLottoNumbers = requestWinningLottoNumbers();

        List<WinStateInformationDTO> winStateInformationDTOs = determineWinStates(winningLottoNumbers, lotteries);
        printWinningStatistics(winStateInformationDTOs);
        printYield(winStateInformationDTOs, purchasingMoney);
    }

    private PurchasingMoney requestPurchaseCash() {
        outputView.print(messenger.getInputPurchaseCashAmountMessage());
        while (true) {
            try {
                return new PurchasingMoney(inputView.inputNumber());
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private List<Lotto> purchaseLotteries(PurchasingMoney purchasingMoney) {
        int lotteriesCount = purchasingMoney.countPurchasableAmount();
        outputView.print(messenger.getPurchasedLotteriesCountMessage(lotteriesCount));
        return generateLotteries(lotteriesCount);
    }

    private List<Lotto> generateLotteries(int count) {
        List<LottoNumbersDTO> lottoNumbersDTOs = lottoNumbersGenerator.generateByCount(count);
        outputView.print(messenger.getLotteriesNumbersMessage(lottoNumbersDTOs));
        return lottoNumbersDTOs.stream()
                .map(LottoNumbersDTO::numbers)
                .map(Lotto::new)
                .toList();
    }

    private WinningLottoNumbers requestWinningLottoNumbers() {

        outputView.print(messenger.getInputWinningNumbersMessage());
        Lotto winningNumbers = inputNumbers();

        outputView.print(messenger.getInputBonusNumberMessage());
        while (true) {
            try {
                LottoNumber bonusNumber = new LottoNumber(inputView.inputNumber());
                return new WinningLottoNumbers(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private Lotto inputNumbers() {
        while (true) {
            try {
                return new Lotto(inputView.inputNumbers());
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private List<WinStateInformationDTO> determineWinStates(
            WinningLottoNumbers winningLottoNumbers,
            List<Lotto> lotteries
    ) {
        WinStatesCounter winStatesCounter = new WinStatesCounter(winningLottoNumbers, lotteries);
        return winStatesCounter.getWinStateInformationDTOs();
    }

    private void printWinningStatistics(List<WinStateInformationDTO> winStateInformationDTOs) {
        outputView.print(messenger.getWinningStatisticStartMessage());
        outputView.print(messenger.getWinningStatisticsInformationMessage(winStateInformationDTOs));
    }

    private void printYield(List<WinStateInformationDTO> winStateInformationDTOs, PurchasingMoney purchasingCash) {
        Prize prize = Prize.from(winStateInformationDTOs);
        double yield = prize.getYield(purchasingCash);
        outputView.print(messenger.getYieldMessage(yield));
    }

}
