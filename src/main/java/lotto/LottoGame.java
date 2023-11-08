package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoGame {
    private List<Integer> winning;
    private final List<Lotto> lottos;
    private int price;
    private int bonus;
    private int lottoCount;
    Map<Integer, Integer> winCount;
    private int sumPrice;

    public LottoGame() {
        winning = new ArrayList<>();
        lottos = new ArrayList<>();
        winCount = new HashMap<>();
        price = 0;
        bonus = 0;
        lottoCount = 0;
        sumPrice = 0;
    }

    public void inputPrice() {
        while (true) {
            try {
                enterPrice();
                makeLottos();
                printLottos();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 잘못된 구입 금액이 입력되었습니다.");
            }
        }
    }

    public void enterPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String inputPrice = Console.readLine();
            inputPrice = deleteSpace(inputPrice);
            price = Integer.parseInt(inputPrice);
            checkNegativePrice();
            setLottoCount();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void checkNegativePrice() {
        if (price < 0) {
            throw new IllegalArgumentException();
        }
    }

    public void setLottoCount() {
        lottoCount = price / 1000;
        checkLottoCount();
    }

    public void checkLottoCount() {
        if (lottoCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto setLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        Lotto lotto;
        lotto = new Lotto(numbers);
        return lotto;
    }

    public void makeLottos() {
        while (lottos.size() < lottoCount) {
            lottos.add(setLotto());
        }
    }

    public void printLottos() {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
        for (Lotto l : lottos) {
            l.printNumbers();
        }
        System.out.println();
    }

    public void inputWinningNumber() {
        while (true) {
            try {
                enterWinningNumber();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 당첨 번호를 잘못 입력하셨습니다.");
                winning = new ArrayList<>();
            }
        }
    }

    public void enterWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winNumber = Console.readLine();
        winNumber = deleteSpace(winNumber);
        checkSpecialCharacter(winNumber);
        String[] numbers = winNumber.split(",");
        for (String number : numbers) {
            checkRangeNumber(Integer.parseInt(number));
            winning.add(Integer.parseInt(number));
        }
        checkWinningLength();
        checkDuplicateWinNumber();
        System.out.println();
    }

    public String deleteSpace(String numbers) {
        return numbers.replaceAll(" ", "");
    }

    public void checkRangeNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    public void checkWinningLength() {
        if (winning.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void checkSpecialCharacter(String name) {
        if (!name.matches("[0-9|,]*")) {
            throw new IllegalArgumentException();
        }
    }

    public void checkDuplicateWinNumber() {
        Set<Integer> numSet = new HashSet<>(winning);
        if (winning.size() != numSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void inputBonusNumber() {
        while (true) {
            try {
                enterBonusNumber();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호를 잘못 입력하셨습니다.");
            }
        }
    }

    public void enterBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            String inputBonus = Console.readLine();
            inputBonus = deleteSpace((inputBonus));
            bonus = Integer.parseInt(inputBonus);
            checkRangeNumber(bonus);
            checkDuplicateBonus();
            System.out.println();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void checkDuplicateBonus() {
        if (winning.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    public void initWinCount() {
        for (int i = 3; i <= 7; i++) {
            winCount.put(i, 0);
        }
    }

    public void calcWin(List<Integer> lotto) {
        int count = 0;
        for (int number : winning) {
            if (lotto.contains(number)) {
                count++;
            }
        }

        if (count == 6) {
            count++;
            winCount.put(count, winCount.get(count) + 1);
            sumPrice += (winningPrice.values()[count - 3].getPrice() * winCount.get(count));
            return;
        }

        if (lotto.contains(bonus)) {
            count++;
        }

        if (count >= 3) {
            winCount.put(count, winCount.get(count) + 1);
            sumPrice += (winningPrice.values()[count - 3].getPrice() * winCount.get(count));
        }
    }

    public void printResult() {
        calcTotalWin();
        printWin();
        printTotal();
    }

    public void calcTotalWin() {
        initWinCount();
        for (Lotto l : lottos) {
            calcWin(l.getNumbers());
        }
    }

    public void printWin() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 3; i <= 7; i++) {
            System.out.printf("%s - %d개\n", winningPrice.values()[i - 3].getInfo(), winCount.get(i));
        }
    }

    public void printTotal() {
        System.out.printf("총 수익률은 %.1f%%입니다.", sumPrice / (double) price * 100);
    }

    public void run() {
        inputPrice();
        inputWinningNumber();
        inputBonusNumber();
        printResult();
    }
}
