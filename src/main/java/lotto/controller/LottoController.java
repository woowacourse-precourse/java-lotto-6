package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.dto.LottoDto;
import lotto.model.WinningStatistics;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoDto lottoDto;
    private LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoDto lottoDto) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoDto = lottoDto;
        setUp();
    }

    private void setUp() {
        lottoDto.setLottoTickets(new ArrayList<>());
        lottoDto.setWinningStatistics(new HashMap<>());
        this.lottoService = new LottoService(
                lottoDto.getLottoTickets(),
                new WinningStatistics(lottoDto.getWinningStatistics())
        );
    }

    public void play() {
        prepare();
        drawLots();
        printResult();
    }

    private void prepare() {
        storePurchaseAmount();
        int lottoCount = getLottoCount();
        lottoService.getLottoList(lottoCount);
        printPurchaseLottoTickets(lottoCount);
        storeWinningNumbers();
        storeBonusNumber();
    }

    private void storePurchaseAmount() {
        boolean isValid = false;
        while (!isValid) {
            try {
                outputView.printPurchaseAmountInputMessage();
                Integer purchaseAmount = inputView.readPurchaseAmount();
                lottoDto.setPurchaseAmount(purchaseAmount);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private int getLottoCount() {
        return lottoDto.getPurchaseAmount() / 1000;
    }

    private void printPurchaseLottoTickets(int lottoCount) {
        outputView.printLottoCount(lottoCount);
        outputView.printLottoTickets(lottoDto.getLottoTickets());
    }

    private void storeWinningNumbers() {
        boolean isValid = false;
        while (!isValid) {
            try {
                outputView.printWinningNumbersInputMessage();
                List<Integer> winningNumbers = inputView.readWinningNumbers();
                lottoDto.setWinningNumbers(winningNumbers);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void storeBonusNumber() {
        boolean isValid = false;
        while (!isValid) {
            try {
                outputView.printBonusNumberInputMessage();
                Integer bonusNumber = inputView.readBonusNumber();
                lottoDto.setBonusNumber(bonusNumber);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void drawLots() {
        lottoService.getResult(lottoDto.getWinningNumbers(), lottoDto.getBonusNumber());
        String totalYield = lottoService.calculateTotalYield(lottoDto.getPurchaseAmount());
        lottoDto.setTotalYield(totalYield);
    }

    private void printResult() {
        outputView.printWinningStatistics(lottoDto.getWinningStatistics());
        outputView.printTotalYield(lottoDto.getTotalYield());
    }
}
