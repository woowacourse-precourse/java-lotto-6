package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.ResultDto;
import lotto.model.LottoResult;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

/**
 * Lotto 컨트롤러 클래스
 */
public class LottoController {
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    private final static int LOTTO_PRICE = 1000;

    /**
     * 로직 실행 메서드
     */
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

    /**
     * 가격에 따른 로또 구매 개수 계산
     * @param totalPrice 로또 구매 가격(1000의 배수)
     * @return 로또 구매 개수
     */
    public int calculateLottoCount(int totalPrice) {
        return totalPrice / LOTTO_PRICE;
    }

    /**
     * 구매한 로또 개수 만큼 로또 번호 생성
     * @param lottoCount 구매한 로또의 개수
     * @return {@link Lotto} 리스트
     */
    public List<Lotto> createLottoList(int lottoCount) {
        ArrayList<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = getLottoNumbers();
            lottoList.add(new Lotto(lottoNumbers));
        }
        return lottoList;
    }

    /**
     * 로또 번호 계산
     * @return 로또 번호 리스트
     */
    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers.stream().sorted().toList();
    }

    /**
     * 전체 로또 구매 결과 계산
     * @param winning 1등 로또 번호
     * @param bonusNumber 보너스 번호
     * @param totalPrice 로또 구매 총 금액
     * @param lottoList 구매한 로또 리스트
     * @return {@link ResultDto} 결과 맵, 수익률
     */
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

    /**
     * 수익률(%) 소숫점 두번째 자리에서 반올림하여 계산
     * @param totalPrice 총 로또 구매 금액
     * @param totalPrize 총 상금
     * @return 소숫점 두번째 자리에서 반올림한 수익률(%)
     */
    public double getRoundedYield(int totalPrice, long totalPrize) {
        double yield = ((double) totalPrize / (double) totalPrice * 100);
        return Math.round(yield * 10.0) / 10.0;
    }

    /**
     * 개별 로또 번호에 대한 결과 계산
     * @param winning 1등 로또 번호
     * @param bonusNumber 보너스 번호
     * @param lotto 계산 대상 로또
     * @return {@link Lotto}
     */
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
