package lotto.controller;

import lotto.LottoWinningCase;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.ErrorMessage.ERROR_INTRO;

public class LottoController {
    private LottoService lottoService = new LottoService();
    private Money mySpentAmount;
    private List<Lotto> myLottoTickets;
    private List<Integer> winningLottoNumber;
    private BonusNumber bonusNumber;
    private Map<LottoWinningCase, Integer> winStatisticMap = new HashMap<>();
    private Integer totalIncome;
    private String incomeRate;

    /*
     * run() {
     *    구입 금액 입력 및 저장(); savePurchaseAmount();
     *    랜덤 번호 생성 및 저장(); generateAndSaveRandomNumber();
     *    당첨 번호 입력 및 저장(); saveWinningNumber();
     *    보너스 번호 입력 및 저장(); saveBonusNumber();
     *    내 번호와 당첨 번호 비교 로직 수행(); performNumberComparisonLogic();
     *    당첨 통계 출력(); printWinningStatistics();
     * }
     * */

    public void run() {
        try{
            savePurchaseAmount();
            generateAndSaveRandomNumber();
            saveWinningNumber();
            saveBonusNumber();
            performNumberComparisonLogic();
            printWinningStatistics();
        } catch (Exception e) {
            System.out.println(ERROR_INTRO + e.getMessage());
        }
    }

    private void savePurchaseAmount() {
        mySpentAmount = new Money(InputView.receiveSpentAmount());
    }

    private void generateAndSaveRandomNumber() {
        int availableNumberOfLotteryTickets = lottoService.calculateAvailableNumberOfLotteryTickets(mySpentAmount.getSpendAmount());
        myLottoTickets = lottoService.generateRandomLottoNums(availableNumberOfLotteryTickets);

        OutputView.printTicketAmountAndEachRandomNumbers(availableNumberOfLotteryTickets, myLottoTickets);
    }

    private void saveWinningNumber() {
        winningLottoNumber = lottoService.reshapeWinningNumber(InputView.receiveWinningNumber());
    }
    private void saveBonusNumber() {
        bonusNumber = new BonusNumber(InputView.receiveBonusNumber(), winningLottoNumber);
    }
    private void performNumberComparisonLogic() {
        initWinStatisticMap();
        for (Lotto myLottoTicket : myLottoTickets) {
            LottoWinningCase lottoWinningCase = lottoService.compareMyNumberWithWinningNumber(myLottoTicket, winningLottoNumber, bonusNumber.getBonusNumber());
            Integer prevCaseCount = winStatisticMap.get(lottoWinningCase);
            winStatisticMap.put(lottoWinningCase, prevCaseCount+1);
        }
        totalIncome = lottoService.calculateTotalIncome(winStatisticMap);
        incomeRate = lottoService.calculateIncomeRate(totalIncome, mySpentAmount.getSpendAmount());
    }

    private void initWinStatisticMap() {
        LottoWinningCase[] lottoWinningCases = LottoWinningCase.values();
        for (LottoWinningCase lottoWinningCase : lottoWinningCases) {
            winStatisticMap.put(lottoWinningCase, 0);
        }
    }

    private void printWinningStatistics() {
        OutputView.printWinningStatistics(winStatisticMap, incomeRate);
    }

}
