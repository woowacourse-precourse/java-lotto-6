package lotto.print;

import lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PrintOutputTest {
    PrintOutput printOutput = new PrintOutput();
    @Test
    void printRandomLottosNumbersTest() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1=new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2=new Lotto(List.of(7,8,9,10,11,12));
        Lotto lotto3=new Lotto(List.of(13,14,15,16,17,18));
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);

        printOutput.printRandomLottosNumbers(lottos);
    }
}