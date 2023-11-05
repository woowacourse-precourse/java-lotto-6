package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        Integer userPurchaseAmount = Integer.parseInt(Console.readLine());

        System.out.println();
        int numberOfLottos = userPurchaseAmount / 1000;
        System.out.println(numberOfLottos + "개를 구매했습니다.");

        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            sortedNumbers.sort(Comparator.naturalOrder());
            System.out.println(sortedNumbers);
            purchasedLottos.add(lotto);
        }

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        LottoResult lottoResult = new LottoResult();
        for (Lotto purchasedLotto : purchasedLottos) {
            WinningCriteria criteria = getWinningCriteria(purchasedLotto, winningNumber, bonusNumber);
            if (criteria != null) {
                lottoResult.addWin(criteria);
            }
        }

        int totalPrice = lottoResult.getCount(WinningCriteria.FIFTH_PLACE) * 5_000 +
                lottoResult.getCount(WinningCriteria.FOURTH_PLACE) * 50_000 +
                lottoResult.getCount(WinningCriteria.THIRD_PLACE) * 1_500_000 +
                lottoResult.getCount(WinningCriteria.SECOND_PLACE) * 30_000_000 +
                lottoResult.getCount(WinningCriteria.FIRST_PLACE) * 2_000_000_000;
        double totalReturn = ((double) totalPrice / (double) userPurchaseAmount) * 100.0;

        double roundedReturn = Math.round(totalReturn * 10.0) / 10.0;

    }

    private static WinningCriteria getWinningCriteria(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int matchCount = lotto.countMatches(winningNumber);
        boolean bonus = lotto.additionalNumber(bonusNumber);
        if (matchCount == 6) return WinningCriteria.FIRST_PLACE;
        if (matchCount == 5 && bonus) return WinningCriteria.SECOND_PLACE;
        if (matchCount == 5) return WinningCriteria.THIRD_PLACE;
        if (matchCount == 4) return WinningCriteria.FOURTH_PLACE;
        if (matchCount == 3) return WinningCriteria.FIFTH_PLACE;

        return null;
    }
}
