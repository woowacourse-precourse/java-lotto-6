package lotto.console;

import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Output {

    public static void printResult(Player player){
        Output.printState(player.getState());

        Output.printRate(player.getAsset());
    }
    public static void printTickets(List<Lotto> tickets, long ticketNum){
        System.out.printf("%d개를 구매했습니다.\n", ticketNum);
        Stream<Lotto> ticketBuffer = tickets.stream();

        ticketBuffer.forEach( it -> System.out.println(it.getNumbers()));
    }

    public static void printState(State state){
        List<Grade> gradeSeq = List.of(Grade.FIFTH, Grade.FOURTH, Grade.THIRD, Grade.SECOND, Grade.FIRST);
        Map<Grade, Integer> states = state.getGradeState();

        gradeSeq.forEach(
                grade -> System.out.println(grade.getMessage() + " - " + states.get(grade) + "개")
        );
    }

    public static void printRate(Asset asset){
        DecimalFormat outFormat = new DecimalFormat("#,###.0");
        System.out.println(asset.getRate());
        System.out.println("총 수익률은 " + outFormat.format(asset.getRate()) +"%입니다.");
    }
}
