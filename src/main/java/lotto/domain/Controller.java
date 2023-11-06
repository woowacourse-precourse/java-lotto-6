package lotto.domain;

import static java.util.Collections.sort;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
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

        inputAmountLogic(view);
        System.out.println();
        view.displayPurchaseQuantityMessage(Purchase.getPurchaseCount());

        // 로또 번호 출력
        displayLottoNumbers(generateLottoNumbersList(generateLottoTickets(Purchase.getPurchaseCount())));

        System.out.println();
        view.inputWinningNumbers();

        // 당첨 번호 입력 ~ 검증 ~ 저장
        inputNumberLogic(view);

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
        for (int i = 0; i < lottoNumbers.size(); i++) {
            Lotto lotto = lottoNumbers.get(i);
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
    public boolean validateInput(String input) {
        if (!isEmpty(input) && isNotNumeric(input)) {
            throw new IllegalArgumentException();
        }
        return true;
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

    public String processErrorResult() {
        return "[ERROR] 잘못 입력하셨습니다. 다시 입력해주세요.";
    }


    public void inputNumberLogic(View view) {
        //당첨 번호 입력
        String input = view.input();
        //최소 검증 로직 수행 후 모델에 넘김
        preprocessDataWithErrorHandling(input, view);

        processDataWithErrorHandling(input, view);

    }

    public void preprocessDataWithErrorHandling(String input, View view) {
        try {
            validateInput(input);
        } catch (IllegalArgumentException e) {
            processErrorResult();
            inputNumberLogic(view);
        }
    }

    public void processDataWithErrorHandling(String input, View view) {
        try {
            new WinningNumbers(performTypeConversion(input));
        } catch (IllegalArgumentException e) {
            processErrorResult();
            inputNumberLogic(view);
        }
    }

    public void inputAmountLogic(View view) {
        //당첨 번호 입력
        String input = view.input();
        //최소 검증 로직 수행 후 모델에 넘김
        preprocessAmountDataWithErrorHandling(input, view);
        processAmountDataWithErrorHandling(input, view);
    }

    public void preprocessAmountDataWithErrorHandling(String input, View view) {
        try {
            validateInput(input);
        } catch (IllegalArgumentException e) {
            processErrorResult();
            inputAmountLogic(view);
        }
    }

    public void processAmountDataWithErrorHandling(String input, View view) {
        try {
            new Purchase(Integer.parseInt((input)));
        } catch (IllegalArgumentException e) {
            processErrorResult();
            inputAmountLogic(view);
        }
    }
}
