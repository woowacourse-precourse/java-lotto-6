package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.GameManager;
import lotto.domain.Lotto;
import lotto.domain.User;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.WinningLotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new GameManager();
        List<Lotto> lottos;
        WinningLotto winningLotto = null;
        int bonusNumber = 0;
        gameManager.startLottoGame();
        User user = new User();
        boolean iterationTrigger;
        int lottoCount;
        iterationTrigger = true;
        lottoCount = -1;
        while (iterationTrigger) {
            try {
                lottoCount = user.buyLotto(Console.readLine());
                gameManager.showLottoCount(lottoCount);
                iterationTrigger = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
        lottos = gameManager.instantiateLottos(lottoCount);
        gameManager.showLottos(lottos);
        gameManager.showDrawMessage();
        iterationTrigger = true;
        while (iterationTrigger) {
            try {
                winningLotto = user.drawWinningLotto(Console.readLine());
                iterationTrigger = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        gameManager.showBonusDrawMessage();
        iterationTrigger = true;
        while (iterationTrigger) {
            try {
                bonusNumber = Integer.parseInt(Console.readLine());
                iterationTrigger = false;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호은 숫자만 가능합니다.");
            }
        }

        int firstRank = 0;
        int secondRank = 0;
        int thirdRank = 0;
        int fourthRank = 0;
        int fifthRank = 0;

        for (Lotto lotto : lottos) {
            // 로또 번호를 비교하여 일치하는 등수를 출력
            // 3등: 5개 일치, 4등: 4개 일치, 5등: 3개 일치
            // 2등: 5개 일치 + 보너스 볼 일치
            // 1등: 6개 일치

            int matchCount = 0;

            for (int i = 0; i < winningLotto.getWinningNumbers().size(); i++) {
                for (int j = 0; j < lotto.getNumbers().size(); j++) {
                    if (winningLotto.getWinningNumbers().get(i) == lotto.getNumbers().get(j)) {
                        matchCount++;
                    }
                }
            }

            // 보너스 볼이 일치하는지 확인
            boolean isBonusMatch = false;
            for (int i = 0; i < winningLotto.getWinningNumbers().size(); i++) {
                if (winningLotto.getWinningNumbers().get(i) == bonusNumber) {
                    isBonusMatch = true;
                    break;
                }
            }

            // 일치하는 등수 += 1

            if (matchCount == 6) {
                firstRank++;
                continue;
            }
            if (matchCount == 5 && isBonusMatch) {
                secondRank++;
                continue;
            }
            if (matchCount == 5) {
                thirdRank++;
                continue;
            }
            if (matchCount == 4) {
                fourthRank++;
                continue;
            }
            if (matchCount == 3) {
                fifthRank++;
                continue;
            }

        }
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifthRank + "개");
        System.out.println("4개 일치 (50,000원) - " + fourthRank + "개");
        System.out.println("5개 일치 (1,500,000원) - " + thirdRank + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondRank + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + firstRank + "개");
        System.out.println("총 수익률은 " + (firstRank * 2000000000 + secondRank * 30000000 + thirdRank * 1500000 + fourthRank * 50000 + fifthRank * 5000) / (double) (lottoCount * 1000) * 100 + "%입니다.");
    }
}
