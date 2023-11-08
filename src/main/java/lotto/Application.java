package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGenerator;
import lotto.error.Error;
import lotto.error.Error.ErrorType;
import lotto.ui.LottoResultDisplay;
import lotto.ui.LottoTicketDisplay;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<LottoTicket> lottoTickets;
        List<Integer> lottoNumbers = new ArrayList<>();
        int bonusNumber;
        int money = 0;
        String[] inputLottoNumbers;

        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();
        LottoResult lottoResult = new LottoResult();
        LottoResultDisplay lottoResultDisplay = new LottoResultDisplay();
        LottoTicketDisplay lottoTicketDisplay = new LottoTicketDisplay();

        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                money = Integer.parseInt(Console.readLine());
                lottoTicketGenerator.validate(money);
                break;
            } catch (IllegalArgumentException e) {
                Error.showErrorMessage(ErrorType.INVALID_MONEY_TYPE);
            }
        }

        lottoTicketGenerator.insertMoney(money);
        lottoTicketDisplay.showTicketCount(lottoTicketGenerator);

        lottoTickets = lottoTicketGenerator.createLottoTickets();
        lottoTicketDisplay.showAllLottoTicket(lottoTickets);

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        while (true){
            try {
                inputLottoNumbers = Console.readLine().split(",");
                lottoNumbers = Lotto.parseIntLottoNumber(inputLottoNumbers,lottoNumbers);
                Lotto.validate(lottoNumbers);
                break;
            } catch (IllegalArgumentException e){
                Error.showErrorMessage(ErrorType.INVALID_LOTTO_INPUT);;
            }
        }

        Lotto lotto = new Lotto(lottoNumbers);
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        while (true){
            try {
                bonusNumber = Integer.parseInt(Console.readLine());
                lotto.validate(bonusNumber);
                break;
            } catch (IllegalArgumentException e){
                Error.showErrorMessage(ErrorType.INVALID_LOTTO_INPUT);
            }
        }

        lotto.inputBonusNumber(bonusNumber);

        System.out.println();
        lottoResult.compareAllLottoTicket(lotto.getNumbers(),lottoTickets);
        lottoResultDisplay.showWinningDetails(lottoResult);
        lottoResultDisplay.showProfitMargin(lottoResult.getProfitMargin(money));

        Console.close();
    }
}
