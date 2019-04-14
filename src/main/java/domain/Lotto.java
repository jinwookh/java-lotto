package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int COUNT_OF_NUMBERS = 6;
    public static final int MIN = 1;
    public static final int MAX = 45;

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException("로또 개수는 6이어야 합니다.");
        }
        lottoNumbers = numbers;
    }

    public boolean hasNumber(int number) {
        return lottoNumbers.contains(number);
    }

    public static Lotto isGenerated() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < COUNT_OF_NUMBERS) {
            set.add(getRandomLottoNumber());
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(set);

        return new Lotto(list);
    }

    private static int getRandomLottoNumber() {
        int randomNumber = (int) (Math.random() * (MAX - MIN + 1) + MIN);
        return randomNumber;
    }


    public List<Integer> numbersAre() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
