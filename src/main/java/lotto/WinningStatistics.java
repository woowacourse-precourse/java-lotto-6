package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.messages.LottoInputMessages.COMPLETE_MESSAGE_LOTTO_COST;
import static lotto.UserInputHandler.DIVISION_ROLE;

public class WinningStatistics {
    private final List<Lotto> lottoTickets;
    private final List<Integer> matchingNumber = new ArrayList<>(Collections.nCopies(7, 0));

    public WinningStatistics() {
        this.lottoTickets = new ArrayList<>();
    }

    // 로또 구매
    public long purchaseLottoTickets(long totalAmount) {
        long ticket = totalAmount / DIVISION_ROLE; // 몇 장인지 확인
        System.out.printf(COMPLETE_MESSAGE_LOTTO_COST.getMessage() + "\n", ticket);

        return ticket;
    }

    // 로또 번호 생성 및 저장
    public List<Integer> generateSaveLottoNumbers() {
        Lotto lotto = Lotto.generateLottoNumbers();
        List<Integer> numbers = lotto.getNumbers();
        lottoTickets.add(lotto);

        return numbers;
    }

    // 일치한 갯수 확인
    public void calculateStatistics(List<Integer> winningNumber, int bonusNumber, long userCost) {
        for (Lotto lotto : lottoTickets) {
            calculateMatchingNumbers(lotto, winningNumber, bonusNumber);
        }
    }

    // 일치하는 번호를 확인하는 함수
    public int calculateMatchingNumbers(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int count = 0;
        List<Integer> lottoNumbers = lotto.getNumbers();
        for (int number : lottoNumbers) {
            if (winningNumber.contains(number)) {
                count++;
            }
        }
        matchingNumberSet(lotto, bonusNumber, count);
        return count;
    }

    // 3개 이상 일치하는 경우부터 저장
    private void matchingNumberSet(Lotto lotto, int bonusNumber, int count) {
        if (count >= 3) {
            int currentValue = matchingNumber.get(count);
            matchingNumber.set(count, currentValue + 1);
        }
        // 5개일치 + 보너스번호 일치 확인
        if (count == 5 && lotto.getNumbers().contains(bonusNumber)) {
            int currentValue = matchingNumber.get(count);
            matchingNumber.set(0, currentValue + 1);
        }
    }

    // 이득률 계산
    private double matchingTotal(long userCost) {
        long totalSum = matchingNumber.get(3) * 5_000 +
                matchingNumber.get(4) * 50_000 +
                matchingNumber.get(5) * 1_500_000 +
                matchingNumber.get(6) * 2_000_000_000 +
                matchingNumber.get(0) * 30_000_000;
        return (double) totalSum / userCost * 100;
    }


    public void start() {
        long userCost = getUserCost(); // 로또 구입 금액 입력
        System.out.println();
        long ticket = purchaseLottoTickets(userCost); // 구매한 금액만큼 로또 구입

        generateNumberToTicket(ticket); // 로또 번호 출력
        System.out.println();

        List<Integer> winningNumber = getUserWinningNumber(); // 당첨 번호 입력
        System.out.println();

        int bonusNumber = getUserBonusNumber(); // 보너스 번호 입력
        System.out.println();
        getMatchingNumber(winningNumber, bonusNumber, userCost);
    }

    // 당첨 통계를 계산
    private void getMatchingNumber(List<Integer> winningNumber, int bonusNumber, long userCost) {
        LottoResultPrinter lottoResultPrinter = new LottoResultPrinter();
        calculateStatistics(winningNumber, bonusNumber, userCost);
        double totalSum = matchingTotal(userCost);
        lottoResultPrinter.printResult(matchingNumber, totalSum); // 출력
    }

    private static List<Integer> getUserWinningNumber() {
        UserInputHandler userInputHandler = new UserInputHandler();
        return userInputHandler.inputUserWinningNumbers();
    }

    private static int getUserBonusNumber() {
        UserInputHandler userInputHandler = new UserInputHandler();
        return userInputHandler.inputUserBonusNumber();
    }

    private void generateNumberToTicket(long ticket) {
        LottoResultPrinter lottoResultPrinter = new LottoResultPrinter();

        for (int i = 0; i < ticket; i++) {
            List<Integer> lottoNumbers = generateSaveLottoNumbers();
            lottoResultPrinter.purchaseAllLotto(lottoNumbers); // 출력
        }
    }

    private static long getUserCost() {
        UserInputHandler userInputHandler = new UserInputHandler();
        return userInputHandler.inputUserLottoPurchase();
    }
}
