package domain;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoInput {
    private static final String SEPERATOR = ",";

    private String lottoString;

    LottoInput(String input) {
        if(checkValidity(input, SEPERATOR) == false) {
            throw new IllegalArgumentException();
        }
        lottoString = input;
    }

    public Lotto toLotto() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(convertToSet(lottoString, SEPERATOR));
        return new Lotto(numbers);
    }


    private boolean checkValidity(String input, String seperator) {
        Set<Integer> set = convertToSet(input, seperator);
        return set.size() == Lotto.COUNT_OF_NUMBERS;
    }

    private Set<Integer> convertToSet(String input, String seperator) {
        String[] strings = input.split(seperator);
        Set<Integer> set = new HashSet<>();
        for (String string : strings
        ) {
            string = string.trim();
            if(string.length() == 0) {
                continue;
            }
            if (checkValidity(string)) {
                set.add(Integer.parseInt(string));
            }
        }
        return set;
    }



    private boolean checkValidity(String string) {
        int number = Integer.parseInt(string);
        if (number >= Lotto.MIN && number <= Lotto.MAX) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
