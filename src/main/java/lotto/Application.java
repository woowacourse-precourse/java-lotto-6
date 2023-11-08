package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Manager lottoManager = new Manager();

        System.out.println("구입금액을 입력해 주세요");
        String inputMoney = Console.readLine().trim();
        boolean passed = Validators.validateMoney(inputMoney);
        while (!passed) {
            System.out.println("구입금액을 입력해 주세요");
            inputMoney = Console.readLine().trim();
            passed = Validators.validateMoney(inputMoney);
        }
        int receivedMoney = Integer.parseInt(inputMoney);

        Customer customer = new Customer(receivedMoney);
        List<Lotto> customerTickets = lottoManager.printTickets(customer.numberOfTickets);

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new ArrayList<>();
        String inputWinningNumbers = Console.readLine().trim();
        boolean passedWinning = Validators.validateWinningNumbers(inputWinningNumbers);
        while (!passedWinning) {
            passedWinning = Validators.validateWinningNumbers(inputWinningNumbers);
            inputWinningNumbers = Console.readLine();
        }
        winningNumbers = lottoManager.setWinningNumbers(inputWinningNumbers, winningNumbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = 0;
        boolean passedBonus = false;
        while (!passedBonus) {
            String inputBonusNumber = Console.readLine().trim();
            try {
                bonusNumber = Integer.parseInt(inputBonusNumber);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                continue;
            }
            passedBonus = Validators.validateBonusNumber(bonusNumber, winningNumbers);
            if (!passedBonus) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

        HashMap<String, Integer> prizeCountsRecords = Prize.compareAllLottoTickets(customerTickets, winningNumbers, bonusNumber);
        Prize.printResults(prizeCountsRecords);

        double rateOfReturn = customer.getRateOfReturn(prizeCountsRecords, receivedMoney);
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);

    }
}
