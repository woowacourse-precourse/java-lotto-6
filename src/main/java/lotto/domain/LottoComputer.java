package lotto.domain;

import lotto.Dto.SingleResultDto;
import lotto.Dto.TotalResultDto;
import lotto.constant.constants.Config;
import lotto.constant.constants.Prize;
import lotto.constant.messages.Error;

public class LottoComputer {


    private Lotto winningLotto;
    private Lottos boughtLottos;
    private Integer bonus;


    public void configBonus(String bonus) {
        validateBonus(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    public void configBoughtLottos(Lottos boughtLottos) {
        this.boughtLottos = boughtLottos;
    }

    public void configWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }


    public TotalResultDto simulate() {
        TotalResultDto totalResultDto = new TotalResultDto();

        int totalWonPrize = 0;

        for (Prize prize : Prize.values()) {
            SingleResultDto singleResultDto = calculateWonLottery(prize);
            totalResultDto.add(singleResultDto);
            totalWonPrize += singleResultDto.getWon() * singleResultDto.getPrize();
        }
        totalResultDto.setProfit(calculateProfit(totalWonPrize));

        return totalResultDto;
    }


    private double calculateProfit(Integer wonPrize) {
        int spentMoney = boughtLottos.size() * Config.LOTTO_PRICE.getConfig();
        return (double) wonPrize / spentMoney * 100;
    }

    // singleResultDto: [matched, won, prize]
    private SingleResultDto calculateWonLottery(Prize prize) {
        SingleResultDto singleResultDto = new SingleResultDto();
        singleResultDto.setMatched(prize.getMatched());
        singleResultDto.setWon(boughtLottos.calculateMatched(winningLotto, bonus, prize));
        singleResultDto.setPrize(prize.getPrize());
        return singleResultDto;
    }


    public void validateBonus(String bonus) {
        validateAllDigit(bonus);
        validateNumberRange(bonus);
    }


    private void validateAllDigit(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(Error.NOT_DIGIT.getMessage());
        }
    }

    private void validateNumberRange(String input) {
        if (input.length() > 2) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
        int number = Integer.parseInt(input);
        if (number < Config.LOTTO_MIN_NUMBER.getConfig() || number > Config.LOTTO_MAX_NUMBER.getConfig()) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}