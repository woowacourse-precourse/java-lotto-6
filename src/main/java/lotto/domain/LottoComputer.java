package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Dto.LottoResultDto;
import lotto.constants.Constant;
import lotto.constants.messages.Error;

public class LottoComputer {

    private Lotto winnerLotto;
    private Integer bonusNumber;

    private Lottos myLottos;

    List<Integer> s = new ArrayList<>(List.of(
            Constant.MATCHED_SIX_PRICE.getConstant(),
            Constant.MATCHED_FIVE_ONE_BONUS_PRICE.getConstant(),
            Constant.MATCHED_FIVE_PRICE.getConstant(),
            Constant.MATCHED_FOUR_PRICE.getConstant(),
            Constant.MATCHED_THREE_PRICE.getConstant()
    ));

    public void config(Lottos myLottos) {
        this.myLottos = myLottos;
    }

    public void config(String bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public void config(Lotto winnerLotto) {
        this.winnerLotto = winnerLotto;
    }


    public LottoResultDto simulate() {
        LottoResultDto lottoResultDto = new LottoResultDto();
        List<List<Integer>> wonLottery = calculateWonLottery();
        lottoResultDto.setResult(wonLottery);
        lottoResultDto.setProfit(calculateProfit(wonLottery));
        return lottoResultDto;
    }


    private double calculateProfit(List<List<Integer>> wonLottery) {

        int totalPrize = 0;
        int spentMoney = myLottos.size() * 1000;
        for (int i = 0; i < wonLottery.size(); i++) {
            totalPrize += wonLottery.get(i).get(3) * s.get(i);
        }
        return (double) totalPrize / spentMoney * 100;
    }

    // [match, bonus, prize, won]
    private List<List<Integer>> calculateWonLottery() {
        List<List<Integer>> result = new ArrayList<>();
        int x = 0;
        for (int i = 6; i >= 3; i--) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(i); // match
            tmp.add(0); // bonus
            tmp.add(s.get(x++)); // prize
            tmp.add(myLottos.match(winnerLotto, i)); // won
            result.add(tmp);
        }
        return result;
    }


    private void validate(String val) {
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