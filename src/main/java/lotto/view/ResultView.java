package lotto.view;

import lotto.handler.UserHandler;

import java.util.List;

public class ResultView {

    public static void printNewLine(){
        System.out.println();
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Integer> numbers){
        System.out.println(numbers);
    }
}
