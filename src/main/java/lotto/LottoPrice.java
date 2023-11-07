package lotto;

public class LottoPrice {
        private static final int LOTTO_PRICE = 1000;
        private final int payMoney;
        private int lottoCount;
        public LottoPrice(int payMoney) {
                validatePrice(payMoney);
                this.payMoney = payMoney;
                lottoCount = payMoney / LOTTO_PRICE;
        }
        private void validatePrice(int payMoney) {
                if(payMoney%LOTTO_PRICE!=0){
                        throw new IllegalArgumentException();
                }
        }


}
