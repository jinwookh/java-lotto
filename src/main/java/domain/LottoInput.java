package domain;


import java.util.HashSet;
import java.util.Set;

public class LottoInput {
    private static final String SEPERATOR = ",";

    LottoInput(String input) {
        if(checkValidity(input, SEPERATOR) == false) {
            throw new IllegalArgumentException();
        }
    }


    public static boolean checkValidity(String input, String seperator) {
        Set<String> set = convertToSet(input, seperator);
        return set.size() == Lotto.COUNT_OF_NUMBERS;
    }

    public static Set<String> convertToSet(String input, String seperator) {
        String[] strings = input.split(seperator);
        Set<String> set = new HashSet<>();
        for (String string : strings
        ) {
            string = string.trim();
            if (checkValidity(string)) {
                set.add(string);
            }
        }
        return set;
    }



    public static boolean checkValidity(String string) {
        int number = Integer.parseInt(string);
        if (number >= Lotto.MIN && number <= Lotto.MAX) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
