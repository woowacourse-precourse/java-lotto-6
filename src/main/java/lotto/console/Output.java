package lotto.console;

import lotto.domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Output {
    public static void printTickets(List<Lotto> tickets, long ticketNum){
        System.out.printf("%d개를 구매했습니다. \n", ticketNum);
        Stream<Lotto> ticketBuffer = tickets.stream();
        ticketBuffer.forEach( it -> System.out.println(it.getNumbers()));
    }

    public static void printResult(State state){
        Map<Grade, Integer> states = state.getGradeState();
        states.forEach((grade, value) -> System.out.println(grade.getMessage() + " - " + value + "개"));
    }

    public static void printRate(Asset asset){
        System.out.printf("총 수익률은 %.1f%%입니다.", asset.getRate());
    }
}
