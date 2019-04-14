import domain.*;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        for(int i = 0; i<50; i++) {
            Lotto lotto = Lotto.isGenerated();
            Lotto winningLottoWithoutBonusNumber = Lotto.isGenerated();
            WinningLotto winningLotto
                    = new WinningLotto(winningLottoWithoutBonusNumber, 3);
            System.out.println(lotto);
            System.out.println(winningLotto);
            System.out.println(winningLotto.match(lotto));
        }



    }
}
