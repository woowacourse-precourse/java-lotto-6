package lotto;

import lotto.domain.Customer;
import lotto.domain.Ticket;
import lotto.domain.Manager;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요");
        Manager lottoManager = new Manager();
        int receivedMoney = lottoManager.receiveMoney();

        Customer customer = new Customer(receivedMoney);

        // TODO: 로또 번호 출력
        lottoManager.printTickets(customer.NUMBER_OF_TICKETS);

        // TODO: 로또 당첨 통계 출력

        // TODO: 로또 수익률 출654
    }

}
