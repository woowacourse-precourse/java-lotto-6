package lotto;

import lotto.io.LottoInputReader;
import lotto.service.convert.ConvertService;
import lotto.service.domain.lotto.LottoIoService;
import lotto.view.LottoOutputPrint;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class LottoIoServiceTest {

    private LottoIoService ls = new LottoIoService();
    private LottoInputReader input;
    private LottoOutputPrint result = new LottoOutputPrint();
    private ConvertService convert = new ConvertService();

    @Test
    public void inputAndOutputPriceTest(){

        String priceString = "1000\n";
        InputStream in = new ByteArrayInputStream(priceString.getBytes());
        System.setIn(in);
        input = new LottoInputReader();
        priceString = input.readerLottoPrice();
        System.out.println(priceString);
        System.setIn(System.in);
    }

}
