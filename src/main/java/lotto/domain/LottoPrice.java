package lotto.domain;

import lotto.Constants;

public class LottoPrice {
        private final int payMoney;
        private int lottoCount;
        public LottoPrice(int payMoney) {
                validatePrice(payMoney);
                this.payMoney = payMoney;
        }
        private void validatePrice(int payMoney) {
                if(payMoney% Constants.LOTTO_PRICE!=0){
                        throw new IllegalArgumentException();
                }
        }
        public int getLottoCount() {
                lottoCount = payMoney / Constants.LOTTO_PRICE;
                return lottoCount;
        }


}
