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

    private final PickNumbersStrategy pickNumbersStrategy = new PickRandomNumbersStrategy();
    private final LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator(pickNumbersStrategy);

    private final LottoShop lottoShop = new LottoShop();

    private final Messenger messenger = new Messenger();

    private Cash purchaseCash;
    private WinningLottoNumbers winningLottoNumbers;
    private List<Lotto> lotteries;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        purchaseLotteries();
        inputWinningLottoNumbers();
        printResult();
    }

    private void purchaseLotteries() {
        outputView.print(messenger.getInputPurchaseCashAmountMessage());
        while (true) {
            try {
                purchaseCash = new Cash(inputView.inputNumber());
                int lotteriesCount = lottoShop.countPurchasableAmount(purchaseCash.amount());
                outputView.print(messenger.getPurchasedLotteriesCountMessage(lotteriesCount));
                generateLotteries(lotteriesCount);
                return;
            } catch (IllegalArgumentException e) {
                outputView.print(e);
            }
        }
    }

    private void generateLotteries(int count) {
        List<LottoNumbersDTO> lottoNumbersDTOs = lottoNumbersGenerator.generateByCount(count);
        outputView.print(messenger.getLotteriesNumbersMessage(lottoNumbersDTOs));
        lotteries = lottoNumbersDTOs.stream()
                .map(LottoNumbersDTO::numbers)
                .map(Lotto::new)
                .toList();
    }

    private void inputWinningLottoNumbers() {

        outputView.print(messenger.getInputWinningNumbersMessage());
        Lotto winningNumbers = inputNumbers();

        outputView.print(messenger.getInputBonusNumberMessage());
        while (true) {
            try {
                LottoNumber bonusNumber = new LottoNumber(inputView.inputNumber());
                winningLottoNumbers = new WinningLottoNumbers(winningNumbers, bonusNumber);
                return;
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

    private void printResult() {
        WinStatesCounter winStatesCounter = new WinStatesCounter(winningLottoNumbers, lotteries);
        List<WinStateInformationDTO> winStateInformationDTOs = winStatesCounter.getWinStateInformationDTOs();
        printWinningStatistics(winStateInformationDTOs);
        printYield(winStateInformationDTOs);
    }

    private void printWinningStatistics(List<WinStateInformationDTO> winStateInformationDTOs) {
        outputView.print(messenger.getWinningStatisticStartMessage());
        outputView.print(messenger.getWinningStatisticsInformationMessage(winStateInformationDTOs));
    }

    private void printYield(List<WinStateInformationDTO> winStateInformationDTOs) {
        Prize prize = Prize.from(winStateInformationDTOs);
        double yield = prize.getYield(purchaseCash);
        outputView.print(messenger.getYieldMessage(yield));
    }

}
