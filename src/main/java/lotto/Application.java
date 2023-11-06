package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int lottoPur = Integer.parseInt(readLine());
        int lottoNum = lottoPur / 1000;
        // 예외처리

        List<List<Integer>> lotto = new ArrayList<>();
        getLotto(lotto, lottoNum);
    }
    public static List<List<Integer>> getLotto(List<List<Integer>> lotto, int lottoNum){
        for(int i=0; i<lottoNum; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.add(numbers);
        }
        return lotto;
    }
}
