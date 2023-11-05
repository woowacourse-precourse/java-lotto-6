package lotto.view;

import lotto.model.vo.SeasonLottoResultVO;

import java.util.List;

public class LottoOutputPrint {

    public void printLottoPrice(int num){
        System.out.println(num + "개를 구매했습니다.");
    }
    public int printLottoNumbers(int num){
        return 0;
    }
    public int printChoiceLottoBonusNumber(int num){
        return 0;
    }

    public void autoLottoTickMaker
      (int pick, List<SeasonLottoResultVO> Tickets)
    {
        for(int i = 0; i < pick; i++){
            System.out.println(Tickets.get(i).getAutoLottoNumber());
        }
    }


}
