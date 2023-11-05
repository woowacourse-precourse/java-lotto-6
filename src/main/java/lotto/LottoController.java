package lotto;

import static lotto.domain.util.LottoParser.*;

import java.util.*;
import lotto.domain.*;
import lotto.domain.numbergenerator.NumberGenerator;
import lotto.exception.InputException;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoMachine lottoMachine;
    private NumberGenerator numberGenerator;

    public LottoController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        // 로또 발행
        List <Lotto> lottos = generateLottos();
        // 발행 로또 출력
        outputView.printLottoNumbers(parseLottoToInteger(lottos));
        // 로또 당첨 판단 체크 객체 생성
        LottoWinningChecker lottoWinningChecker = initLottoWinningChecker();
        // 당첨 등수 맵 생성
        Map<LottoRank, Integer> rankCount = getResultRankCount(lottos, lottoWinningChecker);
        // 결과 출력하기
        showResult(rankCount);
    }

    private int receiveValidLottoCount() {
        outputView.printInputMoneyMessage();
        try {
            String money = inputView.inputMoney();
            return parseMoneyToLottoCount(money);
        } catch (InputException | LottoException e) {
            System.out.println(e.getMessage());
            return receiveValidLottoCount();
        }
    }

    private List<Lotto> generateLottos() {
        // 검증된 금액 입력 받기
        int lottoCount = receiveValidLottoCount();
        lottoMachine = new LottoMachine(lottoCount, numberGenerator);
        lottoMachine.makeLottos();
        return lottoMachine.getLottos();
    }

    private List<Integer> receiveValidWinningNumbers() {
        outputView.printInputWinningNumbersMessage();
        try {
            String winningNumbers = inputView.inputWinningNumber();
            return parseWinningNumbers(winningNumbers);
        } catch (InputException | LottoException e) {
            System.out.println(e.getMessage());
            return receiveValidWinningNumbers();
        }
    }

    private int receiveValidBonusNumber() {
        outputView.printInputBonusNumberMessage();
        try {
            String bonusNumber = inputView.inputBonusNumber();
            return parseBonusNumber(bonusNumber);
        } catch (InputException | LottoException e) {
            System.out.println(e.getMessage());
            return receiveValidBonusNumber();
        }
    }

    private LottoWinningChecker initLottoWinningChecker() {
        List<Integer> validWinningNumbers = receiveValidWinningNumbers();
        int validBonusNumber = receiveValidBonusNumber();

        return new LottoWinningChecker(validWinningNumbers, validBonusNumber);
    }

    private Map<LottoRank, Integer> getResultRankCount(List <Lotto> lottos, LottoWinningChecker lottoWinningChecker) {
        Map<LottoRank, Integer> rankCount = new LinkedHashMap<>();
        for(LottoRank lottoRank: LottoRank.values()) {
            rankCount.put(lottoRank, 0);
        }
        for(Lotto lotto: lottos) {
            LottoRank rank = lottoWinningChecker.getRank(lotto);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }
        return rankCount;
    }

    private void showResult(Map<LottoRank, Integer> rankCount) {
        outputView.printRanksCount(rankCount);
        outputView.printRateOfProfits(rankCount);
    }
}
