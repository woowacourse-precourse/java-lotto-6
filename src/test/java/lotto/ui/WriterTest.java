package lotto.ui;

import java.util.List;
import lotto.constance.PrintConst;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

class WriterTest {
    @Test
    public void printModels() throws Exception{
        //given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        //when
        Writer.printModelsInList(PrintConst.FORMAT_LOTTO_NUMBERS, lottos);
        //then
    }

}