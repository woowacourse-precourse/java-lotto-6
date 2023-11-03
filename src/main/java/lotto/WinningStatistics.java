package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.UserInputHandler.DIVISION_ROLE;

public class WinningStatistics {
    private final List<Lotto> lottoTickets;
    private final List<Integer> matchingNumber = new ArrayList<>(Collections.nCopies(7, 0));

    public WinningStatistics() {
        this.lottoTickets = new ArrayList<>();
    }

    // 로또 얼마치 구입할건지
    public void purchaseLottoTickets(int totalAmount) {
        int ticket = totalAmount / DIVISION_ROLE; // 몇 장인지 확인
        System.out.println(ticket + "개를 구매했습니다.");

        for (int i = 0; i < ticket; i++) {
            purchaseLottoPrint();
        }
    }

    // 구매한 갯수 만큼 출력
    public void purchaseLottoPrint() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(uniqueNumbers);
        List<Integer> numbers = lotto.getNumbers(); // 이 번호를 넘겨서 계산해야한다.
        LottoResultPrinter lottoResultPrinter = new LottoResultPrinter();
        lottoResultPrinter.printAllLotto(numbers);
        lottoTickets.add(lotto);
    }

    // 일치한 갯수 확인
    public void calculateStatistics(List<Integer> winningNumber, int bonusNumber, int userCost) {
        for (Lotto lotto : lottoTickets) {
            calculation(lotto, winningNumber, bonusNumber);
        }
//        printResult(userCost);
        LottoResultPrinter resultPrinter = new LottoResultPrinter();
        resultPrinter.printResult(matchingNumber, userCost);


    }

    private void calculation(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int count = 0;

        for (int number : lotto.getNumbers()) {
            if (winningNumber.contains(number)) {
                count++;
            }
        }
        int currentValue = matchingNumber.get(count);
        // 5개일치 + 보너스번호 일치 확인
        if (count == 5 && lotto.getNumbers().contains(bonusNumber)) {
            matchingNumber.add(0, currentValue + 1);
            return;
        }

        if (count >= 3) {
            matchingNumber.add(count, currentValue + 1);
        }
    }


    public void start() {
        UserInputHandler userInputHandler = new UserInputHandler();
        int userCost = userInputHandler.inputUserLottoPurchase(); // 구입금액 입력하기
        System.out.println();

        purchaseLottoTickets(userCost); // n개 했는지, 로또번호 출력
        System.out.println();
        List<Integer> winningNumber = userInputHandler.inputUserWinningNumbers(); // 당첨 번호 입력
        System.out.println();
        int bonusNumber = userInputHandler.inputUserBonusNumber(); // 보너스 번호 입력
        System.out.println();
        calculateStatistics(winningNumber, bonusNumber, userCost); // 당첨 통계
    }
}
