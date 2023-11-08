package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;


public class Application {
    public static void main(String[] args) {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        /*try {
            Lotto lotto = new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }*/
        Lotto lotto = new Lotto(numbers);
        lotto.inputMoney();




        // TODO: 프로그램 구현
    }
}
