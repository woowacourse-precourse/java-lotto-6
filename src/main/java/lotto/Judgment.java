package lotto;

import java.util.Collections;
import java.util.List;

public class Judgment{

    public static int divisibleByThousand(int amount){
        int remain = amount % 1000;
        int numberOfTickets = amount / 1000;

        if(remain != 0){
            throw new IllegalArgumentException();
        }

        return numberOfTickets;
    }

    public static void lottoSort(List<Integer> ticket) {
        Collections.sort(ticket);
    }
}
