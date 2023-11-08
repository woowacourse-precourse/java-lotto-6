package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

public class Game {
    static final int LOTTO_PRICE = 1000;
    static final int LIMIT_LOTTO_NUMBER = 45;
    static final int LOWEST_RANK = 5;

    int numOfLotto;
    Lotto publishedLotto[];
    int prizeWinNum[] = new int[LIMIT_LOTTO_NUMBER + 1];
    int winStat[] = new int[LOWEST_RANK + 1];

    int inputCredit() { //로또 구매 금액 입력
        int credit;


        System.out.println("구입금액을 입력해 주세요.");
        credit = Integer.parseInt(readLine());


        if (credit % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }

        return credit;
    }

    void buyLotto() { //로또 구매 시 예외 처리
        while (true) {
            try {
                numOfLotto = inputCredit() / LOTTO_PRICE;
                publishedLotto = new Lotto[numOfLotto];
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
            }
        }
    }

    List<Integer> createRandomNumber(){ //로또번호 생성
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return randomNumber;
    }

    void publish(){ //로또 발행
        buyLotto(); //로또 구매
        for(int i = 0; i < publishedLotto.length; i++){// 번호 생성
            publishedLotto[i] = new Lotto(createRandomNumber());
        }
    }

    void printLotto(){ // 발행한 로또 출력
        System.out.println("\n" + numOfLotto + "개를 구매했습니다.");
        for(int i = 0; i < publishedLotto.length; i++){
            System.out.print("[");
            publishedLotto[i].printLotto();
            System.out.println("]");
        }
    }

    void initPrizeWinNum(){ //당첨 번호 배열 초기화
        for (int i = 1; i < LIMIT_LOTTO_NUMBER; i++){
            prizeWinNum[i] = 0;
        }
    }

    String[] inputNum(){ // 당첨 번호 입력
        String[] input;

        System.out.println("당첨 번호를 입력해 주세요.");
        input = readLine().split(",");

        return input;
    }

    void setNum(String inputNum[]){ //당첨 번호 셋팅
        for(int i = 0; i < inputNum.length; i++){
            int num = Integer.parseInt(inputNum[i]);
            prizeWinNum[num] = 1;
        }
    }

    String inputBonusNum(){ //보너스 번호 입력
        String input;

        System.out.println("보너스 번호를 입력해 주세요.");
        input = readLine();

        return input;
    }

    void setBounusNum(String inputNum){ //보너스 번호 2로 셋팅
        int num = Integer.parseInt(inputNum);
        prizeWinNum[num] = 2;
    }

    void setPrizeWinNum(){ //발행 번호 배열 셋팅
        initPrizeWinNum();
        setNum(inputNum());
        setBounusNum(inputBonusNum());
    }

    void initStat(){ //통계 저장 초기화
        for(int i = 0; i < winStat.length;i++) {
            winStat[i] = 0;
        }
    }

    void statistics(Lotto published){ //로또 순위 확인
        published.checkLotto(prizeWinNum);

        winStat[published.ranking]++;
    }

    void stareStat(){ // 로또 순위 통계 저장
        for(int i = 0; i < publishedLotto.length; i++) {
            statistics(publishedLotto[i]);
        }
    }
}
