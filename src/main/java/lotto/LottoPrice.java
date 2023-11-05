package lotto;

import java.util.List;

public class LottoPrice {
    private final int Price;
    private static final int BasicLottoPrice = 1000;

    public LottoPrice(int Price) {
        validate(Price);
        this.Price = Price;

    }

    public int makeReturnNum() {
        int Num = Price/BasicLottoPrice;
        PrintOutput printOutput = new PrintOutput();
        printOutput.printLottoPrice(Num);
        return Num;
    }

    private void validate(int Price) {
        if (Price==0) {
            throw new IllegalArgumentException();
        }

    }


}
