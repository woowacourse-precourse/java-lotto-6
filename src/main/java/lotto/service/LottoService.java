package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lotto.Enum.Winning;
import lotto.domain.ExceptionModule;
import lotto.domain.Lotto;

public class LottoService {

    private static final Integer LOTTO_PRICE = 1000;

    public static void run() {
        Integer tryNum = InteractService.purchasePhase();

        //로또 생성
        int lottoCount = tryNum / LOTTO_PRICE;
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNum = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            randomNum.sort(Comparator.naturalOrder());
            lottos.add(new Lotto(randomNum));
            System.out.println(randomNum);
        }
        ExceptionModule.checkLottoCount(lottos.size(), lottoCount);
        //당첨 번호 입력 받기
        List<Integer> winningNum = InteractService.winningNumPhase();
        //보너스 번호 입력 받기
        Integer bonusNum = InteractService.bonusNumPhase(winningNum);

        //로또 결과 생성
        List<Integer> result = new ArrayList<>(
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        );
        for (Lotto l : lottos) {
            List<Integer> lotto = l.getNumbers();
            lotto.addAll(winningNum);

            int correctNum = lotto.stream().distinct().toList().size();
            if(correctNum > 9){
                continue;
            }
            if (correctNum == 6) {
                correctNum = 5;
            }
            if (correctNum == 7) {
                if (lotto.contains(bonusNum)) {
                    correctNum = 6;
                }
            }
            result.set(correctNum, result.get(correctNum)+1);
        }
        result.subList(5, 9);
        Collections.reverse(result);

        System.out.println("당첨 통계");
        System.out.println("---");
        int sum = 0;
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        for (Winning winning : Winning.values()) {
            System.out.println(winning.getMessage() + "(" + decimalFormat.format(winning.getAmount()) + "원) - " + result.get(0) + "개");
            sum += winning.getAmount() * result.get(0);
            result.remove(0);
        }

        System.out.printf("총 수익률은 %.1f%%입니다.", ((float)sum/tryNum*100));

    }
}
