package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMoney {
    private static int inputMoney;
    private static int count;
    private final List<List<Integer>> numbers;

    public LottoMoney(int inputMoney, int count) {
        this.inputMoney = inputMoney;
        this.count = count;
        this.numbers = new ArrayList<>();
    }

    public List<List<Integer>> getNumbers() {
        return numbers;
    }

    public static int getInputMoney() {
        return inputMoney;
    }

    public static int getCount() {
        return count;
    }

    public void setNumbers() {
        for (int i = 0; i < count; i++) {
            List<Integer> randomLotto = new ArrayList<>(getRandomLotto());
            randomLotto.sort((o1, o2) -> o1 - o2);
            numbers.add(randomLotto);
        }
    }

    private List<Integer> getRandomLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
