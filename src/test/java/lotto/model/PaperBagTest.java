package lotto.model;

import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaperBagTest {
    @Test
    public void testPaperBagLottoesToString() {

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));

        PaperBag paperBag = PaperBag.of(lottoList);

        String lottoesString = paperBag.lottoesToString();

        String expected = "[1, 2, 3, 4, 5, 6]\n" +
                          "[7, 8, 9, 10, 11, 12]\n";

        assertEquals(expected, lottoesString);
    }
}
