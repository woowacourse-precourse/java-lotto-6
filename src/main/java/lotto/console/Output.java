package lotto.console;

import lotto.domain.Asset;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Output {
    public static void printTickets(List<Lotto> tickets, long ticketNum){
        System.out.printf("%d개를 구매했습니다. \n", ticketNum);
        Stream<Lotto> ticketBuffer = tickets.stream();
        ticketBuffer.forEach( it -> System.out.println(it.getNumbers()));
    }

    public static void printResult(int grade){
        if(grade == 1) System.out.print("6개 일치 (2,000,000,000원)");
        if(grade == 2) System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원)");
        if(grade == 3) System.out.print("5개 일치 (1,500,000원)");
        if(grade == 4) System.out.print("4개 일치 (50,000원)");
        if(grade == 5) System.out.print("3개 일치 (5,000원)");
    }

    public static void printRate(Asset asset){
        System.out.println("총 수익률은 "+ asset.getRate() +"%입니다.");
    }
}
