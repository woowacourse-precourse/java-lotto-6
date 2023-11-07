package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class User {

    private final List<Lotto> lottoTickets = new ArrayList<>();
    private int money;

    public int getMoney() {
        return money;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public void inputMoney() {
        while (true) {
            try {
                this.money = inputMoneyValidation(Console.readLine());
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    private int inputMoneyValidation(String inputMoney) {
        int money = parseToNumber(inputMoney);
        if (money % 1000 != 0 || money == 0)
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 다시 입력하여 주세요 입력 값 = " + money);

        return money;
    }

    private int parseToNumber(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다. 다시 입력하여 주세요");
        }
    }

    public void createLottoTickets() {
        int buyCount = money / 1000;

        IntStream.range(0, buyCount).forEach(i -> {
            List<Integer> randomNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoTickets.add(new Lotto(randomNums));
        });
    }

    public double getRevenue(int gain) {
        return (double) gain / money * 100;
    }

}
