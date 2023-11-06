package lotto.LottoController;

import lotto.Lotto;
import lotto.LottoView.LottoView;

import java.util.ArrayList;
import java.util.List;

public class InputCheck {

    private final LottoView view;

    public InputCheck(LottoView view) {
        this.view = view;
    }

    public int inputAmount() {
        int amount;
        while (true) {
            try {
                amount = view.inputMoney();
                amountCheck(amount);
                break;
            } catch (IllegalArgumentException e) {
                view.errorMeg(e.getMessage());
            }
        }
        return amount;
    }

    public Lotto inputNumbers() {
        while (true) {
            try {
                List<Integer> winNumbers = convertNumber(view.winNumber());

                return new Lotto(winNumbers);

            } catch (IllegalArgumentException e) {
                view.errorMeg(e.getMessage());
            }
        }
    }

    public int inputBonus(Lotto winNumber) {
        int bonusNumber;

        while (true) {
            try {
                bonusNumber = view.bonusNumber();
                bonusCheck(bonusNumber, winNumber);

                return bonusNumber;

            } catch (IllegalArgumentException e) {
                view.errorMeg(e.getMessage());
            }
        }
    }

    private void amountCheck(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    private void bonusCheck(int bonusNumber, Lotto winNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 숫자는 1부터 45 사이여야 합니다.");
        }

        if (winNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("중복된 보너스 숫자가 있습니다");
        }
    }

    public List<Integer> convertNumber(String input) {
        String[] parts = input.split(",");

        List<Integer> numbers = new ArrayList<>();

        for (String part : parts) {
            numbers.add(Integer.parseInt(part));
        }
        return numbers;
    }

}