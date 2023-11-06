package lotto.domain;

import static java.util.Collections.sort;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Purchase;
import lotto.model.WinningNumbers;
import lotto.view.View;

public class Controller {
    public Controller() {
    }

    public void lotto_Logic() {
        View view = new View();
        view.inputPurchaseAmount();

        String inputPurchaseAmount = view.input();
        while (!processPurchaseAmountData(inputPurchaseAmount)) {
            processErrorResult();
            inputPurchaseAmount = view.input();
            processPurchaseAmountData(inputPurchaseAmount);
        }

        System.out.println();
        view.displayPurchaseQuantityMessage(Purchase.getPurchaseCount());

        // 로또 번호 출력
        displayLottoNumbers(generateLottoNumbersList(generateLottoTickets(Purchase.getPurchaseCount())));

        System.out.println();
        view.inputWinningNumbers();

        // 당첨 번호 입력 ~ 검증 ~ 저장
        String inputWinningNumbers = view.input();
        while (!processWinningNumbersData(inputWinningNumbers)) {
            processErrorResult();
            inputWinningNumbers = view.input();
            processWinningNumbersData(inputWinningNumbers);
        }

        // 보너스 번호 입력
        System.out.println();
        view.inputBonusNumber();

    }


    // 로또 번호 랜덤 뽑기
    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    // 로또 티켓 개수만큼 로또 객체 생성
    public List<Lotto> generateLottoTickets(int purchaseAmount) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> numbers = generateLottoNumbers();
            sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottoNumbers.add(lotto);
        }
        return lottoNumbers; //user class 에 저장해야하나 ?
    }

    public List<Object> generateLottoNumbersList(List<Lotto> lottoNumbers) {
        List<Object> numbers = new ArrayList<>();
        for (Lotto lotto : lottoNumbers) {
            numbers.add(lotto.getLottoNumbers());
        }
        return numbers;
    }

    // 로또 번호 출력
    public void displayLottoNumbers(List<Object> numbers) {
        for (Object number : numbers) {
            System.out.println(number);
        }
    }

    private boolean isEmpty(String input) {
        return !input.isEmpty();
    }

    public boolean isNotNumeric(String input) {
        String[] inputArray = input.split(",");
        try {
            for (String numStr : inputArray) {
                Integer.parseInt(numStr);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 최소 검증 로직
    public void validateInput(String input) {
        if (!isEmpty(input) && isNotNumeric(input)) {
            throw new IllegalArgumentException();
        }
    }

    // 당첨 번호 모델에 넘기기 전 자료형 변환
    // 메서드 이름 다시 짓기
    public List<Integer> performTypeConversion(String input) {
        String[] inputArray = input.split(",");
        List<Integer> inputWinningNumbers = new ArrayList<>();
        for (String numStr : inputArray) {
            int num = Integer.parseInt(numStr);
            inputWinningNumbers.add(num);
        }
        return inputWinningNumbers;
    }

    public void processErrorResult() {
        System.out.println("[ERROR] 잘못 입력하셨습니다. 다시 입력해주세요.");
    }

    public boolean processWinningNumbersData(String input) {
        try {
            validateInput(input);
            new WinningNumbers(performTypeConversion(input));
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public boolean processPurchaseAmountData(String input) {
        try {
            validateInput(input);
            new Purchase(Integer.parseInt((input)));
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

        try {
        } catch (IllegalArgumentException e) {
        }
    }

}
