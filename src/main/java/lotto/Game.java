package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

public class Game {
    static final int LOTTO_PRICE = 1000;
    int numOfLotto;
    Lotto publishedLotto[];

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
}
