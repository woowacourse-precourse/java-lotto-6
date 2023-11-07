package view;

import domain.Lotto;
import type.TextType;

import java.util.List;

public class OutputMessage {

    public static final String OPEN_BRACKET = "[";
    public static final String CLOSE_BRACKET = "]";
    public static final String ENTER = "\n";
    public static final String COMMA = ",";
    public static final String SPACE = " ";

    public static void moneyToNumberPrint(int number){
        System.out.println(ENTER + number + "" + TextType.PRICE_TO_NUMBER.getText());
    }


    public static void printLottosListOutputMessage(List<Lotto> lottosList) {
        StringBuilder lottoNumberBuilder = new StringBuilder();
        for (Lotto lotto : lottosList) {
            lottoNumberBuilder.append(OPEN_BRACKET);
            for (Integer lottoNumber : lotto.getLottoNumbers()) {
                lottoNumberBuilder.append(lottoNumber + COMMA + SPACE);
            }
            lottoNumberBuilder.delete(lottoNumberBuilder.length() - 2, lottoNumberBuilder.length());
            lottoNumberBuilder.append(CLOSE_BRACKET + ENTER);
        }
        System.out.println(lottoNumberBuilder);
    }

}
