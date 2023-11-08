package lotto.controller;

import lotto.service.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.model.AppConstants.lottoConstants.LOTTO_TICKET_PRICE;
import static lotto.service.PrizeCalculator.calculateProfitRate;

public class LottoGame {
    private LottoTicketGenerate lottoTicketGenerate;
    private Lotto lotto;
    private BonusLotto bonusLotto;
    InputView inputView = new InputView();

    public void run() {
        int inputPrice = inputView.inputPrice();

        buyLottoTicket(inputPrice);
        setWinningLotto();
        setBonusLotto();

        Map<String, Integer> lottoMatchingResult =  LottoMatching();
        int totalPrice = PrizeCalculator.calculate(lottoMatchingResult);

        float profitPercent = calculateProfitRate(totalPrice, inputPrice);

        OutputView.printLottoMatchingResult(lottoMatchingResult, profitPercent);
    }

    private Map<String, Integer> LottoMatching() {
        MatchingNumber matchingNumber = new MatchingNumber(lottoTicketGenerate.getLottoTicketEntities(), lotto.getLottoNumbers(), bonusLotto.getBonusNumber());

        return matchingNumber.getLottoRankList();
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

    private void buyLottoTicket(int inputPrice) { //금액만큼 로또 구입 후 출력
        int lottoTicketCount = inputPrice / LOTTO_TICKET_PRICE.getValue();
        OutputView.printTicketCount(lottoTicketCount);
        lottoTicketGenerate = new LottoTicketGenerate(lottoTicketCount);
        lottoTicketGenerate.sortLottoTicketEntities();

        OutputView.printLottoTickets(lottoTicketGenerate.getLottoTicketEntities());
    }

    private void setWinningLotto() {
        while(true) {
            try {
                String inputWinningNumbers = inputView.inputWinningNumbers();
                List<Integer> winningNumbers = splitList(inputWinningNumbers);

                this.lotto = new Lotto(winningNumbers);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> splitList(String inputWinningNumbers) {
        String[] splitNumbers = inputWinningNumbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : splitNumbers) {
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }
}
