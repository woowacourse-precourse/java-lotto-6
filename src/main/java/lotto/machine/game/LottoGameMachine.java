package lotto.machine.game;

import lotto.Lotto;
import lotto.machine.ui.UI;
import lotto.machine.util.random.RandomsProvider;

import java.util.*;

public class LottoGameMachine implements LottoGameMachineInterface {
    private final UI ui;
    private final RandomsProvider randomsProvider;

    public LottoGameMachine(UI ui, RandomsProvider randomsProvider) {
        this.ui = ui;
        this.randomsProvider = randomsProvider;
    }

    @Override
    public void run() {

        // 당첨 Lotto
        Lotto winningLotto;
        // 보너스 숫자
        int bonusNumber;

        // 구매
        ui.requirePurchaseView();
        int purchaseAmount = ui.inputPurchaseAmount();

        // 가격만큼 Lotto 구매
        int count = purchaseAmount / 1000;
        List<Lotto> byingLottos = buyLottos(count);

        // 구매 내역
        ui.outputPurchaseLottoNumbers(byingLottos);

        // 당첨 번호 입력
        ui.requireWinningNumbers();
        List<Integer> winningNumbers = ui.inputWinningNumbers();
        // 번호를 Lotto로 전환
        winningLotto = new Lotto(winningNumbers);

        // 보너스 번호 입력
        ui.requireBonusNumber();
        bonusNumber = ui.inputBonusNumber(winningNumbers);

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
        Set<Integer> lottoExceptOverlap = new HashSet<>();
        while (lottoExceptOverlap.size() != 6) {
            lottoExceptOverlap.add(randomsProvider.pickNumberInRange(1, 45));
        }
        return new Lotto(lottoExceptOverlap.stream().toList());
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


}
