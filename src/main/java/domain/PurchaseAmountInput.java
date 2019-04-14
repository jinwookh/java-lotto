package domain;

public class PurchaseAmountInput {
    private int purchaseAmount;

    public PurchaseAmountInput(String input) {
        input = input.trim();
        if (checkValidity(input) == false) {
            throw new IllegalArgumentException();
        }
        purchaseAmount = Integer.parseInt(input);
    }

    private boolean checkValidity(String input) {
        int number = Integer.parseInt(input);

        return number >= Lotto.PRICE;
    }
}
