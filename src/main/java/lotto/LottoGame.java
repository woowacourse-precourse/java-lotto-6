package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class LottoGame {
    public static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public void start() {
        try {
            int purchaseAmount = getPurchaseAmount();
            int lottoCount = calculateLottoCount(purchaseAmount);

            List<Lotto> lottos = generateLottos(lottoCount);
            printPurchasedLottos(lottos);

            Lotto winningLotto = getWinningLotto();
            int bonusNumber = getBonusNumber();

            LottoResult lottoResult = new LottoResult(winningLotto, bonusNumber, lottos);
            printLottoResult(lottoResult);
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private Lotto getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(winningNumbers);
    }

    private int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private void printLottoResult(LottoResult lottoResult) {
        lottoResult.printResult();
    }

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.start();
    }

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }
}
