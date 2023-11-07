package lotto;


public class LottoAmount {
    private int amount;

    public LottoAmount(String amount) {
        if (validateNumber(amount)) {
            int amountNum = Integer.parseInt(amount);
            validateAmount(amountNum);
            this.amount = amountNum;
        }else{
            System.out.println("[ERROR] 숫자가 아닌 값을 입력했습니다.");
            Controller Controller = new Controller();
            Controller.start();
            throw new IllegalArgumentException();
        }
    }

    public int LottoCount() {
        return amount / 1000;
    }


    private void validateAmount(int amount) {
        validateDivisible(amount);
    }

    private static Boolean validateNumber(String amount) {
        try {
            Integer.parseInt(amount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private void validateDivisible(int amount) {
        if (amount % 1000 != 0) {

            System.out.println("[ERROR] 금액이 1000원으로 나누어 떨어지지 않습니다.");
            Controller Controller = new Controller();
            Controller.start();
            throw new IllegalArgumentException();

        }
    }
}
