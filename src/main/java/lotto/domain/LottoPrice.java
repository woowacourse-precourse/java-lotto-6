package lotto.domain;

import lotto.Constants;

public class LottoPrice {
        private final int payMoney;

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
                int lottoCount;
                lottoCount = payMoney / Constants.LOTTO_PRICE;
                return lottoCount;
        }


}
