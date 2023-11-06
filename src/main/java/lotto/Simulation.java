package lotto;

import java.util.List;

public class Simulation {

    private final WinningStatistics winningStatistics;
    private final UserInputHandler userInputHandler;
    private final LottoResultPrinter lottoResultPrinter;

    public Simulation(WinningStatistics winningStatistics, UserInputHandler userInputHandler, LottoResultPrinter lottoResultPrinter) {
        this.winningStatistics = winningStatistics;
        this.userInputHandler = userInputHandler;
        this.lottoResultPrinter = lottoResultPrinter;
    }

    public void start() {
        long userCost = getUserCost(); // 로또 구입 금액 입력
        System.out.println();
        long ticket = winningStatistics.purchaseLottoTickets(userCost); // 구매한 금액만큼 로또 구입

        generateNumberToTicket(ticket); // 로또 번호 출력
        System.out.println();

        List<Integer> winningNumber = getUserWinningNumber(); // 당첨 번호 입력
        System.out.println();

        int bonusNumber = getUserBonusNumber(); // 보너스 번호 입력
        System.out.println();
        getMatchingNumber(winningNumber, bonusNumber, userCost);
    }

    // 당첨 통계 계산
    private void getMatchingNumber(List<Integer> winningNumber, int bonusNumber, long userCost) {
        winningStatistics.calculateStatistics(winningNumber, bonusNumber, userCost);
        double totalSum = winningStatistics.matchingTotal(userCost);
        lottoResultPrinter.printResult(winningStatistics.getMatchingNumber(), totalSum); // 출력
    }

    private List<Integer> getUserWinningNumber() {
        return userInputHandler.inputUserWinningNumbers();
    }

    private int getUserBonusNumber() {
        return userInputHandler.inputUserBonusNumber();
    }

    private void generateNumberToTicket(long ticket) {
        for (int i = 0; i < ticket; i++) {
            List<Integer> lottoNumbers = winningStatistics.generateSaveLottoNumbers();
            lottoResultPrinter.purchaseAllLotto(lottoNumbers); // 출력
        }
    }

    private long getUserCost() {
        return userInputHandler.inputUserLottoPurchase();
    }
}