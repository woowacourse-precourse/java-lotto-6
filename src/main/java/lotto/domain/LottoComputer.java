package lotto.domain;

import java.util.Map;
import java.util.TreeMap;
import lotto.Dto.SingleResultDto;
import lotto.Dto.TotalResultDto;
import lotto.constant.constants.Prize;
import lotto.constant.messages.Error;

public class LottoComputer {


    private Lotto winnerLotto;
    private Integer bonusNumber;

    private Lottos myLottos;

    // matched / prize
    Map<Integer, Integer> prizes;


    public void config(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public void config(Lottos myLottos) {
        this.myLottos = myLottos;
    }

    public void config(Lotto winnerLotto) {
        this.winnerLotto = winnerLotto;
    }


    private Map<Integer, Integer> makePrizes() {
        prizes = new TreeMap<>();
        Prize[] s = Prize.values();
        for (Prize a : s) {
            prizes.put(a.getCode(), a.getPrize());
        }
        return prizes;
    }

    public TotalResultDto simulate() {
        TotalResultDto totalResultDto = new TotalResultDto();
        prizes = makePrizes();

        for (Integer key : prizes.keySet()) {
            totalResultDto.add(key, calculateWonLottery(key));
        }
        totalResultDto.setProfit(calculateProfit(totalResultDto));

        return totalResultDto;
    }


    private double calculateProfit(TotalResultDto totalWon) {
        int totalPrize = 0;
        int spentMoney = myLottos.size() * 1000;
        for (Integer key : prizes.keySet()) {
            totalPrize += totalWon.getSingleResult(key).getWon() * totalWon.getSingleResult(key).getPrize();
        }
        return (double) totalPrize / spentMoney * 100;
    }

    // singleResultDto: [match, bonus, prize, won]
    private SingleResultDto calculateWonLottery(int won) {
        SingleResultDto singleResultDto = new SingleResultDto();
        singleResultDto.setMatch(won);
        singleResultDto.setWon(myLottos.match(winnerLotto, won));
        singleResultDto.setPrize(this.prizes.get(won));
        if (won == Prize.FIVE_AND_BONUS_MATCHED.getCode()) {
            singleResultDto.setMatch(5);
        }
        return singleResultDto;
    }


    public void validateBonusNumber(String val) {
        validateAllDigit(val);
        validateNumberRange(Integer.parseInt(val));
    }


    private void validateAllDigit(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(Error.NOT_DIGIT.getMessage());
        }
    }

    private void validateNumberRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }


}