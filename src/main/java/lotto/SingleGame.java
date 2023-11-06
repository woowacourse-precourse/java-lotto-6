package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class SingleGame {
    public List<Integer> numbers = new ArrayList<>();
    ;
    public boolean bonus;
    public int rank;
    public int result;
    public int profit;
    public static final int FIRST_PROFIT = 2000000000;
    public static final int SECOND_PROFIT = 30000000;
    public static final int THIRD_PROFIT = 1500000;
    public static final int FOURTH_PROFIT = 50000;
    public static final int FIFTH_PROFIT = 5000;
    private int bonusNumber;

    public void inputLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] inputNumbers;
        inputNumbers = Console.readLine().split(",");
        for (String number : inputNumbers) {
            this.numbers.add(Integer.parseInt(number));
        }
    }

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        this.bonusNumber = Integer.parseInt(Console.readLine());
    }

    public void compareNumbers(List<Integer> user, List<Integer> lotto) {
        this.rank = compareLotto(user, lotto);
        this.bonus = compareBonus(user, this.bonusNumber);
    }

    public int compareLotto(List<Integer> user, List<Integer> lotto) {
        int match = 0;
        for (Integer userNumber : user) {
            if (lotto.contains(userNumber)) {
                match++;
            }
        }
        return match;
    }

    public boolean compareBonus(List<Integer> user, int bonus) {
        return user.contains(bonus);
    }

    public void computeResult(int rank) {
        this.result = 0;
        this.profit = 0;
        if (rank == 6) {
            this.result = 1;
            this.profit = FIRST_PROFIT;
        }
        if (rank == 5 && this.bonus) {
            this.result = 2;
            this.profit = SECOND_PROFIT;
        }
        if (rank == 5) {
            this.result = 3;
            this.profit = THIRD_PROFIT;
        }
        if (rank == 4) {
            this.result = 4;
            this.profit = FOURTH_PROFIT;
        }
        if (rank == 3) {
            this.result = 5;
            this.profit = FIFTH_PROFIT;
        }
    }

    public void setGame() {
        inputLottoNumbers();
        inputBonusNumber();
    }

    public void run(List<Integer> user) {
        Lotto lotto = new Lotto(this.numbers);
        compareNumbers(user, lotto.getNumbers());
        computeResult(this.rank);
    }
}
