package lotto.service;

import java.util.List;
import lotto.dto.Dto;
import lotto.utils.UserNumbersUtils;

public class LottoService {
    private Dto dto = new Dto();
    // 서비스와 관련된 기능 구현 (로또 티켓 구매, 로또 티켓 출력, 로또 번호 입력, 로또 번호 예외 처리, 로또 결과 출력)
    private int money;

    public void userInputMoney(String userInput) {
        try {
            int money = MoneyValidator.validate(userInput);

            dto.setMoney(money);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void userInputNumbers(String userInput) {
        try {
            UserNumbersValidator.preValidate(userInput);
            List<Integer> numbers = UserNumbersUtils.convert(userInput);
            UserNumbersValidator.postValidate(numbers);
            List<Integer> sortedNumbers = UserNumbersUtils.sort(numbers);

            dto.setNumbers(sortedNumbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void userInputBonus(String userInput) {
        try {
            int bonus = BonusValidator.validate(userInput);

            dto.setBonus(bonus);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void makeLuckyNumbers() {
        try {
            dto.setLuckyNumbers();
        } catch (IllegalStateException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public int getTicketCount() {
        return dto.getLottoTickets().getTicketCount();
    }

    public List<String> getLottoTickets() {
        return MakeLottoTickets.make(dto.getLottoTickets().getTickets());
    }

    public void makeWinningStatistics() {
        dto.makeWinningStatistics();
    }

    public List<String> getWinningStatistics() {
        return ResultWinning.makeResult(dto.getWinningStatistics());
    }

    public String calculateEarningRate() {
        return MakeEarningResult.calRate(dto.calculateEarningRate(), dto.getMoney());
    }
}
