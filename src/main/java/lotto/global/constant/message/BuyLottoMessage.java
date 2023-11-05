package lotto.global.constant.message;

public enum BuyLottoMessage implements MessageUtil<Integer> {
    BUY_LOTTO_MESSAGE() {
        public String makeMessage(Integer number) {
            return String.format("\n%d개를 구매했습니다.",number);
        }
    };

    @Override
    public String makeMessage(Integer number) {
        return null;
    }
}
