package lotto.view;

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
        System.out.println(START);
        lottoPay();
        parseLotto();
        parseBonusInteger();
        lottoResult();
    }

    private void lottoPay() {
        String money = Console.readLine();
        while (true) {
            try {
                List<Lotto> tickets = lottoController.setLottoBudget(money);
                this.lottoTickets = tickets;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException : " + e.getMessage());
                money = Console.readLine();
            }
        }

        System.out.printf(BUY.toString(), lottoTickets.size());
        lottoTickets.stream()
                .forEach(ticket -> System.out.println(ticket.getNumbers().toString()));

        System.out.println(JACKPOT);
    }

    private void parseLotto() {
        String number = Console.readLine();
        while (true) {
            try {
                this.userLotto = LottoController.getInstance()
                        .createUserLottoNumber(number);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException : " + e.getMessage());
                number = Console.readLine();
            }
        }

        System.out.println(BONUS);
    }

    private void parseBonusInteger() {
        String bonus = Console.readLine();
        while (true) {
            try {
                BonusRequestDTO bonusRequestDTO = new BonusRequestDTO.Builder()
                        .lotto(userLotto)
                        .bonus(bonus)
                        .build();
                this.bonus = lottoController
                        .createBonusNumber(bonusRequestDTO);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException : " + e.getMessage());
                bonus = Console.readLine();
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
