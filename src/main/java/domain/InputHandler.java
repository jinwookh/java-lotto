package domain;

import java.util.Scanner;

public class InputHandler {
    private static final String PURCHASE_AMOUNT_ERROR
            = "1000 이상의 금액을 입력해 주세요.";
    private static final String ASK_PURCHASE_AMOUNT
            = "구입금액을 입력해 주세요.";

    private static Scanner SCANNER = new Scanner(System.in);


    public static int getPurchaseAmount() {
        try {
            System.out.println(ASK_PURCHASE_AMOUNT);
            PurchaseAmountInput purchaseAmountInput
                    = new PurchaseAmountInput(SCANNER.nextLine());
            return purchaseAmountInput.is();
        } catch (Exception e) {
            System.out.println(PURCHASE_AMOUNT_ERROR);
            return getPurchaseAmount();
        }
    }

}
