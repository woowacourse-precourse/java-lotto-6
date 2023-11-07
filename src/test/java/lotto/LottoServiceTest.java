package lotto;

import lotto.model.vo.SeasonLottoResultVO;
import lotto.service.domain.lotto.LottoService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoServiceTest {

    private LottoService ls = new LottoService();

    @Test
    public void flexTest() {
        int num = 5;
        List<SeasonLottoResultVO> list = new ArrayList<>();
        list = ls.numberOfLottoPurchases(num);
        for (int i = 0; i < num; i++) {
            System.out.println(list.get(i).getAutoLottoNumber());
            System.out.println(list.get(i).getAutoBonusNumber());
        }
    }

}
