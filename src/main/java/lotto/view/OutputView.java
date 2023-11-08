package lotto.view;

import lotto.domain.Lotto;
import lotto.utility.enums.Messages;

import java.util.List;

public class OutputView {
    private OutputView(){}; //생성자로 인스턴스 생성 막기

    public static void printLottoCount(int lottoCount){
        System.out.println(lottoCount + Messages.LOTTO_COUNT_MESSAGE.getMessage());
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers){
        System.out.println(lottoNumbers.toString());
    }

}
