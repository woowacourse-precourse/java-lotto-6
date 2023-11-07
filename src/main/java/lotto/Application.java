package lotto;

import lotto.domain.Customer;
import lotto.domain.Manager;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요");

        Manager lottoManager = new Manager();
        int receivedMoney = lottoManager.receiveMoney();
        Customer customer = new Customer(receivedMoney);

        lottoManager.printTickets(customer.NUMBER_OF_TICKETS);

        // TODO: 당첨 번호, 보너스 번호 입력
        List<Integer> winningNumbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbers = lottoManager.setWinningNumbers();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = lottoManager.setBonusNumber();

        // TODO: 로또 당첨 통계 출력

        // TODO: 로또 수익률 출654

    }
}
