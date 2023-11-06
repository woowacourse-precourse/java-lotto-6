package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {
    private static final String PURCHASED_LOTTO_AMOUNT = "개를 구매했습니다.";
    private static final List<String> lottCountSet = List.of("3", "4", "5", "5wB", "6");
    private static final String[] matched = {
            "3개 일치 (5,000원) - ",
                    "4개 일치 (50,000원) - ",
                    "5개 일치 (1,500,000원) - ",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
                    "6개 일치 (2,000,000,000원) - "
};

    public static void printPieceOfLottoAmount(int pieceOfLotto){
        System.out.print(pieceOfLotto);
        System.out.println(PURCHASED_LOTTO_AMOUNT);
    }
    public static void printAllLottos(ArrayList<List<String>> allLottos){
        for(List<String> lotto : allLottos){
            System.out.println(lotto);
        }
    }

    public static void printLottoStates(ArrayList<String> matchedLottoList){//모델이나 컨트롤러로 옮김
        System.out.println("당첨 통계");
        System.out.println("---");
        for(String number : lottCountSet){
            if(Collections.frequency(matchedLottoList,number) >= 0){
                System.out.print(matched[lottCountSet.indexOf(number)]);
                System.out.print(Collections.frequency(matchedLottoList,number));
                System.out.println("개");
            }
        }
    }



}
