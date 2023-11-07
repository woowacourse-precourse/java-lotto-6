package lotto.domain;

import java.util.Map;
import lotto.Dto.SingleResultDto;
import lotto.Dto.TotalResultDto;
import lotto.constant.constants.Config;
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


    public TotalResultDto simulate() {
        TotalResultDto totalResultDto = new TotalResultDto();

        int totalWonPrize = 0;

        for (Prize prize : Prize.values()) {
            SingleResultDto singleResultDto = calculateWonLottery(prize);
            totalResultDto.add(singleResultDto.getMatch(), calculateWonLottery(prize));
            totalWonPrize += singleResultDto.getWon() * singleResultDto.getPrize();
        }
        totalResultDto.setProfit(calculateProfit(totalWonPrize));

        return totalResultDto;
    }


    private double calculateProfit(Integer wonPrize) {
        int spentMoney = myLottos.size() * Config.LOTTO_PRICE.getConfig();
        return (double) wonPrize / spentMoney * 100;
    }

    // singleResultDto: [matched, won, prize]
    private SingleResultDto calculateWonLottery(Prize prize) {
        SingleResultDto singleResultDto = new SingleResultDto();
        singleResultDto.setMatched(prize.getMatched());
        singleResultDto.setWon(myLottos.calculateMatched(winnerLotto, bonusNumber, prize));
        singleResultDto.setPrize(prize.getPrize());
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
        if (number < Config.LOTTO_MIN_NUMBER.getConfig() || number > Config.LOTTO_MAX_NUMBER.getConfig()) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}