package lotto;

import lotto.domain.Customer;
import lotto.domain.Manager;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Prize;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요");

        Manager lottoManager = new Manager();
        int receivedMoney = lottoManager.receiveMoney();
        Customer customer = new Customer(receivedMoney);

        List<Lotto> customerTickets = lottoManager.printTickets(customer.NUMBER_OF_TICKETS);

        // TODO: 당첨 번호, 보너스 번호 입력
        List<Integer> winningNumbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbers = lottoManager.setWinningNumbers();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = lottoManager.setBonusNumber(winningNumbers);

        // TODO: 로또 당첨 통계 출력
        Prize.printResults(customerTickets, winningNumbers, bonusNumber);


        // TODO: 로또 수익률 출654

    }
}
