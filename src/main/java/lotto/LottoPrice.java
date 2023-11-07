package lotto;

public class LottoPrice {
        private static final int LOTTO_PRICE = 1000;
        private final int payMoney;
        private int lottoCount;
        public LottoPrice(int payMoney) {
                this.payMoney = payMoney;
                lottoCount = payMoney / LOTTO_PRICE;
        }
        public void validatePrice() {
                if (payMoney < LOTTO_PRICE) {
                        throw new IllegalArgumentException();
                }
                if(payMoney%LOTTO_PRICE!=0){
                        throw new IllegalArgumentException();
                }
        }


}
