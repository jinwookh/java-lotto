package domain;

import java.util.Scanner;

public class InputHandler {
    private static final String PURCHASE_AMOUNT_ERROR
            = "1000 이상의 금액을 입력해 주세요.";
    private static final String ASK_PURCHASE_AMOUNT
            = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_LOTTO
            = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNINIG_LOTTO_ERROR
            = "쉼표로 구분된 6개의 숫자(1~45 사이)를 입력해 주세요.";

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

    public static Lotto getWinningLotto() {
        try {
            System.out.println(ASK_WINNING_LOTTO);
            LottoInput lottoInput = new LottoInput(SCANNER.nextLine());
            return lottoInput.toLotto();
        } catch (Exception e) {
            System.out.println(WINNINIG_LOTTO_ERROR);
            return getWinningLotto();
        }
    }

}
