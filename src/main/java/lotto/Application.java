package lotto;

import domain.LottoNumberGenerator;
import domain.LottoWinChecker;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        Lotto lotto = new Lotto(new LottoNumberGenerator().getLottoNumbers());
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoWinChecker winChecker = new LottoWinChecker(lotto, Arrays.asList(1, 2, 3, 4, 5, 7, 6));
        System.out.println(lotto.getRank());
    }
}
