package lotto;

public class LottoPlay implements Play{
    private final Controller controller = new Controller();
    private final View view = new View();

    @Override
    public void start() {
        int purchaseQuantity = getPurchaseQuantity();
        printMyLottoNumber();
        readWinningNumber();
        readBonusNumber();
        printWinningStat();
        printYieldRate();
    }

    private int getPurchaseQuantity() {
        int purchaseQuantity = 0;

        do {
            try {
                System.out.print(view.getAskPurchaseAmount());
                purchaseQuantity = controller.getPurchaseQuantity();
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.NOT_A_NUMBER.getErrorMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.NOT_SEPARATED_1000.getErrorMessage());
            }
        } while (purchaseQuantity == 0);

        return purchaseQuantity;
    }

    private void printMyLottoNumber() {

    }

    private void readWinningNumber() {

    }

    private void readBonusNumber() {

    }

    private void printWinningStat() {

    }

    private void printYieldRate() {

    }

}
