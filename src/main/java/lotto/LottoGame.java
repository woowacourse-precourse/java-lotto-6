package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {

    public static void run() {
        int purchaseAmount = getValidPurchaseAmount();
        System.out.println();
        List<Lotto> lottos = generateLottos(purchaseAmount);
        showLottos(lottos);
        System.out.println();
        List<Integer> winningNumbers = getWinningNumbersFromUser();
    }

    private static int getValidPurchaseAmount() {
        int purchaseAmount = 0;

        do {
            int inputAmount = 0;
            try {
                inputAmount = getPurchaseAmountFromUser();
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해야 합니다.");
                continue; // Restart the loop if there's an exception
            }

            if (inputAmount % 1000 != 0) {
                System.out.println("[ERROR] 1,000원 단위로 입력해야 합니다.");
            } else if (inputAmount == 0) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } else {
                purchaseAmount = inputAmount;
            }
        } while (purchaseAmount == 0);

        return purchaseAmount;
    }
    private static int getPurchaseAmountFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static List<Lotto> generateLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
    private static void showLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto));
    }

    private static List<Integer> getWinningNumbersFromUser() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split(",");
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
