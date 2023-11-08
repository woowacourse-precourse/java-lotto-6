package lotto.presentation;

public class Reader {

    private final LottoConsole lottoConsole;

    public Reader(LottoConsole lottoConsole) {
        this.lottoConsole = lottoConsole;
    }
    public MoneyVO readMoney() {
        String rawValue = lottoConsole.readLine();
        if (validateMoney(rawValue)) {
            return new MoneyVO(Integer.parseInt(rawValue));
        }
        throw new IllegalArgumentException("구입 금액은 숫자만 입력 가능합니다.");
    }
    private boolean validateMoney(String money) {
        return money.matches("\\d+");
    }
}
