package domain;

import java.util.HashSet;
import java.util.Set;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto lotto) {
        int identcalNumbers = getIdenticalNumbers(lotto);
        boolean hasBonusNumber = lotto.hasNumber(bonusNumber);
        return Rank.valueOf(identcalNumbers, hasBonusNumber);
    }

    private int getIdenticalNumbers(Lotto lotto) {
        Set<Integer> set = new HashSet<>();
        set.addAll(lotto.numbersAre());
        set.addAll(winningLotto.numbersAre());

        return Lotto.COUNT_OF_NUMBERS * 2 - set.size();
    }


    @Override
    public String toString() {
        return winningLotto.toString() + bonusNumber;
    }
}
