package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Generator {
    //상수(static final) 또는 클래스 변수
    private final int LOTTERY_COST = 1000;

    //인스턴스 변수
    private int numberOfLottery;
    private List<Integer> numbers;
    private List<Lotto> Lottos = new ArrayList<>();

    //생성자

    //메서드
    public int getAmountOfMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        while(true) {
            try {
                int money = isCorrectFormat();
                numberOfLottery = isDivisible(money);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return numberOfLottery;
    }

    private int isDivisible(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해주세요.");
        }
        if (money % LOTTERY_COST != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return money % LOTTERY_COST;
    }

    private int isCorrectFormat() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public void createLotto(int numberOfLottery) {
        while(Lottos.size() != numberOfLottery) {
            Lottos.add(new Lotto(generateRandomNumbers()));
        }
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = pickUniqueNumbersInRange(1, 45, 6);
        return randomNumbers;
    }
}
