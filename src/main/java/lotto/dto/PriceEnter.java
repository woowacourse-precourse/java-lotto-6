package lotto.dto;

public class PriceEnter {
    String price;
    boolean inputValid;

    public PriceEnter(String price, boolean inputValid) {
        this.price = price;
        this.inputValid = inputValid;
    }

    public String getPrice() {
        return price;
    }

    public boolean isInputValid() {
        return inputValid;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setInputValid(boolean inputValid) {
        this.inputValid = inputValid;
    }
}
