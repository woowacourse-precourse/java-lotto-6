package lotto.Controller;

import lotto.Domain.Lotto;
import lotto.View.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static final String START_GAME_MSG = "로또 구입 금액을 입력하세요: ";
    private static final String USER_INPUT_MSG_F = "당첨 번호 ";
    private static final String USER_INPUT_MSG_B = "을 입력하세요: ";
    private static final String INPUT_ERROR_MSG_BASIC = "당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INPUT_ERROR_MSG_BONUS = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INPUT_ERROR_MSG_FORMAT = "올바른 숫자를 입력하세요.";

    private LottoView view;

    public LottoController(LottoView view) {
        this.view = view;
    }

    public void runGame() {
        int ticketCount = view.getUserInput(START_GAME_MSG);
        List<Lotto> purchasedTickets = generateTickets(ticketCount);

        List<Integer> winningNumbers = getWinningNumbersFromUser();
        List<String> results = calculatePrizes(purchasedTickets, winningNumbers);
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

    private List<Integer> getWinningNumbersFromUser() {
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            for (int i = 0; i < 7; i++) {
                int number = view.getUserInput(USER_INPUT_MSG_F + (i + 1) + USER_INPUT_MSG_B);
                if (i < 6) {
                    if (number < 1 || number > 45) {
                        view.displayError(INPUT_ERROR_MSG_BASIC);
                        i--;
                    } else {
                        winningNumbers.add(number);
                    }
                } else {
                    if (number < 1 || number > 45) {
                        view.displayError(INPUT_ERROR_MSG_BONUS);
                        i--;
                    } else {
                        winningNumbers.add(number);
                    }
                }
            }
        } catch (NumberFormatException e) {
            view.displayError(INPUT_ERROR_MSG_FORMAT);
        }
        return winningNumbers;
    }

    private List<String> calculatePrizes(List<Lotto> purchasedTickets, List<Integer> winningNumbers) {
        List<String> results = new ArrayList<>();
        for (Lotto lotto : purchasedTickets) {
            int matchingNumbers = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
            boolean hasBonusNumber = lotto.getNumbers().contains(winningNumbers.get(6));
            String result = calculatePrize(matchingNumbers, hasBonusNumber);
            results.add(result);
        }
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

    private String calculatePrize(int matchingNumbers, boolean hasBonusNumber) {
        String result;
        if (matchingNumbers == 6) {
            result = "1등: 6개 번호 일치 - 상금 2,000,000,000원";
        } else if (matchingNumbers == 5 && hasBonusNumber) {
            result = "2등: 5개 번호 + 보너스 번호 일치 - 상금 30,000,000원";
        } else if (matchingNumbers == 5) {
            result = "3등: 5개 번호 일치 - 상금 1,500,000원";
        } else if (matchingNumbers == 4) {
            result = "4등: 4개 번호 일치 - 상금 50,000원";
        } else if (matchingNumbers == 3) {
            result = "5등: 3개 번호 일치 - 상금 5,000원";
        } else {
            result = "꽝: 일치하는 번호 없음";
        }
        return result;
    }
}
