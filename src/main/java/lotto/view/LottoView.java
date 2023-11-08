package lotto.view;

import static lotto.etc.ErrorConstant.ERROR_TYPE_ILLEGAL_ARGUMENT;
import static lotto.etc.SystemConstant.BONUS;
import static lotto.etc.SystemConstant.BUY;
import static lotto.etc.SystemConstant.FIVE_BONUS_SAMECONSTANT;
import static lotto.etc.SystemConstant.FIVE_SAMECONSTANT;
import static lotto.etc.SystemConstant.FOUR_SAME;
import static lotto.etc.SystemConstant.JACKPOT;
import static lotto.etc.SystemConstant.RATE_OF_RETURN;
import static lotto.etc.SystemConstant.SIX_SAME;
import static lotto.etc.SystemConstant.START;
import static lotto.etc.SystemConstant.THREE_SAME;
import static lotto.etc.SystemConstant.WINNING_STATISTICS;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.dto.CountScoreResponseDTO;

public class LottoView {
    private LottoController lottoController;
    public LottoView(){
        this.lottoController = LottoController.getInstance();
    }

    public void start() {
        setLottoBudget();
        parseLotto();
        parseBonusInteger();
        lottoResult();
    }

    private void setLottoBudget() {
        while (true) {
            try {
                System.out.println(START);
                String money = Console.readLine();
                List<Lotto> tickets = lottoController.setLottoBudget(money);

                System.out.printf(BUY.toString(), tickets.size());
                tickets.stream()
                    .forEach(ticket -> System.out.println(ticket.getNumbers().toString()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_TYPE_ILLEGAL_ARGUMENT.toString() + e.getMessage());
            }
        }
    }

    private void parseLotto() {
        while (true) {
            try {
                System.out.println(JACKPOT);
                String number = Console.readLine();
                lottoController.createUserLottoNumber(number);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_TYPE_ILLEGAL_ARGUMENT.toString() + e.getMessage());
            }
        }
    }

    private void parseBonusInteger() {
        while (true) {
            try {
                System.out.println(BONUS);
                String bonus = Console.readLine();
                lottoController.createBonusNumber(bonus);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_TYPE_ILLEGAL_ARGUMENT.toString() + e.getMessage());
            }
        }
    }

    private void lottoResult() {
        CountScoreResponseDTO countScoreResponseDTO = lottoController.countScore();
        System.out.println(WINNING_STATISTICS);
        System.out.printf(THREE_SAME.toString(), countScoreResponseDTO.getFifthPlace());
        System.out.printf(FOUR_SAME.toString(), countScoreResponseDTO.getFourthPlace());
        System.out.printf(FIVE_SAMECONSTANT.toString(), countScoreResponseDTO.getThirdPlace());
        System.out.printf(FIVE_BONUS_SAMECONSTANT.toString(), countScoreResponseDTO.getSecondPlace());
        System.out.printf(SIX_SAME.toString(), countScoreResponseDTO.getFirstPlace());
        System.out.printf(RATE_OF_RETURN.toString(), countScoreResponseDTO.getRateOfReturn());
    }
}
