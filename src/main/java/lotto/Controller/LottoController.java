package lotto.Controller;

import lotto.Domain.Lotto;
import lotto.View.LottoView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoController {
    private static final String START_GAME_MSG = "구입금액을 입력해 주세요: ";
    private static final String WINNING_NUMBERS_MSG = "당첨 번호를 쉼표(,)로 구분하여 6개 입력해 주세요: ";
    private static final String BONUS_NUMBER_MSG = "보너스 번호를 입력해 주세요: ";
    private static final String INPUT_ERROR_MSG_BASIC = "당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INPUT_ERROR_MSG_BONUS = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INPUT_ERROR_MSG_FORMAT = "올바른 숫자를 입력해 주세요.";
    private static final int LOTTO_TICKET_PRICE = 1000; // 로또 한 장의 가격


    private LottoView view;

    public LottoController(LottoView view) {
        this.view = view;
    }

    public void runGame() {
        int ticketCount = view.getUserInput(START_GAME_MSG) / LOTTO_TICKET_PRICE;
        List<Lotto> purchasedTickets = generateTickets(ticketCount);
        view.displayPurchasedTickets(purchasedTickets);

        List<Integer> winningNumbers = view.getWinningNumbers();
        validateWinningNumbers(winningNumbers); // 유효성 검사 추가
        int bonusNumber = view.getBonusNumber();
        List<Integer> numbers = new ArrayList<>(winningNumbers);
        numbers.add(bonusNumber);
        validateWinningNumbers(numbers); // 유효성 검사 추가
        List<String> results = calculatePrizes(purchasedTickets, winningNumbers, bonusNumber);
        view.displayResults(results);
    }


    private List<Lotto> generateTickets(int ticketCount) {
        List<Lotto> purchasedTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto randomLotto = Lotto.generateRandomLotto();
            purchasedTickets.add(randomLotto);
        }
        return purchasedTickets;
    }

    private List<String> calculatePrizes(List<Lotto> purchasedTickets, List<Integer> winningNumbers, int bonusNumber) {
        List<String> results = new ArrayList<>();
        int[] prizeCounts = new int[8];

        for (Lotto lotto : purchasedTickets) {
            int matchingNumbers = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
            boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);
            prizeCounts[matchingNumbers]++;

            if (matchingNumbers == 5 && hasBonusNumber) {
                prizeCounts[5]++;
            } else if (matchingNumbers == 6) {
                prizeCounts[6]++;
            }
        }

        results.add("당첨 통계");
        results.add("---");

        String[] prizeMessages = {
                "3개 일치 (5,000원) - ",
                "4개 일치 (50,000원) - ",
                "5개 일치 (1,500,000원) - ",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
                "6개 일치 (2,000,000,000원) - "
        };

        for (int i = 3; i <= 7; i++) {
            int count = prizeCounts[i];
            String message = prizeMessages[i - 3] + count + "개";
            results.add(message);
        }

        double profitRate = ((calculateTotalPrize(prizeCounts) / (purchasedTickets.size() * 1000.0)) * 100);
        results.add("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
        return results;
    }

    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private int getPrizeAmount(int matchingNumbers) {
        int[] prizeAmounts = {0, 0, 0, 5000, 50000, 1500000, 30000000};
        if (matchingNumbers >= 0 && matchingNumbers <= 6) {
            return prizeAmounts[matchingNumbers];
        } else {
            return 0; // 유효하지 않은 인덱스에 대한 처리
        }
    }

    private int calculateTotalPrize(int[] prizeCounts) {
        int totalPrize = 0;
        for (int i = 3; i < prizeCounts.length; i++) {
            totalPrize += getPrizeAmount(i) * prizeCounts[i];
        }
        return totalPrize;
    }

    private void displayGameResults(List<Lotto> purchasedTickets, List<String> results) {
        System.out.println("구입금액을 입력해 주세요.");
        int totalTicketCount = purchasedTickets.size();
        System.out.println(totalTicketCount + "개를 구매했습니다.");

        for (Lotto lotto : purchasedTickets) {
            System.out.println(lotto.getSortedNumbers());
        }
        System.out.println();

        for (String result : results) {
            System.out.println(result);
        }
    }
    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6 || hasDuplicate(numbers)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 1부터 45 사이의 서로 다른 숫자 6개여야 합니다.");
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() < numbers.size();
    }

    private boolean hasDuplicate(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
