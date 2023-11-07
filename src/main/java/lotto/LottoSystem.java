package lotto;

public class LottoSystem {
    private static final int PRICE_0 = 1000;

    public int buyLottoTicket(String money) throws IllegalArgumentException {
        try{
            int parseMoney = Integer.parseInt(money);
            if (parseMoney % PRICE_0 != 0){
                throw new IllegalArgumentException("구매 금액을 1000원 단위로 작성해주세요.");
            }
            return parseMoney/PRICE_0;
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력받은 값이 잘못되었습니다.");
        }
    }
}
