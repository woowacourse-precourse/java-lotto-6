package lotto.view;

import lotto.utility.enums.Messages;

public class OutputView {
    private OutputView(){}; //생성자로 인스턴스 생성 막기

    public static void printLottoCount(int lottoCount){
        System.out.println(lottoCount + Messages.LOTTO_COUNT_MESSAGE.getMessage());
    }

}
