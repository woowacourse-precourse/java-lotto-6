package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.MyLottos;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OutputView {
    private static final String PURCHASE_LOTTO_NUMBER_MESSAGE  ="%d개를 구매했습니다";
    private static final String COMMA = ", ";
    private static final String WINNING_RESULT_MESSAGE = "당첨 통계";

    public static void printPurchaseLottoNumber(int number, MyLottos myLottos){
        System.out.println(String.format(PURCHASE_LOTTO_NUMBER_MESSAGE,number));
        drawLotto(myLottos);
    }

    public static void drawLotto(MyLottos myLottos){
        myLottos.getLottos().stream().forEach(lotto->
                System.out.println(drawLottoNumber(lotto))
        );
    }
    public static String drawLottoNumber(Lotto lotto){
       String drawLotto = "[";
       drawLotto += lotto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.joining(COMMA));
       drawLotto+= "]";
       return drawLotto;
    }

    public static void winningResult(LottoRanking lottoRanking){
         System.out.println(Arrays.asList(lottoRanking.getRanking()));

    }
}
