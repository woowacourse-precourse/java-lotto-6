package lotto.View;

import lotto.Domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoView {
    private Scanner scanner = new Scanner(System.in);

    public int getUserInput(String message) {
        int userInput = 0;
        while (true) {
            try {
                System.out.print(message);
                userInput = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                displayError("올바른 숫자를 입력하세요.");
            }
        }
        return userInput;
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        while (winningNumbers.size() < 6) {
            try {
                System.out.print("당첨 번호를 쉼표(,)로 구분하여 6개 입력해 주세요: ");
                String input = scanner.nextLine();
                String[] numberStrings = input.split(",");
                if (numberStrings.length != 6) {
                    displayError("6개의 번호를 입력하세요.");
                    continue;
                }
                winningNumbers.clear();
                for (String numberString : numberStrings) {
                    int number = Integer.parseInt(numberString);
                    if (number < 1 || number > 45) {
                        displayError("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
                        winningNumbers.clear();
                        break;
                    } else {
                        winningNumbers.add(number);
                    }
                }
            } catch (NumberFormatException e) {
                displayError("올바른 숫자를 입력하세요.");
            }
        }
        return winningNumbers;
    }

    public int getBonusNumber() {
        int bonusNumber = 0;
        while (true) {
            try {
                System.out.print("보너스 번호를 입력해 주세요: ");
                bonusNumber = Integer.parseInt(scanner.nextLine());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    displayError("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                displayError("올바른 숫자를 입력하세요.");
            }
        }
        return bonusNumber;
    }

    public void displayPurchasedTickets(List<Lotto> tickets) {
        int totalPrice = tickets.size() * 1000;
        System.out.println(totalPrice + "원으로 " + tickets.size() + "개를 구매했습니다.");

        for (Lotto ticket : tickets) {
            List<Integer> sortedNumbers = ticket.getSortedNumbers();
            System.out.println(sortedNumbers);
        }
    }

    public void displayResults(List<String> results) {
        System.out.println("당첨 결과 및 수익률:");
        for (String result : results) {
            System.out.println(result);
        }
    }

    public void displayError(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
