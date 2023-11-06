package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Customer;
import lotto.domain.Ticket;
import lotto.domain.Manager;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요");
        int receivedMoney = Manager.receiveMoney();

        Customer customer = new Customer(receivedMoney);
        System.out.println(customer);
    }

}
