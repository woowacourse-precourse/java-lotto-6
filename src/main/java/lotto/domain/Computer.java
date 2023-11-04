package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Computer {

    // 입력 받기
    public static String getInput() {
        return Console.readLine();
    }

    // 출력 담당 컴퓨터
    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> sortedLotto = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedLotto);
            System.out.println(sortedLotto);
        }
    }

    // 당첨 체크
    public static List<Integer> checkWinning(List<Lotto> lottos, Lotto winningLotto, Integer bonusNumber) {
        int count;
        List<Integer> lottoResult = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        for (Lotto lotto : lottos) {
            count = 0;
            for (int i = 0; i < 6; i++) {
                if (lotto.getNumbers().contains(winningLotto.getNumbers().get(i))) {
                    count++;
                }
            }
            if (count == 6) {
                lottoResult.set(0, lottoResult.get(0) + 1);
                continue;
            }
            if (count == 5) {
                if (lotto.getNumbers().contains(bonusNumber)) {
                    lottoResult.set(1, lottoResult.get(1) + 1);
                    continue;
                }
                lottoResult.set(2, lottoResult.get(2) + 1);
                continue;
            }
            if (count == 4) {
                lottoResult.set(3, lottoResult.get(3) + 1);
                continue;
            }
            if (count == 3) {
                lottoResult.set(4, lottoResult.get(4) + 1);
            }
        }
        return lottoResult;
    }

    // 수익률 계산

    public static Double calculateEarningRate(List<Integer> lottoResult, List<Integer> prizeMoney, Integer lottoCount) {
        int sum = 0;

        for (int i = 0; i < lottoResult.size(); i++) {
            sum += lottoResult.get(i) * prizeMoney.get(i);
        }

        return ((double) sum / (lottoCount * 1000)) * 100;

    }


}
