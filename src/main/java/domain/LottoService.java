package domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import dto.Lotto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import view.InputView;

public class LottoService {
    private final InputView inputView;

    public LottoService() {
        inputView = new InputView();
    }

    public void buyLotto() {
        int money = inputView.enterPriceToBuy();
        int lottoCnt = money / 1000;
        System.out.println(lottoCnt + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> lottoNumbers = new ArrayList<>();
            while (lottoNumbers.size() < 6) {
                int lottoNumber = Randoms.pickNumberInRange(1, 45);
                if (lottoNumbers.contains(lottoNumber)) {
                    continue;
                }
                lottoNumbers.add(lottoNumber);
            }
            Collections.sort(lottoNumbers);
            lottos.add(new Lotto(lottoNumbers));
        }
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            lotto.showLottoNumbers();
        }
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String getWinningNumbers = Console.readLine();
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        List<Integer> winningNumbers = Arrays.stream(getWinningNumbers.split(",")).map(Integer::parseInt).toList();
        Map<Integer, Integer> lottoScore = new java.util.HashMap<>(Map.of(
                0, 0,
                1, 0,
                2, 0,
                3, 0,
                4, 0,
                5, 0,
                6, 0
        ));
        int isbonusNumber = 0;
        for (int i = 0; i < lottoCnt; i++) {
            int sameNumberCnt = 0;
            Lotto lotto = lottos.get(i);
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            for (int j = 0; j < winningNumbers.size(); j++) {
                if (lottoNumbers.contains(winningNumbers.get(j))) {
                    sameNumberCnt++;
                }
            }
            if (sameNumberCnt == 5) {
                if (lottoNumbers.contains(bonusNumber)) {
                    isbonusNumber++;
                }
            } else if (sameNumberCnt < 5 || sameNumberCnt == 6) {
                lottoScore.put(sameNumberCnt, lottoScore.get(sameNumberCnt) + 1);
            }
        }
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoScore.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoScore.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoScore.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + isbonusNumber + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoScore.get(6) + "개");
    }
}
