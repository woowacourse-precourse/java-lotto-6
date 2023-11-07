package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.dto.ResultDto;
import lotto.embedded.LottoResult;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    private final static int LOTTO_PRICE = 1000;

    public void run(){
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

    public int calculateLottoCount(int totalPrice){
        final int lottoPrice = 1000;
        return totalPrice / lottoPrice;
    }

    public List<Lotto> createLottoList(int lottoCount){
        ArrayList<Lotto> lottoList = new ArrayList<>();

        for(int i=0; i< lottoCount; i++){
            List<Integer> lottoNumbers = getLottoNumbers();
            lottoList.add(new Lotto(lottoNumbers));
        }
        return lottoList;
    }

    private static List<Integer> getLottoNumbers(){
        ArrayList<Integer> numbers = new ArrayList<>();
        while(numbers.size() < 6){
            int random = Randoms.pickNumberInRange(1, 45);
            if(!numbers.contains(random)){
                numbers.add(random);
            }
        }
        numbers.sort(Integer::compare);
        return numbers;
    }

    private static ResultDto calculateTotalResult(Lotto winning, int bonusNumber, int totalPrice,List<Lotto> lottoList){
        Map<LottoResult, Integer> lottoResultMap = new HashMap<>();
        int totalPrize = 0;

        for(Lotto lotto : lottoList){
            Optional<LottoResult> lottoResultOptional = calculateLottoResult(winning, bonusNumber, lotto);

            if(lottoResultOptional.isPresent()){
                lottoResultMap.merge(lottoResultOptional.get(), 1, Integer::sum);
                totalPrize += lottoResultOptional.get().getPrize();
            }
        }
        double yield = ((double) (totalPrize - totalPrice) / totalPrice * 100);
        double roundedYield = Math.round(yield * 10.0) / 10.0;

        return new ResultDto(lottoResultMap, roundedYield);
    }

    private static Optional<LottoResult> calculateLottoResult(Lotto winning, int bonusNumber, Lotto lotto) {
        List<Integer> myLottoNums = lotto.getNumbers();
        List<Integer> winningNums = winning.getNumbers();
        long matchCount = myLottoNums.stream()
                .filter(winningNums::contains)
                .count();
        boolean isBonusMatch = myLottoNums.contains(bonusNumber);

        return LottoResult.of((int) matchCount, isBonusMatch);
    }
}
