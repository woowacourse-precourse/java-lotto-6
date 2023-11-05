package lotto.model.dao;

import lotto.model.vo.SeasonLottoResultVO;
import lotto.service.domain.lotto.CreateAutoLottoNumber;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

@DisplayName("데이터 엑세스의 경로가 DB가 아님 - 짝퉁 DAO")
public class LottoDAO {
    private static final CreateAutoLottoNumber cs = new CreateAutoLottoNumber();

    public SeasonLottoResultVO insertLotto(){
        SeasonLottoResultVO list = new SeasonLottoResultVO();
        list.setAutoLottoNumber(cs.getLottoSixNumbers());
        list.setAutoBonusNumber(cs.getBonusNumber());
        return list;
    }

}
