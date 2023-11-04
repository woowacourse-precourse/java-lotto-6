package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutView {

    public static void printTickekQuantity(int ticketQuantity) {
        System.out.println("\n"+ticketQuantity+"개를 구매했습니다.");
    }

    public static void printConsumerLottos(ArrayList<Lotto> lottos) {
        for(Lotto lotto : lottos){
            List<String> numbers = lotto.getNumbers()
                    .stream().map(String::valueOf)
                    .collect(Collectors.toList());
            String lottoNumbers = String.join(", ", numbers);
            System.out.println("["+lottoNumbers+"]");
        }

    }
}
