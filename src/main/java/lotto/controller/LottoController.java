package lotto.controller;

import lotto.LottoWinningCase;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.ErrorMessage.ERROR_INTRO;

public class LottoController {
    private LottoService lottoService = new LottoService();
    private Money mySpentAmount;
    private List<Lotto> myLottoTickets = new ArrayList<>();
    private Lotto winningLottoNumber;
    private BonusNumber bonusNumber;
    private Map<LottoWinningCase, Integer> winStatisticMap = new HashMap<>();
    private Integer totalIncome;
    private String incomeRate;
    private Integer process;

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
        process = 0;
        while(true){
            try {
                savePurchaseAmount();
                generateAndSaveRandomNumber();
                saveWinningNumber();
                saveBonusNumber();
                performNumberComparisonLogic();
                printWinningStatistics();
                break;
            } catch (NumberFormatException e) {
                System.out.println(ERROR_INTRO + e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println(ERROR_INTRO + e.getMessage());
            }
        }
    }

    private void savePurchaseAmount() {
        if (process != 0) return;
        mySpentAmount = new Money(InputView.receiveSpentAmount());
        process++;
    }

    private void generateAndSaveRandomNumber() {
        if (process != 1) return;
        int availableNumberOfLotteryTickets = lottoService.calculateAvailableNumberOfLotteryTickets(mySpentAmount.getSpendAmount());
        myLottoTickets = lottoService.generateRandomLottoNums(availableNumberOfLotteryTickets);

        OutputView.printTicketAmountAndEachRandomNumbers(availableNumberOfLotteryTickets, myLottoTickets);
        process++;
    }

    private void saveWinningNumber() {
        if (process != 2) return;
        winningLottoNumber = lottoService.reshapeWinningNumber(InputView.receiveWinningNumber());
        process++;
    }

    private void saveBonusNumber() {
        if (process != 3) return;
        bonusNumber = new BonusNumber(InputView.receiveBonusNumber(), winningLottoNumber.getNumbers());
        process++;
    }

    private void performNumberComparisonLogic() {
        if (process != 4) return;
        initWinStatisticMap();
        for (Lotto myLottoTicket : myLottoTickets) {
            LottoWinningCase lottoWinningCase = lottoService.compareMyNumberWithWinningNumber(myLottoTicket, winningLottoNumber.getNumbers(), bonusNumber.getBonusNumber());
            Integer prevCaseCount = winStatisticMap.get(lottoWinningCase);
            winStatisticMap.put(lottoWinningCase, prevCaseCount + 1);
        }
        totalIncome = lottoService.calculateTotalIncome(winStatisticMap);
        incomeRate = lottoService.calculateIncomeRate(totalIncome, mySpentAmount.getSpendAmount());
        process++;
    }

    private void initWinStatisticMap() {
        LottoWinningCase[] lottoWinningCases = LottoWinningCase.values();
        for (LottoWinningCase lottoWinningCase : lottoWinningCases) {
            winStatisticMap.put(lottoWinningCase, 0);
        }
    }

    private void printWinningStatistics() {
        if (process != 5) return;
        OutputView.printWinningStatistics(winStatisticMap, incomeRate);
    }

}
