package lotto.service.domain.lotto;

import lotto.io.LottoPrizeResult;
import lotto.model.dao.LottoDAO;
import lotto.model.dto.BuyInfo;
import lotto.model.dto.Lotto;
import lotto.model.dto.LottoBonus;
import lotto.model.dto.Yield;
import lotto.model.vo.SeasonLottoResultVO;
import lotto.view.LottoResultPrint;

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
    public Double yieldCalculation(Yield yieldAttribute){
        return
          ((double)
            yieldAttribute.getTotalPrize() - yieldAttribute.getInvestmen()
          ) / yieldAttribute.getInvestmen() * 100;
    }
    public LottoResultPrint ticketMatchUserPickNumber
      (List<SeasonLottoResultVO> autoLottoTicket,
       Lotto userLottoNumbers,
       LottoBonus lottoBonus)
    {
        LottoResultPrint lottoResultPrint = new LottoResultPrint();
        for (SeasonLottoResultVO ticket : autoLottoTicket){
            int matchPoint = 0;
            for(int number : ticket.getAutoLottoNumber()){
                if(userLottoNumbers.getNumbers().contains(number)){
                    matchPoint++;
                }
            }
            boolean bonusMatch = false;
            bonusMatch = ticket.getAutoLottoNumber().contains(lottoBonus.getNumber().get(0));
            lottoResultPrint.addResult(matchPoint,bonusMatch);
        }
        return lottoResultPrint;
    }

}
