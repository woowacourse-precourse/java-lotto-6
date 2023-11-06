package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

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

    public List<Integer> generateRandomNumbers() {
        // 6개의 랜덤숫자 생성
        // 중복검사(조건문)
        return numbers;
    }
}
