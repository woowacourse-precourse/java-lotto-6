package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {

    private final int LOTTO_PRICE = 1000;
    private final LottoView lottoView;
    private List<Lotto> purchasedLottos;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void start() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> purchasedLottos = generateLottos(purchaseAmount);
        lottoView.displayPurchasedLottos(purchasedLottos);

        List<Integer> winnerNums = getWinnerNums();
        int bonusNum = getBonusNum();
        List<Integer> results = getResults(purchasedLottos, winnerNums, bonusNum);
        double earningRate = calculateEarningRate(results, purchaseAmount);
        lottoView.printResult(results, earningRate);
    }

    private int getBonusNum() {
        while (true) {
            try {
                int bonusNum = lottoView.getBonusNum();
                if (bonusNum < 1 || bonusNum > 45) {
                    throw new IllegalArgumentException("로또 번호의 숫자 범위는 1~45 입니다.");
                }
                return bonusNum;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] = " + e);
            }
        }
    }

    private List<Integer> getWinnerNums() {
        while (true) {
            try {
                List<Integer> winnerNums = lottoView.getWinnerNums();
                if (winnerNums.stream().distinct().toList().size() != 6) {
                    throw new IllegalArgumentException("당첨 번호는 쉼표로 구분하여 6자리를 입력해야 합니다.");
                }
                for (Integer winnerNum : winnerNums) {
                    if (winnerNum < 1 || winnerNum > 45) {
                        throw new IllegalArgumentException("로또 번호의 숫자 범위는 1~45 입니다.");
                    }
                }
                return winnerNums;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] = " + e);
            }
        }
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                int purchaseAmount = lottoView.getPurchaseAmount();
                if (purchaseAmount <= 0) {
                    throw new IllegalArgumentException("구매 금액은 0보다 큰 값을 입력해야 합니다.");
                }
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] = " + e);
            }
        }
    }

    private List<Lotto> generateLottos(int purchaseAmount) {
        int lottoNum = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<lottoNum; i++) {
            lottos.add(Lotto.create());
        }
        return lottos;
    }

    private static List<Integer> getResults(List<Lotto> purchasedLottos, List<Integer> winnerNums, int bonusNum) {
        List<Integer> results = new ArrayList<>(Collections.nCopies(Result.values().length, 0));
        for (Lotto lotto : purchasedLottos) {
            Result result = lotto.match(winnerNums, bonusNum);
            int idx  = result.ordinal();
            results.set(idx, results.get(idx) + 1);
        }
        return results;
    }

    private double calculateEarningRate(List<Integer> results, int purchaseAmount) {
        double totalEarning = 0;
        for (Result result : Result.values()) {
            totalEarning += results.get(result.ordinal()) * result.getEarnings();
        }
        return (totalEarning / purchaseAmount) * 100;
    }
}
