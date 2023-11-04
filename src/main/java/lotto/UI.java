package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UI {
    public String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String line = readLine();
        System.out.println();
        return line;
    }

    public void printPurchases(List<Lotto> lottos) {
        System.out.println("8개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
        System.out.println();
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.print("[");
        for (int i = 0; i < Lotto.size; i++) {
            System.out.print(numbers.get(i));
            if (i < Lotto.size - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        String line = readLine();
        System.out.println();
        String[] split = line.split(",");
        List<Integer> numbers = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
        return numbers;
    }


}
