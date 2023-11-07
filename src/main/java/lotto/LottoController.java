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

    private List<Integer> winningNumbers;
    private List<Integer> bonusNumber;

    int three = 0;
    int four = 0;
    int five1 = 0;
    int five2 = 0;
    int six = 0;


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
                "3개 일치 (5,000원) - " + three + "개\n" +
                "4개 일치 (50,000원) - " + four + "개\n" +
                "5개 일치 (1,500,000원) - "+ five1 + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - "+ five2 + "개\n" +
                "6개 일치 (2,000,000,000원) - "+ six + "개\n" +
                "총 수익률은 "+(three*5000L + four*50000L + five1*1500000L + five2*30000000L + six*2000000000L)/(totalLottoCnt* 10L) + "%입니다.");
    }
}
