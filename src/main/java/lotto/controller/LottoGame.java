package lotto.controller;

import lotto.service.BonusLotto;
import lotto.service.Lotto;
import lotto.service.LottoTicketGenerate;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private LottoTicketGenerate lottoTicketGenerate;
    private Lotto lotto;
    private BonusLotto bonusLotto;
    InputView inputView = new InputView();

    public void run() {
        buyLottoTicket();
        setWinningLotto();
        setBonusLotto();


    }

    private void setBonusLotto() {
        while(true) {
            try {
                int bonusNumber = inputView.inputBonusNumber();
                lotto.isContainNumber(bonusNumber); //당첨번호와 보너스번호가 중복되는지 확인
                bonusLotto = new BonusLotto(bonusNumber);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void buyLottoTicket() { //금액만큼 로또 구입 후 출력
        int inputPrice = inputView.inputPrice();

        lottoTicketGenerate = new LottoTicketGenerate(inputPrice);
        lottoTicketGenerate.sortLottoTicketEntities();

        OutputView.printLottoTickets(lottoTicketGenerate.getLottoTicketEntities());
    }

    private void setWinningLotto() {
        while(true) {
            try {
                String winningNumbers = inputView.inputWinningNumbers();
                List<Integer> winningNumberList = splitList(winningNumbers);

                this.lotto = new Lotto(winningNumberList);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> splitList(String winningNumbers) {
        String[] splitNumbers = winningNumbers.split(",");
        List<Integer> winningNumberList = new ArrayList<>();

        for (String number : splitNumbers) {
            winningNumberList.add(Integer.parseInt(number));
        }

        return winningNumberList;
    }
}
