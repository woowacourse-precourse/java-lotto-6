package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class OutputView {

    /**
     * 3. 발급한 로또 번호 출력 기능
     */
    public void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printCurrentLottoList(Lotto lotto) {
        System.out.print("[");
        List<Integer> lotto_num_list = lotto.getNumbers();
        //-> 문자열로 변환해서
        List<String> lotto_str_num = lotto_num_list.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.print(String.join(", ", lotto_str_num));
        System.out.println("]");
    }
}
