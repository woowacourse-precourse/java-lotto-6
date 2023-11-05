package lotto.view;

import lotto.util.Constant;

import java.text.MessageFormat;

public class OutputView {

    public void printResult(Integer lottoNum){
        System.out.println(MessageFormat.format(Constant.LOTTO_AMOUNT, lottoNum));
    }
}
