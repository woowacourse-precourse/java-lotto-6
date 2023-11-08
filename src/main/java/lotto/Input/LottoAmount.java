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

    private int inputAmount() {
        int inputPrice;
        while (true) {
            try {
                inputPrice = Integer.parseInt(readLine());
                if (inputPrice % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 1000원 단위로만 구매 가능합니다.");
                }
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
