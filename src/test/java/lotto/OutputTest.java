package lotto;

import java.util.HashMap;
import java.util.List;
import lotto.view.PrizeMessage;
import org.junit.jupiter.api.Test;

public class OutputTest {

    @Test
    void getPrizeMessageTest(){
        HashMap<String,Integer> prizeList = new HashMap<>();
        prizeList.put("Three",1);
        PrizeMessage PM = new PrizeMessage();

        List<String> ans=PM.makePrizeMessage(prizeList);

    }
}
