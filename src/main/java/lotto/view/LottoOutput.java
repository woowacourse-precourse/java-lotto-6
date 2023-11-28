package lotto.view;

import camp.nextstep.edu.missionutils.Console;


import java.util.List;

import static lotto.view.ConstantsMessage.*;

public class LottoOutput {



    public void buyLottoNumberPrint(List<List<Integer>> lottoNumber) {
        printNewLine();
        System.out.println(lottoNumber.size()+BUY_RESULT_MESSAGE.getMessage());
        lottoNumber.forEach(System.out::println);
    }

    public static void seeWinningStatstic(List<String> lottoPrizes) {
        System.out.println(WIN_RESULT_MESSAGE.getMessage());
        System.out.println(lINE_SEPARATION_MESSAGE.getMessage());
       for(String lottoPrize : lottoPrizes){
           System.out.println(lottoPrize);
       }

    }
    private void printNewLine() {
        System.out.println();
    }

    public void seePercentage(double percentage) {
        System.out.println(PERCENT_FRONT_MESSAGE.getMessage()+percentage+PERCENT_BACK_MESSAGE.getMessage());
    }
}
