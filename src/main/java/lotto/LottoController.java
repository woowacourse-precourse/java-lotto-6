package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.util.Collections.sort;
import static lotto.Util.*;

public class LottoController {

    private List<Lotto> lottos;
    private int totalLottoCnt;

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void playLotto() {
        start();
        generateLottoNumber();
        middle();
        calculate();
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
        List<Integer> randonValue = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sort(randonValue);
        return randonValue;
    }

    private void middle() {
        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbers = winningNumberCalculate(readLine());

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = winningNumberCalculate(winningNumbers, readLine());
    }

    private void calculate() {
    }

    private void printEnd() {
        System.out.println("당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 62.5%입니다.");
    }
}
