package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.Dto.SingleResultDto;
import lotto.Dto.TotalResultDto;
import lotto.constants.Constant;
import lotto.constants.messages.Error;

public class LottoComputer {


    private Lotto winnerLotto;
    private Integer bonusNumber;

    private Lottos myLottos;

    // matched / prize
    Map<Integer, Integer> prizes = new HashMap<>() {{
        put(3, Constant.MATCHED_THREE_PRICE.getConstant());
        put(4, Constant.MATCHED_FOUR_PRICE.getConstant());
        put(5, Constant.MATCHED_FIVE_PRICE.getConstant());
        put(6, Constant.MATCHED_SIX_PRICE.getConstant());
        put(7, Constant.MATCHED_FIVE_ONE_BONUS_PRICE.getConstant());
    }};

    public void config(Lottos myLottos) {
        this.myLottos = myLottos;
    }

    public void config(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }


    public void config(Lotto winnerLotto) {
        this.winnerLotto = winnerLotto;
    }


    public TotalResultDto simulate() {
        TotalResultDto totalResultDto = new TotalResultDto();

        for (int won = 3; won <= 7; won++) {
            totalResultDto.add(won, calculateWonLottery(won));
        }
        totalResultDto.setProfit(calculateProfit(totalResultDto));

        return totalResultDto;
    }


    private double calculateProfit(TotalResultDto totalWon) {
        int totalPrize = 0;
        int spentMoney = myLottos.size() * 1000;
        for (int i = 3; i <= 7; i++) {
            totalPrize += totalWon.getSingleResult(i).getWon() * totalWon.getSingleResult(i).getPrize();
        }
        return (double) totalPrize / spentMoney * 100;
    }

    // [match, bonus, prize, won]
    private SingleResultDto calculateWonLottery(int won) {
        SingleResultDto singleResultDto = new SingleResultDto();

        singleResultDto.setMatch(won);
        singleResultDto.setWon(myLottos.match(winnerLotto, won));
        singleResultDto.setPrize(this.prizes.get(won));
        if (won == 7) {
            singleResultDto.setMatch(5);
        }
        return singleResultDto;
    }


    public void validateBonus(String val) {
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