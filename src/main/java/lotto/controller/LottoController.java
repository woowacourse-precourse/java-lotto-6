package lotto.controller;

import lotto.model.vo.SeasonLottoResultVO;
import lotto.service.domain.lotto.LottoIoService;
import lotto.service.domain.lotto.LottoService;
import lotto.view.LottoOutputPrint;

import java.util.List;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    private final LottoIoService lottoIoService = new LottoIoService();
    private final LottoOutputPrint outputPrint = new LottoOutputPrint();
    public List<SeasonLottoResultVO> createAutoLottoBuyChoice(int pick){
        // 구매한 금액 만큼 티켓을 만들어줌
        return lottoService.numberOfLottoPurchases(pick);
    }

    public void showAutoLottoTicks(int cycle,List<SeasonLottoResultVO> tickets){
        // 구매 횟수와 티켓 정보를 입력 받아서 리스트를 출력해줌
        outputPrint.autoLottoTickMaker(cycle,tickets);
    }
    //음의 기대값이라 반복중에 같은 것이 있는지 확인은 나중에 해도 괜찮을 듯




}
