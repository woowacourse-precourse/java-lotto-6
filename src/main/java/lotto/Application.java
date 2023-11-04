package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int price = 1000;

    public static int inputLottoAmount() {
        int amount = Integer.parseInt(Console.readLine());
        validateAmount(amount);
        return amount;
    }

    public static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    public static Lotto inputWinningNumbers() {
        List<String> originalNums = new ArrayList<>(Arrays.asList(Console.readLine().split(",")));
        return new Lotto(convertStringToInt(originalNums));
    }

    public static List<Integer> convertStringToInt (List<String> original) {
        List<Integer> convert = new ArrayList<Integer>();
        for (String previous: original){
            int num = Integer.parseInt(previous);
            validateNumber(num);
            convert.add(num);
        }
        return convert;
    }

    public static void validateNumber(int num){
        if (num > 45 || num < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static List<Lotto> generateLottos(int quantity){
        List<Lotto> allLotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++){
            allLotto.add(new Lotto());
        }
        return allLotto;
    }

    public static void printLottos(List<Lotto> allLotto, int quantity) {
        System.out.printf("%d개를 구매했습니다.\n", quantity);
        for (Lotto lotto: allLotto){
            lotto.printNumbers();
        }
    }

    public static List<Integer> compareLottos(List<Lotto> allLotto, Lotto winningLotto) {
        List<Integer> result = new ArrayList<>();
        for (Lotto lotto: allLotto) {
            result.add(lotto.countMatchingNumbers(winningLotto));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = inputLottoAmount();
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningLotto = inputWinningNumbers();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        List<Lotto> allLotto = generateLottos(amount/price);
        printLottos(allLotto, amount/price);
        List<Integer> result = compareLottos(allLotto, winningLotto);
    }
}
