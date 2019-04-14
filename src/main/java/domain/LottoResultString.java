package domain;

import java.util.Map;

public class LottoResultString {
    private static final String INITIAL_WORD = "\n당첨 통계\n---------";
    private static final String MATCH_COUNT_IS = "개 일치 (";
    private static final String CLOSE_BRACKET = "원) - ";
    private static final String FINISH_SENTENCE = "개";
    private static final String PROFIT_RATE_IS = "총 수익률은 ";
    private static final String IS_THIS = "%입니다.";

    public static void show(Map<Rank, Integer> resultMap, double profitRate) {
        System.out.println(INITIAL_WORD);
        for (Rank rank : Rank.values()
             ) {
            if (rank == Rank.MISS) {
                continue;
            }
            System.out.println(rank.countOfIdenticalNumbersIs() + MATCH_COUNT_IS
                    + rank.prizeIs() + CLOSE_BRACKET + resultMap.get(rank)
                    + FINISH_SENTENCE);
        }
        System.out.println(PROFIT_RATE_IS + profitRate + IS_THIS);
    }
}
