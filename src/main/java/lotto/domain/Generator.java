package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    //상수(static final) 또는 클래스 변수
    private final int LOTTERY_COST = 1000;

    //인스턴스 변수
    private int numberOfLottery;
    private List<Integer> numbers;
    private List<Lotto> Lottos = new ArrayList<>();

    //생성자

    //메서드
    public int getAmountOfMoney(int money) {
        // 1000으로 나누어 떨어지지 않으면 예외를 던짐
        return numberOfLottery = money / LOTTERY_COST;
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
