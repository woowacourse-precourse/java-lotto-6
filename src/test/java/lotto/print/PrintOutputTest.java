package lotto.print;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PrintOutputTest {
    PrintOutput printOutput = new PrintOutput();
    @DisplayName("랜덤 로또 메시지 출력")
    @Test
    void printRandomLottosNumbersTest() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1=new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2=new Lotto(List.of(7,8,54,10,11,12));
        Lotto lotto3=new Lotto(List.of(13,14,34,16,17,18));
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);

        printOutput.printRandomLottosNumbers(lottos);
    }
    @DisplayName("통계 메시지 출력")
    @Test
    void printStats(){
        int[] stats={0, 1, 1, 1, 1, 1};
        double percent=100.4567;
        printOutput.printStats(stats, percent);
    }
    @DisplayName("몇개 구입했는지 출력")
    @Test
    void printPurchasedLottoNumber(){
        printOutput.printPurchasedLottoNumber(10000);
    }
}