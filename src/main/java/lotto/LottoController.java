package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
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
    }

    private void generateLottoNumber() {
        List<Lotto> newLotto = new ArrayList<>();
        
        // 로또 횟수만큼 반복
        for(int i=0; i<totalLottoCnt; ++i) {
            // 6자리 랜덤 변수 생성
            List<Integer> numbers = new ArrayList<>();

            //생성한 변수 Lotto 객체에 주입
            Lotto a = new Lotto(numbers);

            // newLotto 배열에 추가
            lottos.add(a);
        }

        this.lottos = newLotto;
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
    }
}
