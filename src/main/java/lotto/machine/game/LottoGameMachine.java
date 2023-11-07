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

        // testing value
        int sum = 100000000;
        double rateOfReturn = Math.round((double)sum / purchaseAmount * 100) / 100;


        // 당첨 결과에 따라 UI 제공 - 가중치를 이용
        ui.outputGameResult(
                winningCountsByRank.get(6),
                winningCountsByRank.get(8),
                winningCountsByRank.get(9),
                winningCountsByRank.get(10),
                winningCountsByRank.get(11),
                rateOfReturn
        );


    }

    private List<Lotto> buyLottos(int count) {
        List<Lotto> lottos = new LinkedList<>();
        for (int i=0; i< count; i++) {
            Lotto lotto = randomLottoPick();
            System.out.println("lotto = " + lotto);
            lottos.add(lotto);
        }
        return lottos;
    }
    private Lotto randomLottoPick() {
        Set<Integer> lottoExceptOverlap = new HashSet<>();
        while(lottoExceptOverlap.size() != 6) {
            lottoExceptOverlap.add(randomsProvider.pickNumberInRange(1, 45));
        }
        return new Lotto(lottoExceptOverlap.stream().toList());
    }

    private Map<Integer, Integer> findWinningCountsByRank(Lotto winningLotto, int bonusNumber, List<Lotto> byingLottos) {
        Map<Integer, Integer> winningCount = new HashMap<>();
        for(Lotto byingLotto: byingLottos) {
            // check winningLotto + bonusNumber Lotto 함수로 구현
            // ex -> byingLotto.countMatchingNumbers(winningLotto, bonusNumber) 로 가중치를 계산 숫자일치는 2 가중치 일치는 1
            // 당첨 갯수가 3개 까지는 보너스 점수 계산 x, 4개부터 보너스 점수 비교
            // 3개 일치 - 6
            // 4개 일치 - 8
            // 4개 일치 + 보너스 일치 - 9
            // 5개 - 10
            // 5개 + 보너스 일치 - 11
        }

        return winningCount;
    }


}
