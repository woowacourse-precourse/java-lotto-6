package lotto;

public class LottoPrice {
        private final int payMoney;
        private int lottoCount;
        public LottoPrice(int payMoney) {
                validatePrice(payMoney);
                this.payMoney = payMoney;
                getLottoCount(payMoney);
        }
        private void validatePrice(int payMoney) {
                if(payMoney%Constants.LOTTO_PRICE!=0){
                        throw new IllegalArgumentException();
                }
        }
        private int getLottoCount(int payMoney) {
                lottoCount = payMoney / Constants.LOTTO_PRICE;
                return lottoCount;
        }


}
