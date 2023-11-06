package lotto.app;

import static lotto.enums.LottoCalculateNums.MIN_WINNING;
import static lotto.enums.LottoCalculateNums.WON;
import static lotto.utils.LottoUtils.createLottoList;
import static lotto.utils.LottoUtils.createLottoResultDTO;
import static lotto.utils.LottoUtils.initResultMap;
import static lotto.utils.LottoUtils.matchLotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoResultDTO;
import lotto.enums.LottoAmount;
import lotto.utils.LottoPrompt;
import lotto.utils.LottoUtils;

public class LottoGame {
    List<Lotto> lottoList;
    List<LottoResult> lottoResultList;

    public void startGame(){
        int purchaseLottoCount = LottoPrompt.inputPurchaseAmount();

        lottoList = createLottoList(purchaseLottoCount);
        LottoPrompt.printLottoList(lottoList);

        List<Integer> winningNumbers = LottoPrompt.inputWinningNumbers();
        int bonusNumber = LottoPrompt.inputBonusNumber();

        lottoResultList = matchLotto(lottoList, winningNumbers, bonusNumber);
        HashMap<String, Integer> resultMap = initResultMap();
        LottoResultDTO lottoResultDTO = createLottoResultDTO(lottoResultList, resultMap, purchaseLottoCount * WON);

        LottoPrompt.printLottoResult(lottoResultDTO);
    }

}
