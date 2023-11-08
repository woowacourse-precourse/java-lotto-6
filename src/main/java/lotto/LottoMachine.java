package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMachine {
    private List<Integer> WinningNum;
    private int bonus;
    private int maxLotto;
    private List<Lotto> lottos;
    private int[] corrects;

    public void run() {
        corrects = new int[5];
        User user = new User();
        user.insertAmount();
        decideMaxLotto(user);
        insertWinningNum();
        insertBonus();
        validateLotto(lottos, WinningNum, bonus);
        CorrectInfo();
        user.saveTotalPrize(corrects);
        user.saveRate(user.getTotalPrize());
        RateInfo(user);
    }

    public void decideMaxLotto(User user) {
        int userAmount = user.getAmount();
        this.maxLotto = userAmount / 1000;
        LottoInfo();
    }

    public void LottoInfo() {
        System.out.printf("%d개를 구매했습니다.\n", this.maxLotto);
        lottery();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void lottery() {
        lottos = new ArrayList<>(maxLotto);
        for (int i = 0; i < maxLotto; i++) {
            lottos.add(new Lotto(generateLottoNum()));
        }
    }

    public List<Integer> generateLottoNum() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        validateNumbers(numbers);
        return numbers;
    }

    public void validateNumbers(List<Integer> numbers) {
        Set<Integer> duplicationNumbers = new HashSet<>(numbers);
        if (duplicationNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void insertWinningNum() {
        WinningNum = new ArrayList<>(6);
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String Winning = Console.readLine();
                String[] numbers = parseNumbers(Winning);
                saveWinningNum(numbers);
                System.out.println();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] ,로 이어진 6자리를 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }
    }

    public String[] parseNumbers(String Numbers) throws IllegalArgumentException {
        try {
            String[] numbers = Numbers.split(",");
            return numbers;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public boolean saveWinningNum(String[] numbers) {
        for (String num : numbers) {
            this.WinningNum.add(Integer.parseInt(num));
        }
        return true;
    }

    public void insertBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                this.bonus = Integer.parseInt(Console.readLine());
                System.out.println();
                return;
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateLotto(List<Lotto> lottos, List<Integer> WinningNum, int bonus) {
        for (Lotto lotto : lottos) {
            validateLottoWithWinningNum(lotto, WinningNum, bonus);
        }
    }

    public void validateLottoWithWinningNum(Lotto lotto, List<Integer> WinningNum, int bonus) {
        Set<Integer> lotto1 = new HashSet<>(lotto.getNumbers());
        Set<Integer> WinningNum1 = new HashSet<>(WinningNum);
        WinningNum1.retainAll(lotto1);
        int matchingNumbers = WinningNum1.size();
        if (matchingNumbers == 5) {
            if (validateLottoWithBonus(lotto1, bonus)) {
                return;
            }
        }
        if (matchingNumbers >= 3) {
            validateMatchingNumbers(matchingNumbers);
        }
    }

    public boolean validateLottoWithBonus(Set<Integer> lotto1, int bonus) {
        if (lotto1.contains(bonus)) {
            int tmp = corrects[3];
            corrects[3] = ++tmp;
            return true;
        }
        return false;
    }

    public void validateMatchingNumbers(int matchingNumbers) {
        for (Prize prize : Prize.values()) {
            if (prize.getMatchingNumbers() == matchingNumbers) {
                int index = prize.getIndex();
                int tmp = corrects[index];
                corrects[index] = ++tmp;
                return;
            }
        }
    }

    public void CorrectInfo() {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", corrects[0]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", corrects[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", corrects[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", corrects[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", corrects[4]);
    }

    public void RateInfo(User user) {
        double rate = user.getRate();
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
    }

}
