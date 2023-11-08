package lotto.machine.game;

import lotto.Lotto;
import lotto.machine.ui.UI;
import lotto.machine.util.random.RandomsProvider;

import java.util.*;

public class LottoGameMachine implements LottoGameMachineInterface {
    private final UI ui;
    private final RandomsProvider randomsProvider;

    private List<Integer> winningNumbers;
    private int purchaseAmount;
    private int bonusNumber;

    public LottoGameMachine(UI ui, RandomsProvider randomsProvider) {
        this.ui = ui;
        this.randomsProvider = randomsProvider;
    }

    @Override
    public void run() {

        // 당첨 Lotto
        Lotto winningLotto;

        // 구매
        ui.requirePurchaseView();
        inputPurchaseNumberIncludeValidate();

        // 가격만큼 Lotto 구매
        int count = purchaseAmount / 1000;
        List<Lotto> byingLottos = buyLottos(count);

        // 구매 내역
        ui.outputPurchaseLottoNumbers(byingLottos);

        // 당첨 번호 입력
        ui.requireWinningNumbers();
        inputWinningNumbersIncludeValidate();

        // 번호를 Lotto로 전환
        winningLotto = new Lotto(winningNumbers);

        // 보너스 번호 입력
        ui.requireBonusNumber();
        inputBonusNumberIncludeValidate();

        // 당첨 결과
        Map<Integer, Integer> winningCountsByRank = findWinningCountsByRank(winningLotto, bonusNumber, byingLottos);

        // SUM 계산
        long sum = winningCountsByRank.get(6) * 5000 +
                winningCountsByRank.get(8) * 50000 +
                winningCountsByRank.get(10) * 1500000 +
                winningCountsByRank.get(11) * 30000000 +
                (long) winningCountsByRank.get(12) * 2000000000;

        double rateOfReturn = Math.round((double) sum / purchaseAmount * 100 * 100) / 100.0;



        // 당첨 결과에 따라 UI 제공 - 가중치를 이용
        ui.outputGameResult(
                winningCountsByRank.get(6),
                winningCountsByRank.get(8),
                winningCountsByRank.get(10),
                winningCountsByRank.get(11),
                winningCountsByRank.get(12),
                rateOfReturn
        );

    }

    private List<Lotto> buyLottos(int count) {
        List<Lotto> lottos = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = randomLottoPick();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto randomLottoPick() {
            return new Lotto(randomsProvider.pickUniqueNumbersInRange(1, 45, 6));
    }

    private Map<Integer, Integer> findWinningCountsByRank(Lotto winningLotto, int bonusNumber, List<Lotto> byingLottos) {
        Map<Integer, Integer> winningCount = new HashMap<>();
        // 기본 초기화
        winningCount.put(6, 0);
        winningCount.put(8, 0);
        winningCount.put(10, 0);
        winningCount.put(11, 0);
        winningCount.put(12, 0);
        for (Lotto byingLotto : byingLottos) {
            int weight = byingLotto.countMatchingNumbers(winningLotto, bonusNumber);
            if( weight < 6) {
                continue;
            }
            winningCount.put(weight, winningCount.get(weight) + 1);
        }

        return winningCount;
    }

    private void inputPurchaseNumberIncludeValidate() {
        try {
            purchaseAmount = ui.inputPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputPurchaseNumberIncludeValidate();
        }
    }

    private void inputWinningNumbersIncludeValidate() {
        try {
            winningNumbers = ui.inputWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputWinningNumbersIncludeValidate();
        }
    }

    private void inputBonusNumberIncludeValidate() {
        try{
            bonusNumber = ui.inputBonusNumber(winningNumbers);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBonusNumberIncludeValidate();
        }
    }

}
