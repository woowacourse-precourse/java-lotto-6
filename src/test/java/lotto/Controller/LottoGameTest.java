package lotto.Controller;

import static lotto.Controller.LottoGame.generateLotto;

import java.util.List;
import lotto.Model.Lotto;
import org.junit.jupiter.api.Test;

public class LottoGameTest {
    @Test
    void n개로또구매_출력해보기(){
        List<Lotto> lottoList = generateLotto(2);
        for(int i=0; i<lottoList.size();i++){
            System.out.println(lottoList.get(i).printLotto());
        }
    }
}
