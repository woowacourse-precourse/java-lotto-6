package domain;

import camp.nextstep.edu.missionutils.Randoms;
import dto.Lotto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;
    private static int hasFiveAndbonusNumber;

    public LottoGame() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void playLottoGame() {
        int lottoCnt = buyLotto();
        List<Lotto> lottos = publishLotto(lottoCnt);
        outputView.showPublishedLotto(lottos);
        String getWinningNumbers = inputView.enterWinningNumber();
        int bonusNumber = inputView.enterBonusNumber();
        List<Integer> winningNumbers = Arrays.stream(getWinningNumbers.split(",")).map(Integer::parseInt).toList();
        Map<Integer, Integer> lottoScore = updateScore(lottoCnt, lottos, bonusNumber, winningNumbers);
        outputView.showScore(lottoScore, hasFiveAndbonusNumber);
    }

    private Integer buyLotto() {
        int money = inputView.enterPriceToBuy();
        int lottoCnt = money / 1000;
        System.out.println(lottoCnt + "개를 구매했습니다.");
        return lottoCnt;
    }

    private List<Integer> pickLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() < 6) {
            int lottoNumber = Randoms.pickNumberInRange(1, 45);
            if (lottoNumbers.contains(lottoNumber)) {
                continue;
            }
            lottoNumbers.add(lottoNumber);
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private List<Lotto> publishLotto(int lottoCnt) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> lottoNumbers = pickLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    private Map<Integer, Integer> initLottoScore() {
        Map<Integer, Integer> lottoScore = new java.util.HashMap<>(Map.of(
                0, 0,
                1, 0,
                2, 0,
                3, 0,
                4, 0,
                5, 0,
                6, 0
        ));
        return lottoScore;
    }
    private int checkSameNumberCnt(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int sameNumberCnt = 0;
        for (int j = 0; j < winningNumbers.size(); j++) {
            if (lottoNumbers.contains(winningNumbers.get(j))) {
                sameNumberCnt++;
            }
        }
        return sameNumberCnt;
    }

    private Map<Integer, Integer> updateScore(int lottoCnt, List<Lotto> lottos, int bonusNumber, List<Integer> winningNumbers) {
        Map<Integer, Integer> lottoScore = initLottoScore();
        for (int i = 0; i < lottoCnt; i++) {
            Lotto lotto = lottos.get(i);
            List<Integer> lottoNumbers = lotto.getLottoNumbers();

            int sameNumberCnt = checkSameNumberCnt(winningNumbers, lottoNumbers);
            if (sameNumberCnt == 5 && lottoNumbers.contains(bonusNumber)) {
                hasFiveAndbonusNumber++;
            } else if (sameNumberCnt < 5 || sameNumberCnt == 6) {
                lottoScore.put(sameNumberCnt, lottoScore.get(sameNumberCnt) + 1);
            }
        }
        return lottoScore;
    }
}
