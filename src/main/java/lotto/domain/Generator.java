package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Generator {
    Printer printer = new Printer();

    //상수(static final) 또는 클래스 변수
    static final List<Lotto> lottos = new ArrayList<>();
    private final int LOTTERY_COST = 1000;
    private static int MONEY;
    private static int NUMBER_OF_LOTTERY;

    //인스턴스 변수

    //생성자

    //메서드
    int getMoney() {
        return MONEY;
    }

    public List<Lotto> getAmountOfMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        while(true) {
            try {
                MONEY = validateCorrectFormat();
                NUMBER_OF_LOTTERY = calculateTheNumberOfLottery(MONEY);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return createLotto();
    }

    private int calculateTheNumberOfLottery(int money) {
        validateDivisible(money);
        return MONEY / LOTTERY_COST;
    }

    private List<Lotto> createLotto() {
        printer.showLotteryCount(NUMBER_OF_LOTTERY);
        while(lottos.size() != NUMBER_OF_LOTTERY) {
            Lotto generatedLotto = new Lotto(generateRandomNumbers());
            lottos.add(generatedLotto);
        }
        return lottos;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = pickUniqueNumbersInRange(1, 45, 6);
        return randomNumbers;
    }

    private int validateCorrectFormat() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private void validateDivisible(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해주세요.");
        }
        if (money % LOTTERY_COST != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
