package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {

    @Test
    void 천원_단위로_나누어_떨어지지_않으면_IllegalArgumentException_예외를_던진다() {
        //given
        int payAmount = 1023;

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new Purchase(payAmount);
        });
    }

    @Test
    void 천원_단위로_나누어_떨어지지_않으면_checkInUnit_메서드에서_예외를_던진다() {
        //given
        int payAmount = 1023;
        String methodName = "checkInUnit";

        try {
            new Purchase(payAmount);
        } catch (IllegalArgumentException e) {
            String throwsFromMethod = e.getStackTrace()[0].getMethodName();
            assertEquals(methodName, throwsFromMethod);
        }
    }

    @Test
    void 구입_금액이_0원이면_IllegalArgumentException_예외를_던진다() {
        //given
        int payAmount = 0;

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new Purchase(payAmount);
        });
    }

    @Test
    void 구입_금액이_0원이면_checkNonNegative_메서드에서_예외를_던진다() {
        //given
        int payAmount = 0;
        String methodName = "checkNonNegative";

        try {
            new Purchase(payAmount);
        } catch (IllegalArgumentException e) {
            String throwsFromMethod = e.getStackTrace()[0].getMethodName();
            assertEquals(methodName, throwsFromMethod);
        }
    }

    @Test
    void 구입_금액이_음수이면_IllegalArgumentException_예외를_던진다() {
        //given
        int payAmount = -2000;

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new Purchase(payAmount);
        });
    }

    @Test
    void 구입_금액이_음수이면_checkNonNegative_메서드에서_예외를_던진다() {
        //given
        int payAmount = -2000;
        String methodName = "checkNonNegative";

        try {
            new Purchase(payAmount);
        } catch (IllegalArgumentException e) {
            String throwsFromMethod = e.getStackTrace()[0].getMethodName();
            assertEquals(methodName, throwsFromMethod);
        }
    }

    @Test
    void 구입_금액이_4000원이면_4장의_로또를_구입한다() {
        //given
        int payAmount = 4000;
        Purchase purchase = new Purchase(payAmount);
        Lottos purchasedLottos = purchase.getPurchasedLottos();

        int actualNumberOfLottos = 0;
        Iterator<Lotto> lottoIterator = purchasedLottos.iterator();

        //when
        while(lottoIterator.hasNext()) {
            actualNumberOfLottos++;
            lottoIterator.next();
        }

        //then
        assertEquals(4, actualNumberOfLottos);
    }
}

