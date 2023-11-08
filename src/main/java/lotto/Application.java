package lotto;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.Manager;
import lotto.domain.Prize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요");

        Manager lottoManager = new Manager();
        int receivedMoney = lottoManager.receiveMoney();
        Customer customer = new Customer(receivedMoney);

        List<Lotto> customerTickets = lottoManager.printTickets(customer.NUMBER_OF_TICKETS);

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = lottoManager.setWinningNumbers();
        System.out.println(winningNumbers.toString());
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = lottoManager.setBonusNumber(winningNumbers);

        Prize prize = new Prize();
        HashMap<String, Integer> prizeCountsRecords = prize.compareAllLottoTickets(customerTickets, winningNumbers, bonusNumber);
        prize.printResults(prizeCountsRecords);

        // TODO: 로또 수익률 출654

    }
}
