package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.ResultDto;
import lotto.embedded.LottoResult;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    private final static int LOTTO_PRICE = 1000;

    public void run() {
        outputView.printTotalPriceAsk();
        int totalPrice = inputView.receiveTotalPrice();
        int lottoCount = calculateLottoCount(totalPrice);

        outputView.printLottoCount(lottoCount);
        List<Lotto> lottoList = createLottoList(lottoCount);
        outputView.printLottoList(lottoList);

        outputView.printWinningNumberAsk();
        Lotto winning = inputView.receiveLottoWinning();

        outputView.printBonusNumberAsk();
        int bonusNumber = inputView.receiveBonusNumber(winning);

        ResultDto result = calculateTotalResult(winning, bonusNumber, totalPrice, lottoList);
        outputView.printResult(result);
    }

    public int calculateLottoCount(int totalPrice) {
        return totalPrice / LOTTO_PRICE;
    }

    public List<Lotto> createLottoList(int lottoCount) {
        ArrayList<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = getLottoNumbers();
            lottoList.add(new Lotto(lottoNumbers));
        }
        return lottoList;
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers.stream().sorted().toList();
    }

    public ResultDto calculateTotalResult(Lotto winning, int bonusNumber, int totalPrice, List<Lotto> lottoList) {
        Map<LottoResult, Integer> lottoResultMap = new HashMap<>();
        int totalPrize = 0;

        for (Lotto lotto : lottoList) {
            LottoResult lottoResult = calculateLottoResult(winning, bonusNumber, lotto);

            if (lottoResult.isWin()) {
                lottoResultMap.merge(lottoResult, 1, Integer::sum);
                totalPrize += lottoResult.getPrize();
            }
        }
        double roundedYield = getRoundedYield(totalPrice, totalPrize);

        return new ResultDto(lottoResultMap, roundedYield);
    }

    public double getRoundedYield(int totalPrice, long totalPrize) {
        double yield = ((double) totalPrize / (double) totalPrice * 100);
        return Math.round(yield * 10.0) / 10.0;
    }

    public LottoResult calculateLottoResult(Lotto winning, int bonusNumber, Lotto lotto) {
        List<Integer> myLottoNums = lotto.getNumbers();
        List<Integer> winningNums = winning.getNumbers();
        long matchCount = myLottoNums.stream()
                .filter(winningNums::contains)
                .count();
        boolean isBonusMatch = myLottoNums.contains(bonusNumber);

        return LottoResult.of((int) matchCount, isBonusMatch);
    }
}
