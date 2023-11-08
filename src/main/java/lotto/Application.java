package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_ONE_PRICE = 1000;


    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmount();
        int lottoCount = purchaseAmount / LOTTO_ONE_PRICE;

        List<Lotto> lottos = generateLottos(lottoCount);
        printLottos(lottos);

        Lotto winningLotto = inputWinningNumbers();
    }

    private static int inputPurchaseAmount() {
        int purchaseAmount = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                purchaseAmount = Integer.parseInt(Console.readLine());
                isValidInput = checkPurchaseAmount(purchaseAmount);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            }
        }
        return purchaseAmount;
    }

    private static boolean checkPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % LOTTO_ONE_PRICE != 0) {
            System.out.println("[ERROR] 구입금액은 " + LOTTO_ONE_PRICE + "원 단위의 양수여야 합니다.");
            return false;
        }
        return true;
    }
    private static List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    private static Lotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumberStrings = Console.readLine().split(",");
        List<Integer> winningNumbers = Arrays.stream(winningNumberStrings)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (winningNumbers.size() != 6 || new HashSet<>(winningNumbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }

        return new Lotto(winningNumbers);
    }

}
