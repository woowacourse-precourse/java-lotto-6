package lotto;

public class LottoBudget{
    
    private final int ONE_LOTTO_PRICE = 1000;
    private int lottoBudget;
    private int lottoCount;
    
    public LottoBudget(String inputBudgetText) throws IllegalArgumentException {
        validateBudgetText(inputBudgetText);
        int inputBudget = Integer.parseInt(inputBudgetText);
        validateBudget(inputBudget);
        this.lottoBudget = inputBudget;
        this.lottoCount = lottoBudget / ONE_LOTTO_PRICE;
    }
    
    private void validateBudgetText(String inputBudgetText) throws IllegalArgumentException{
        if (inputBudgetText.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액 입력은 1자 이상이어야 합니다.");
        }
        if (!inputBudgetText.matches("[-0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액 입력은 수를 입력해야 합니다.");
        }
    }
    
    private void validateBudget(int inputBudget) {
        if (inputBudget <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 양수여야 합니다.");
        }
        if (!isDivisible(inputBudget, ONE_LOTTO_PRICE)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 로또 한개의 가격으로 나누어 떨어져야 합니다.");
        }
    }
    
    private boolean isDivisible(int number, int divisor) {
        return ((number % divisor) == 0);
    }
    
    public int getLottoCount() {
        return this.lottoCount;
    }
    
    public int getLottoBudget() {
        return this.lottoBudget;
    }
}
