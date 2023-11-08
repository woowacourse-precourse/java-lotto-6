package lotto.Input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoAmount {
    private final int price;

    public LottoAmount() {
        this.price = inputAmount();
    }
    public Integer getPrice() {
        return price;
    }
    public Integer getTicket() {

        return price / 1000;
    }
    public Integer inputPrice(){
        return Integer.parseInt(readLine());
    }

    public int inputAmount() {
        int inputPrice;
        while (true) {
            try {
                inputPrice = inputPrice();
                new LottoAmountException(inputPrice);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return inputPrice;
    }




}
