package lotto.Controller;

import lotto.Service.LottoService;
import lotto.Utils.Utils;
import lotto.Validator.Validator;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.domain.Lottos;
import lotto.domain.User;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();
    private final Lottos lottos = new Lottos();
    private final Utils utils = new Utils();
    private final Validator validator = new Validator();
    private List<Integer> winningNumbers = new ArrayList<>();
    private List<Integer> matchedNumber;
    private int money = 0;
    private int bonusBall;
    private boolean isBonusBall;
    public void run() {
        receiveMoney();
        buyTicket();
        receiveWinningNumber();
        receiveBonusNumber();
        compareLottos();
        showComparisonResults();
    }
    private void receiveMoney() {
        try {
            outputView.printGetMoney();
            money = Integer.parseInt(inputView.getMoney());
        }
        catch(NumberFormatException e){
            System.out.println("[ERROR] 잘못된 입력입니다.");
            receiveMoney();
        }
    }
    private void buyTicket() {
        int ticketCount=0;
        try {
            ticketCount = lottoService.getTicketCount(money);
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 1000원으로 나누어 떨어지지 않습니다.");
            receiveMoney();
        }
        outputView.printTicketCount(ticketCount);
        for (int i = 0; i < ticketCount; i++) {
            lottos.createLotto();
        }
        outputView.printPurchasedLotto(lottos.purchasedLottos);
    }
    private void receiveWinningNumber() {
        while (true) {
            try {
                outputView.printBeforeGetWinningNumber();
                String UserInputWinningNumbers = inputView.getWinningLottoNumbers();
                winningNumbers = utils.StringToIntegerList(UserInputWinningNumbers);
                validateLottoNumber(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 잘못된 입력입니다.");
            }
        }
    }
    private void receiveBonusNumber(){
        while (true) {
            try {
                outputView.printGetBonusNumber();
                String UserInputBonusNumber=inputView.getBonusNumbers();
                bonusBall = utils.StringToInteger(UserInputBonusNumber);
                validateBonusNumber(bonusBall);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 잘못된 입력입니다.");
            }
        }

    }
    private void validateBonusNumber(int bonusBall) {
        if(!validator.isValidRangeBonusNumber(bonusBall)){
            throw new IllegalArgumentException("보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }
    private void validateLottoNumber(List<Integer> winningNumbers) {

        if (validator.hasDubplicatesUserNumbers(winningNumbers)||
                !validator.isValidRange(winningNumbers)||
                !validator.isValidLength(winningNumbers)) throw new IllegalArgumentException();
    }
    private void compareLottos() {
        matchedNumber = lottoService.CompareNumbers(lottos.purchasedLottos, winningNumbers);
        isBonusBall = lottoService.CompareBonusNumbers(lottos.purchasedLottos, bonusBall);
    }
    private void showComparisonResults() {
        User user = new User(matchedNumber);
        user.setRanks(isBonusBall);
        outputView.printWinningCounts(user.getAllRanks());//당첨자 수를 표시한다.
        float profitPercentage = user.getProfitPercentage(money);
        outputView.printprofitPercentage(profitPercentage);//수익률을 표시한다.
    }
}
