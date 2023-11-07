package lotto;

import lotto.model.dao.LottoDAO;
import lotto.model.vo.SeasonLottoResultVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoDaoTest {
    private LottoDAO dao = new LottoDAO();
    @DisplayName("VO에 로또 번호와 보너스 번호 담기 구현")
    @Test
    public void insertTest(){
        SeasonLottoResultVO row = dao.insertLotto();
        System.out.println(row.getAutoLottoNumber());
        System.out.println(row.getAutoBonusNumber());
        Assertions.assertNotNull(row);
    }


}
