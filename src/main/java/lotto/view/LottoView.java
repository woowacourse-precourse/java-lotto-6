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
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.BonusRequestDTO;
import lotto.dto.LottoRequestDTO;
import lotto.dto.LottoResponseDTO;

public class LottoView {

    private Lottos lottos;
    private Lotto userLotto;
    private int bonus;

    public void start() {
        System.out.println(START);
        lottoPay(Console.readLine());
        parseLotto(Console.readLine());
        parseBonusInteger(Console.readLine());
        lottoResult();
    }

    private void lottoPay(String money) {
        while (true) {
            try {
                Lottos lottos = LottoController
                        .getInstance()
                        .lottoSell(money);
                this.lottos = lottos;
                break;
            } catch (IllegalArgumentException e) {
                money = Console.readLine();
            }
        }

        System.out.printf(BUY.toString(), lottos.getLottoCount());
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));

        System.out.println(JACKPOT);
    }

    private void parseLotto(String number) {
        while (true) {
            try {
                this.userLotto = LottoController.getInstance()
                        .createUserLottoNumber(number);
                break;
            } catch (IllegalArgumentException e) {
                number = Console.readLine();
            }
        }

        System.out.println(BONUS);
    }

    private void parseBonusInteger(String bonus) {
        while (true) {
            try {
                BonusRequestDTO bonusRequestDTO = new BonusRequestDTO.Builder()
                        .lotto(userLotto)
                        .bonus(bonus)
                        .build();
                this.bonus = LottoController
                        .getInstance()
                        .checkBonusNumber(bonusRequestDTO);
                break;
            } catch (IllegalArgumentException e) {
                bonus = Console.readLine();
            }
        }
    }

    private void lottoResult() {
        LottoRequestDTO lottoRequestDTO = new LottoRequestDTO.Builder()
                .lottos(lottos)
                .numbers(userLotto)
                .bonus(bonus)
                .build();

        LottoResponseDTO lottoResponseDTO = LottoController
                .getInstance()
                .CountScore(lottoRequestDTO);

        printResult(lottoResponseDTO);

    }

    private void printResult(LottoResponseDTO lottoResponseDTO) {
        System.out.println(WINNING_STATISTICS);
        System.out.printf(THREE_SAME.toString(), lottoResponseDTO.getFifthPlace());
        System.out.printf(FOUR_SAME.toString(), lottoResponseDTO.getFourthPlace());
        System.out.printf(FIVE_SAMECONSTANT.toString(), lottoResponseDTO.getThirdPlace());
        System.out.printf(FIVE_BONUS_SAMECONSTANT.toString(), lottoResponseDTO.getSecondPlace());
        System.out.printf(SIX_SAME.toString(), lottoResponseDTO.getFirstPlace());
        System.out.printf(RATE_OF_RETURN.toString(), lottoResponseDTO.getRateOfReturn());
    }
}
