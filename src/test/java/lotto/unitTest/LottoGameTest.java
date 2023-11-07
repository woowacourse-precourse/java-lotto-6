//package lotto.unitTest;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import lotto.domain.LottoGame;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//public class LottoGameTest {
//    public static InputStream setReadLine(String readLine) {
//        return new ByteArrayInputStream(readLine.getBytes());
//    }
//
//    @Test
//    void 로또가격_입력받기() {
//        LottoGame lottoGame = new LottoGame();
//
//        String expected = "5000";
//        InputStream readLine = setReadLine(expected);
//        System.setIn(readLine);
//
//        int actual = readLottoPrice();
//        assertEquals(Integer.parseInt(expected), actual);
//    }
//}
