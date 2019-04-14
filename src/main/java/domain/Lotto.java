package domain;

import java.util.ArrayList;
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

    public static Lotto isGenerated() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_NUMBERS; i++) {
            numbers.add(getRandomLottoNumber());
        }
        return new Lotto(numbers);
    }

    private static int getRandomLottoNumber() {
        int randomNumber = (int) (Math.random() * (MAX - MIN + 1) + MIN);
        return randomNumber;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
