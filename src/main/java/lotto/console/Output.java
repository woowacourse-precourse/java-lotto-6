package lotto.console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Output {
    public static void printTickets(ArrayList<List<Integer>> tickets, int ticketNum){
        System.out.printf("%d개를 구매했습니다. \n", ticketNum);

        Stream<List<Integer>> ticketBuffer = tickets.stream();

        ticketBuffer.forEach(System.out::println);
    }
}
