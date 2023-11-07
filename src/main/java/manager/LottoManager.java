package manager;


import static validate.Validator.isInvalidPriceUnit;
import static validate.Validator.validateBonusNumber;
import static validate.Validator.validateWinningNumber;

import camp.nextstep.edu.missionutils.Console;
import inputdata.LottoBonusNumberInput;
import inputdata.LottoTicketInput;
import inputdata.LottoWinningNumberInput;
import java.util.List;

public class LottoManager {
    private LottoTicketInput lottoTicketInput;
    private LottoBonusNumberInput lottoBonusNumberInput;
    private LottoWinningNumberInput lottoWinningNumberInput;

    public LottoManager() {}

    public void setInputLottoTicketPrice() {
        while (true) {
            try {
                int lottoTicketPrice = Integer.parseInt(Console.readLine());
                lottoTicketInput.setLottoTicketPrice(lottoTicketPrice);
                isInvalidPriceUnit(lottoTicketPrice);
                this.lottoTicketInput = new LottoTicketInput(lottoTicketPrice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setInputWinningNumbers() {
        while (true) {
            try {
                String[] winningLottoNumber = Console.readLine().split(",");
                int[] parseIntWinningNumber = lottoWinningNumberInput.setWinningNumbers(winningLottoNumber);
                int[] validatedIntWinningNumber = validateWinningNumber(parseIntWinningNumber);
                this.lottoWinningNumberInput = new LottoWinningNumberInput(validatedIntWinningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setInputBonusNumber() {
        while (true) {
            try {
                int bonusNumber = Integer.parseInt(Console.readLine());
                lottoBonusNumberInput.setBonusNumbers(bonusNumber);
                this.lottoBonusNumberInput = new LottoBonusNumberInput(bonusNumber);
                validateBonusNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printPurchasedTickets(int size) {
        System.out.println(size + "개를 구매했습니다.");
    }

    private void lottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }
}
