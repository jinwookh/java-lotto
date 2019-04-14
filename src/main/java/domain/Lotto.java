package domain;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int COUNT_OF_NUMBERS = 6;
    public static final int MIN = 1;
    public static final int MAX = 45;

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException();
        }
        lottoNumbers = numbers;
    }

    public boolean hasNumber(int number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
