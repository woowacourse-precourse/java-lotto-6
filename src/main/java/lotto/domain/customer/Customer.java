package lotto.domain.customer;

import lotto.domain.lotto.Lotto;
import lotto.global.util.Converter;
import lotto.global.util.Validation;

import java.util.List;

public class Customer {
    private int price;
    private int quantity;
    private List<Lotto> lottos;

    public Customer(String input) {
        int convertedInput = Converter.convertStringToInt(input);
        validate(convertedInput);
        price = convertedInput;
        setQuantity(price);
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void validate(int price) {
        Validation validation = new Validation();
        validation.multipleOfThousand(price);
        validation.hundredThousandOrUnder(price);
    }

    private void setQuantity(int price) {
        this.quantity = price / 1000;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
