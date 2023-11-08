package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Purchase {
    String purchaseMoney;
    int purchaseM;

    public Purchase(String purchaseMoney) {
        notNumber(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    public int getPurchaseMoney() {
        this.purchaseM = Integer.parseInt(purchaseMoney);
        return purchaseM;
    }

    public List[] automaticNum(int ticketNumber) {
        List[] allTickets = new List[ticketNumber];
        for (int i = 0; i < ticketNumber; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Comparator.naturalOrder());
            allTickets[i] = numbers;
            System.out.println(numbers);
        }
        return allTickets;
    }

    public void notNumber(String purchaseMoney) {
        for (int i = 0; i < purchaseMoney.length(); i++) {
            char ch = purchaseMoney.charAt(i);
            if (ch < 48 || ch > 57) {
                throw new IllegalArgumentException("[ERROR]");
            }
        }
    }

    public int numberOfTickets(int money) {
        int ticketNumber = money / 1000;
        System.out.printf("\n%d개를 구매했습니다.%n", ticketNumber);
        return ticketNumber;
    }
}
