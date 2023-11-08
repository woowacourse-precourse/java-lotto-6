package lotto.console;

import lotto.data.Messages;
import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Output {

    public static void printResult(Player player) {
        Output.printState(player.getState());

        Output.printRate(player.getAsset());
    }

    public static void printTickets(List<Lotto> tickets, long ticketNum) {
        System.out.printf(Messages.TICKET_PRINT_FORMAT, ticketNum);
        Stream<Lotto> ticketBuffer = tickets.stream();

        ticketBuffer.forEach(it -> System.out.println(it.getNumbers()));
    }

    public static void printState(State state) {
        List<Grade> gradeSeq = List.of(Grade.FIFTH, Grade.FOURTH, Grade.THIRD, Grade.SECOND, Grade.FIRST);
        Map<Grade, Integer> states = state.getGradeState();

        gradeSeq.forEach(
                grade -> System.out.println(grade.getMessage() + " - " + states.get(grade) + "개")
        );
    }

    public static void printRate(Asset asset) {
        DecimalFormat outFormat = new DecimalFormat(Messages.DECIMAL_FORMAT);
        System.out.println(Messages.printRateMessage(outFormat.format(asset.getRate())));
    }
}
