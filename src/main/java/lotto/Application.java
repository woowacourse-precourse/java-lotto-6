package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {

    public static void alertError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public static int convertInteger(String input) {
        int toValidate;
        try {
            toValidate = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return toValidate;
    }

    public static int inputBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        int input = convertInteger(Console.readLine());
        boolean isNotMultipleOf1000 = input % 1000 != 0;
        if(isNotMultipleOf1000) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static List<Integer> getRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    public static Lotto getRandomLotto() {
        return new Lotto(getRandomLottoNumber());
    }

    public static List<Lotto> buyLottos(int budget) {
        int toBuy = budget / 1000;
        List<Lotto> lottos = IntStream.rangeClosed(1, toBuy)
                .mapToObj(i -> getRandomLotto())
                .toList();
        System.out.println(toBuy + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
        return lottos;
    }

    public static Lotto inputWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        List<Integer> winningNumbers = Arrays.stream(input)
                .map(Application::convertInteger)
                .toList();
        return new Lotto(winningNumbers);
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer input = convertInteger(Console.readLine());
        boolean isNotInLottoNumberRange = input < 1 || 45 < input;
        if(isNotInLottoNumberRange)
            throw new IllegalArgumentException();
        return input;
    }

    public static void main(String[] args) {
        int budget;
        List<Lotto> lottos;
        try {
            budget = inputBudget();
            lottos = buyLottos(budget);
        } catch (IllegalArgumentException e) {
            alertError("로또 구입 금액은 1,000 단위의 숫자여야 합니다.");
        }

        Lotto winningLotto;
        int bonusNumber;
        try {
            winningLotto = inputWinningLotto();
            bonusNumber = inputBonusNumber();
        } catch (IllegalArgumentException e) {
            alertError("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
