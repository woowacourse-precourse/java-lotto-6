package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputManager {
    public void printMessage(String outputMessage) {
        System.out.println(outputMessage);
    }

    public void printLotto(List<Integer> lottoNumbers) {
        String message = lottoNumbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        message = "[" + message + "]";
        printMessage(message);
    }

    public void printStatistic(Map<Integer, Integer> statistic) {
        final String fifth = "3개 일치 (5,000원) - "+statistic.get(30)+"개";
        final String fourth = "4개 일치 (50,000원) - "+statistic.get(40)+"개";
        final String third = "5개 일치 (1,500,000원) - "+statistic.get(50)+"개";
        final String second = "5개 일치, 보너스 볼 일치 (30,000,000원) - "+statistic.get(55)+"개";
        final String first = "6개 일치 (2,000,000,000원) - "+statistic.get(60)+"개";

        printMessage(fifth);
        printMessage(fourth);
        printMessage(third);
        printMessage(second);
        printMessage(first);
    }

}
