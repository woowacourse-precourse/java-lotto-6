package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import lotto.prizeEnum.*;
import lotto.util.*;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;


public class Application {
    public static void main(String[] args) {
//        public enum PrizeMoney {2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000, 0}

        try {
            // 사용자로부터 구입 금액을 입력받음
            int purchaseAmount = readPurchaseAmount();
            // 사용자의 구입 금액 토대로 로또 번호 생성
            List<Lotto> lottos = generateLottos(purchaseAmount);
            printLottos(lottos);

            // 사용자로부터 당첨 번호와 보너스 번호를 입력받음
            Lotto winningLotto = readWinningLotto();
            int bonusNumber = readBonusNumber(winningLotto);

            // 총 상금 계산
            int totalPrize = calculateTotalPrize(lottos, winningLotto, bonusNumber);
            printResult(totalPrize, purchaseAmount, lottos, winningLotto, bonusNumber);

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    // 구입 금액을 토대로 로또 번호를 생성
    private static List<Lotto> generateLottos(int purchaseAmount) {
        int numberOfLotto = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    // 총 상금 계산
    private static int calculateTotalPrize(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {

        return lottos.stream()
                .mapToInt(lotto -> {
                    int matchedNumbers = LottoUtils.countMatchedNumbers(lotto, winningLotto);
                    boolean hasBonusNumber = lotto.containsNumber(bonusNumber);
                    Prize prize = Prize.calculatePrize(matchedNumbers, hasBonusNumber);
                    return prize.getPrizeAmount();
                })
                .sum();
    }
}