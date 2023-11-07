package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.util.Collections.sort;
import static lotto.Coincidence.*;
import static lotto.Util.*;

public class LottoController {
    private List<Lotto> lottos;
    private int totalLottoCnt;
    private int three = 0;
    private int four = 0;
    private int five1 = 0;
    private int five2 = 0;
    private int six = 0;
    private List<Integer> winningNumbers;
    private List<Integer> bonusNumber;

    public void playLotto() {
        start();
        generateLottoNumber();
        middle();
        for(Lotto l : lottos) {
            calculate(l);
        }
        printEnd();
    }

    private void start() {
        System.out.println("구입금액을 입력해 주세요.");
        this.totalLottoCnt = checkTotalPrice(checkNumberValidate(readLine()));
        System.out.println();
    }

    private void generateLottoNumber() {
        List<Lotto> newLotto = new ArrayList<>();
        System.out.println(totalLottoCnt + "개를 구매했습니다.");
        // 구매한 로또 수만큼 반복
        for(int i=0; i<totalLottoCnt; ++i) {
            // 6자리 랜덤 변수 생성 후 생성한 변수 Lotto 객체에 주입
            Lotto gotcha = new Lotto(generateRandomNumbers());
            gotcha.printLotto();
            newLotto.add(gotcha);
        }
        System.out.println();
        this.lottos = newLotto;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomValue = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sort(randomValue);
        return randomValue;
    }

    private void middle() {
        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbers = winningNumberCalculate(readLine());
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = winningNumberCalculate(winningNumbers, readLine());
        System.out.println();
    }

    private void calculate(Lotto l) {
        boolean bonusPoint = false;
        int cnt = 0;
        List<Integer> checkLotto = l.getNumbers();

        for(Integer temp: checkLotto) {
            if(winningNumbers.contains(temp)) ++cnt;
        }
        if(cnt == 5) {
            for(Integer temp: checkLotto) {
                if(bonusNumber.contains(temp)) bonusPoint = true;
            }
        }
        // count checker
        countChecker(cnt, bonusPoint);
    }

    private void countChecker(int cnt, boolean bonus) {
        if(cnt == 6) ++six;
        if(cnt == 5 && bonus) ++five2;
        if(cnt == 5 && !bonus) ++five1;
        if(cnt == 4) ++four;
        if(cnt == 3) ++three;
    }

    private void printEnd() {
        System.out.println("당첨 통계\n" +
                "---\n" +
                THREE.getCoin() + three + "개\n" +
                FOUR.getCoin() + four + "개\n" +
                FIVE1.getCoin() + five1 + "개\n" +
                FIVE2.getCoin() + five2 + "개\n" +
                SIX.getCoin() + six + "개\n" +
                "총 수익률은 " + String.format("%.1f",(double)(three*5000L + four*50000L + five1*1500000L + five2*30000000L + six*2000000000L) / (double)(totalLottoCnt*10L)) + "% 입니다.");
    }
}
