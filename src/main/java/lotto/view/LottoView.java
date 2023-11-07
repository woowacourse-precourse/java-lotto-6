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
import lotto.dto.BonusRequestDTO;
import lotto.dto.CountScoreRequestDTO;
import lotto.dto.CountScoreResponseDTO;

public class LottoView {
    private List<Lotto> lottoTickets;
    private Lotto userLotto;
    private int bonus;
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
                this.lottoTickets = tickets;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_TYPE_ILLEGAL_ARGUMENT.toString() + e.getMessage());
            }
        }

        System.out.printf(BUY.toString(), lottoTickets.size());
        lottoTickets.stream()
                .forEach(ticket -> System.out.println(ticket.getNumbers().toString()));
    }

    private void parseLotto() {
        while (true) {
            try {
                System.out.println(JACKPOT);
                String number = Console.readLine();
                this.userLotto = LottoController.getInstance()
                        .createUserLottoNumber(number);
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
                BonusRequestDTO bonusRequestDTO = new BonusRequestDTO.Builder()
                        .lotto(userLotto)
                        .bonus(bonus)
                        .build();
                this.bonus = lottoController
                        .createBonusNumber(bonusRequestDTO);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_TYPE_ILLEGAL_ARGUMENT.toString() + e.getMessage());
            }
        }
    }

    private void lottoResult() {
        CountScoreRequestDTO countScoreRequestDTO = new CountScoreRequestDTO.Builder()
                .lottoTickets(lottoTickets)
                .numbers(userLotto)
                .bonus(bonus)
                .build();

        CountScoreResponseDTO countScoreResponseDTO = lottoController.countScore(countScoreRequestDTO);

        printResult(countScoreResponseDTO);

    }

    private void printResult(CountScoreResponseDTO countScoreResponseDTO) {
        System.out.println(WINNING_STATISTICS);
        System.out.printf(THREE_SAME.toString(), countScoreResponseDTO.getFifthPlace());
        System.out.printf(FOUR_SAME.toString(), countScoreResponseDTO.getFourthPlace());
        System.out.printf(FIVE_SAMECONSTANT.toString(), countScoreResponseDTO.getThirdPlace());
        System.out.printf(FIVE_BONUS_SAMECONSTANT.toString(), countScoreResponseDTO.getSecondPlace());
        System.out.printf(SIX_SAME.toString(), countScoreResponseDTO.getFirstPlace());
        System.out.printf(RATE_OF_RETURN.toString(), countScoreResponseDTO.getRateOfReturn());
    }
}
