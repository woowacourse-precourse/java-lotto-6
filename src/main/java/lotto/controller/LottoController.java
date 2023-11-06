package lotto.controller;

import lotto.model.dto.BuyInfo;
import lotto.model.dto.Lotto;
import lotto.model.dto.LottoBonus;
import lotto.model.vo.SeasonLottoResultVO;
import lotto.service.domain.lotto.LottoIoService;
import lotto.service.domain.lotto.LottoService;
import lotto.view.LottoOutputPrint;

import java.util.List;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    private final LottoIoService lottoIoService = new LottoIoService();
    private final LottoOutputPrint outputPrint = new LottoOutputPrint();
    public BuyInfo buyInfo(BuyInfo input){
        // 티켓의 구매 정보를 만들어 줌
        return lottoIoService.inputPriceGetBuyInfo(input);
    }
    public List<SeasonLottoResultVO> createAutoLottoBuyChoice(int pick){
        // 구매한 금액 만큼 티켓을 만들어 줌
        return lottoService.numberOfLottoPurchases(pick);
    }
    public void showAutoLottoTicks(int cycle,List<SeasonLottoResultVO> tickets){
        // 구매 횟수와 티켓 정보를 입력 받아서 List-Println 해줌
        //음의 기대값 이라 반복 중에 같은 것이 있는지 확인은 나중에 해도 괜찮을 듯
        outputPrint.autoLottoTickMaker(cycle,tickets);
    }
    public Lotto userInputMasterLottoNumbers(){
        return lottoIoService.userPickMasterLottoNumbers();
    }
int 커밋용도로_임시생성 = 1;
    public LottoBonus userInputMasterLottoBonusNumber(Lotto lotto){
        return lottoIoService.userPickMasterBonusNumberOne(lotto);
    }




}
