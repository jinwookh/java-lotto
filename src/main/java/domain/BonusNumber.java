package domain;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(String input, Lotto lotto) {
        input = input.trim();
        if (checkValidity(input,lotto) == false) {
            throw new IllegalArgumentException();
        }
        bonusNumber = Integer.parseInt(input);
    }

    boolean checkValidity(String input, Lotto lotto) {
        int number = Integer.parseInt(input);
        return checkValidity(number, lotto);
    }

    boolean checkValidity(int number, Lotto lotto) {
        if (number < Lotto.MIN || number > Lotto.MAX) {
            throw new IllegalArgumentException();
        }

        return lotto.hasNumber(number) == false;
    }


}
