package view;


import java.util.List;
import lotto.Lotto;

public class OutputView {

    public static final String EMPTY_ERROR_MESSAGE = "구매금액을 입력해주세요";


    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLotties(List<Lotto> lotties) {
        lotties.stream().forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        });
        System.out.println();
    }


}
