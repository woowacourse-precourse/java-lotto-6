package lotto.View;

import lotto.Model.Lotto;

import java.util.List;

public class PrintOutput {
    public static final String NUMBER_OF_LOTTO = "개를 구매했습니다.";
    public static final String RESURLT_LOTTO = "당첨 통계";

    public static void printAmount(int lottoAmount){
        System.out.println("\n" + lottoAmount + PrintOutput.NUMBER_OF_LOTTO);
    }

    public static void printUserLotto(List<Lotto> randomLottoNumbers) {
        for (Lotto numbers : randomLottoNumbers) {
            System.out.println(numbers.toString());
        }
    }
}
