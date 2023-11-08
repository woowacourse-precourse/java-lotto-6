package lotto.domain;

import lotto.view.InputView;
import lotto.service.ValidationPrice;

import static lotto.consts.ConstsString.TICKET_PRICE;

public class PurchaseLotto {
    InputView inputView = new InputView();
    ValidationPrice validationPrice = new ValidationPrice();
    private int price;
    public int inputPurchasePrice(){
        String inputPrice = inputView.setPurchasePrice();
        int settingPrice = validationPrice.checkInteger(inputPrice);
        validationPrice.validateProcessor(settingPrice);
        return settingPrice;
    }

    public int calculateCount(){
        price = inputPurchasePrice();
        return price / TICKET_PRICE;
    }

    public int getTicketCount(){
        return price / TICKET_PRICE;
    }
}
