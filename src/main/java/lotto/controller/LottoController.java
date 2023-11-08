package lotto.controller;

import java.util.List;
import lotto.domain.cash.Cash;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbersGenerator;
import lotto.domain.lotto.WinningLottoNumbers;
import lotto.domain.lotto.strategy.PickNumbersStrategy;
import lotto.domain.lotto.strategy.PickRandomNumbersStrategy;
import lotto.domain.message.Messenger;
import lotto.domain.prize.Prize;
import lotto.domain.shop.LottoShop;
import lotto.domain.win.WinStatesCounter;
import lotto.dto.LottoNumbersDTO;
import lotto.dto.WinStateInformationDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final LottoShop lottoShop = new LottoShop();

    private final PickNumbersStrategy pickNumbersStrategy = new PickRandomNumbersStrategy();
    private final LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator(pickNumbersStrategy);

    private final Messenger messenger = new Messenger();

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cash purchasingCash = inputPurchaseCash();
        List<Lotto> lotteries = purchaseLotteries(purchasingCash);

        WinningLottoNumbers winningLottoNumbers = inputWinningLottoNumbers();

        List<WinStateInformationDTO> winStateInformationDTOs = determineWinStates(winningLottoNumbers, lotteries);
        printWinningStatistics(winStateInformationDTOs);
        printYield(winStateInformationDTOs, purchasingCash);
    }

    private Cash inputPurchaseCash() {
        outputView.print(messenger.getInputPurchaseCashAmountMessage());
        while (true) {
            try {
                int inputValue = inputView.inputNumber();
                lottoShop.validateMaxPurchaseLimit(inputValue);
                return new Cash(inputValue);
            } catch (IllegalArgumentException e) {
                outputView.print(e);
            }
        }
    }

    private List<Lotto> purchaseLotteries(Cash purchasingCash) {
        int lotteriesCount = lottoShop.countPurchasableAmount(purchasingCash.amount());
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

    private WinningLottoNumbers inputWinningLottoNumbers() {

        outputView.print(messenger.getInputWinningNumbersMessage());
        Lotto winningNumbers = inputNumbers();

        outputView.print(messenger.getInputBonusNumberMessage());
        while (true) {
            try {
                LottoNumber bonusNumber = new LottoNumber(inputView.inputNumber());
                return new WinningLottoNumbers(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.print(e);
            }
        }
    }

    private Lotto inputNumbers() {
        while (true) {
            try {
                return new Lotto(inputView.inputNumbers());
            } catch (IllegalArgumentException e) {
                outputView.print(e);
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

    private void printYield(List<WinStateInformationDTO> winStateInformationDTOs, Cash purchasingCash) {
        Prize prize = Prize.from(winStateInformationDTOs);
        double yield = prize.getYield(purchasingCash);
        outputView.print(messenger.getYieldMessage(yield));
    }

}
