package lotto.model;

import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    public void testBuyLotto() {
        Person person = Person.of(5000);
        PaperBag paperBag = PaperBag.of(Collections.emptyList());
        person.buyLotto(paperBag);
        assertNotNull(person.getPaperBag());
    }

    @Test
    public void testInvalidPersonCreation() {
        int invalidPurchaseAmount = 1501;
        try {
            Person person = Person.of(invalidPurchaseAmount);
            fail("예외가 발생해야 합니다.");
        } catch (NumberFormatException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testGetLottoesToString() {
        Person person = Person.of(5000);

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        PaperBag paperBag = PaperBag.of(lottoList);
        person.buyLotto(paperBag);

        String lottoesString = person.getLottoesToString();
        String expected = "[1, 2, 3, 4, 5, 6]\n";

        assertEquals(expected, lottoesString);
    }

}
