package lotto;

import lombok.RequiredArgsConstructor;
import lotto.dto.LottoResultAndProfitResponseDto;
import lotto.service.LottoService;

import java.util.List;

@RequiredArgsConstructor
public class Application {
    private final LottoService lottoService;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService();
        int lottoCount = lottoService.inputAmountAndGetLottoCount();
        List<Integer> lottoNum = lottoService.inputLottoNum();
        List<List<Integer>> userLottoNum = lottoService.getUserLottoNum(lottoCount);
        int bonusNum = lottoService.getBonusNum();
        LottoResultAndProfitResponseDto lottoResultAndProfitResponseDto = lottoService.getLottoResultResponse(userLottoNum, lottoNum,bonusNum);
        lottoService.PrintResult(lottoResultAndProfitResponseDto);
    }
}
