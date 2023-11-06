package lotto.global.constant.message;

public enum BuyLottoMessage implements MessageUtil<Long> {
    BUY_LOTTO_MESSAGE() {
        public String makeMessage(Long number) {
            return String.format("\n%d개를 구매했습니다.",number);
        }
    };

    @Override
    public String makeMessage(Long number) {
        return null;
    }
}
