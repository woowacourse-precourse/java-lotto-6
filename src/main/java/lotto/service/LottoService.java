package lotto.service;

import static lotto.domain.LottoConstraint.PERCENT;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoConstraint;
import lotto.domain.LottoPrize;
import lotto.domain.LottoRepository;
import lotto.domain.WinningNumber;
import lotto.dto.LottoRepositoryDto;
import lotto.dto.LottoResultDto;
import lotto.dto.Money;
import lotto.util.RandomLottoNumGenerator;
import lotto.util.Validation;

public class LottoService {
    private final LottoRepository lottoRepository = new LottoRepository();

    public LottoRepositoryDto buyLotto(Money money){
        int tickets;
        try {
            tickets = Validation.validateDivide(Validation.validateInt(money.getMoney()), LottoConstraint.MIN_PRICE);
        }catch (IllegalArgumentException e){
            throw e;
        }
        for (int ticket=0; ticket < tickets;ticket++){
            lottoRepository.addOne(new Lotto(RandomLottoNumGenerator.generateLotto()));
        }
        return new LottoRepositoryDto(lottoRepository.getLottoRepository());
    }

    public LottoResultDto getResult(WinningNumber winningNumber){
        // 결과 생성
        setResult(winningNumber);

        // 결과 반환
        EnumMap<LottoPrize, Integer> result = lottoRepository.getLottoResult();

        //수익률 계산
        double profitRate = calculateProfit(result);
        // Dto 에 담아 전송
        return new LottoResultDto(result,profitRate);
    }
    private void setResult(WinningNumber winningNumber){
        for(Lotto lotto:lottoRepository.getLottoRepository()){
            int matchingNumber = winningNumber.findMatchingNumber(lotto);
            boolean isBonus = false;
            if(matchingNumber == 5){
                isBonus = winningNumber.isBonusNumber(lotto);
            }
            lottoRepository.addResult(LottoPrize.findRank(matchingNumber,isBonus));
        }
    }

    private double calculateProfit(Map<LottoPrize, Integer> result){
        int totalPrize = 0;
        for (Map.Entry<LottoPrize, Integer> entry : result.entrySet()){
            LottoPrize prize = entry.getKey();
            int count = entry.getValue();
            totalPrize += count * prize.getPrizeAmount();
        }
        double totalSpent = calculateTotalSpent();
        double profit  = (totalPrize/ totalSpent) *PERCENT;
        return  Math.round(profit * PERCENT) / PERCENT;
    }
    private double calculateTotalSpent(){
        return LottoConstraint.MIN_PRICE * lottoRepository.getLottoRepository().size();
    }
}
