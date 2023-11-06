package lotto.service.domain.lotto;

import lotto.model.dao.LottoDAO;
import lotto.model.dto.Lotto;
import lotto.model.dto.LottoBonus;
import lotto.model.vo.SeasonLottoResultVO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {

    private LottoDAO dao = new LottoDAO();
    private Lotto lotto;

    // 로또 구매 건수
    public List<SeasonLottoResultVO> numberOfLottoPurchases(int pick) {
        List<SeasonLottoResultVO> list = new ArrayList<>();
        for (int i = 0; i < pick; i++) {
            SeasonLottoResultVO row = dao.insertLotto();
            list.add(row);
        }
        return list;
    }



}
