package lotto.Service;

public class LottoService {
    private static int MONEY_UNIT = 1000;
    public int calLottoNum(String buyMoney){
        int lottoNum = Integer.parseInt(buyMoney) / MONEY_UNIT;

        return lottoNum;
    }
}
