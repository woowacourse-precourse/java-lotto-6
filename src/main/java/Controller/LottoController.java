package Controller;


import Model.LottoModel;
import Utils.LottoRank;
import Utils.Messages;
import VIew.LottoView;
import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import java.util.*;
import java.util.stream.Collectors;

public class LottoController {

    private final InputManager inputManager;
    private final LottoModel lottoModel;
    private final LottoView lottoView;

    public LottoController(InputManager inputManger) {

        this.inputManager = inputManger;
        this.lottoModel = new LottoModel();
        this.lottoView = new LottoView();
    }

    public void run() {
        inputPaymentAndUpdateModel();
        displayPurchasedLottoTickets();
        updateModelWithWinningNumbers();
        requestAndAddBonusNumber();
        printWinningStatistics();
        displayTotalEarnings();
    }

    private void inputPaymentAndUpdateModel() {
        int payment = inputManager.promptForPayment(Messages.INPUT_MONEY);
        lottoModel.setPayment(payment);
    }

    private void displayPurchasedLottoTickets() {
        int countOfLotto = lottoModel.getCountOfLotto();
        List<Lotto> lottoNumbers = lottoModel.generateLottoTickets();
        lottoView.displayPurchasedLottoTickets(countOfLotto, lottoNumbers);
    }

    private void updateModelWithWinningNumbers() {
        inputManager.displayMessage(Messages.INPUT_WINNING_NUMBERS);
        try {
            Lotto lotto = gettingLottoWinningNumbers(Console.readLine());
            lottoModel.updateWinningLottoNumbers(lotto.getLottoArray());
        } catch (IllegalArgumentException e) {
            lottoView.printMessage(e.getMessage());
            updateModelWithWinningNumbers();
        }
    }


    private void requestAndAddBonusNumber() {
        inputManager.displayMessage(Messages.INPUT_BONUS_NUMBER);
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            lottoModel.validateRange(bonusNumber);
            lottoModel.addBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            lottoView.printMessage(Messages.LottoNumberOutOfRangeException);
            requestAndAddBonusNumber();
        }
    }


    private void printWinningStatistics() {
        Map<LottoRank, Integer> statistics = lottoModel.checkWinningStatistics();
        lottoView.printWinningStatistics(statistics);
    }

    private void displayTotalEarnings() {
        double total = lottoModel.getTotal();
        int payment = lottoModel.getPayment();
        String earningsRateText = calculateAndFormatEarningsRate(total, payment);
        lottoView.printTotalEarnings(earningsRateText);
    }

    private String calculateAndFormatEarningsRate(double total, int payment) {
        double earningsRate = calculateEarningsRate(total, payment);
        return formatEarningsRate(earningsRate);
    }

    private double calculateEarningsRate(double total, int payment) {
        return (total / payment) * 100;
    }

    private String formatEarningsRate(double earningsRate) {
        return String.format("%.1f%%", earningsRate);
    }


    public Lotto gettingLottoWinningNumbers(String lottoNumbers) {
        List<Integer> lottoNumbersArray = Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(lottoNumbersArray);

    }
}
