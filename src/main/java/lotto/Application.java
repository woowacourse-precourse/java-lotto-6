package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lottoNumbers = new Lotto(numbers);
        System.out.println(lottoNumbers);
        System.out.println(numbers);
    }
//        List<Integer> counting(List<List<Integer>> listlist, List<Integer> winningNumbers){
//            List<Integer> result = new ArrayList<>();
//            // listlist를 사용하여 작업을 수행하여 result 리스트에 결과를 저장
//            return result;
//        }
//

}
