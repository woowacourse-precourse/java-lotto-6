package view;

import domain.Lotto;
import type.PriceType;
import type.TextType;

import java.util.HashMap;
import java.util.List;

public class OutputMessage {

    public static final String OPEN_BRACKET = "[";
    public static final String CLOSE_BRACKET = "]";
    public static final String ENTER = "\n";
    public static final String COMMA = ",";
    public static final String SPACE = " ";
    public static final String CONNECT = "";
    public static final String DASH = " - ";

    public static void moneyToNumberPrint(int number){
        System.out.println(ENTER + number + CONNECT + TextType.PRICE_TO_NUMBER.getText());
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

    public static void printResultReadyOutputMessage() {
        System.out.println(ENTER + TextType.WINNING_STATISTICS.getText());
        System.out.println(TextType.WINNING_BAR.getText());
    }

    public static void printResultOutputMessage(HashMap resultMap) {
        System.out.println(PriceType.FIFTH.getCount() + CONNECT + TextType.MATCH_NUMBER_RESULT.getText()
                + SPACE + PriceType.FIFTH.getPrice() + DASH + resultMap.getOrDefault(PriceType.FIFTH.getPrice(), 0)
                + TextType.COUNT_UNIT.getText());
        System.out.println(PriceType.FOURTH.getCount() + CONNECT + TextType.MATCH_NUMBER_RESULT.getText()
                + SPACE + PriceType.FOURTH.getPrice() + DASH + resultMap.getOrDefault(PriceType.FOURTH.getPrice(), 0)
                + TextType.COUNT_UNIT.getText());
        System.out.println(PriceType.THIRD.getCount() + CONNECT + TextType.MATCH_NUMBER_RESULT.getText()
                + SPACE + PriceType.THIRD.getPrice() + DASH + resultMap.getOrDefault(PriceType.THIRD.getPrice(), 0)
                + TextType.COUNT_UNIT.getText());
        System.out.println(PriceType.THIRD.getCount() + CONNECT + TextType.MATCH_NUMBER_RESULT.getText() + COMMA + SPACE
                + PriceType.BONUS.getPrice() + SPACE + PriceType.SECOND.getPrice() + DASH + resultMap.getOrDefault(PriceType.SECOND.getPrice(), 0)
                + TextType.COUNT_UNIT.getText());
        System.out.println(PriceType.FIRST.getCount() + CONNECT + TextType.MATCH_NUMBER_RESULT.getText()
                + SPACE + PriceType.FIRST.getPrice() + DASH + resultMap.getOrDefault(PriceType.FIRST.getPrice(), 0)
                + TextType.COUNT_UNIT.getText());
    }

    public static void printEarnRatioOutputMessage(double earnRatio) {
        System.out.println(TextType.EARN_PERCENT.getText() + SPACE
                + String.format("%.1f", earnRatio) + "%입니다.");
    }
}
