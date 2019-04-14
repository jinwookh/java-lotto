import domain.*;

public class Solution {

    public static void main(String[] args) {

        Lotto lotto = Lotto.isGenerated();
        System.out.println(lotto);
        System.out.println(InputHandler.getBonusNumber(lotto));

    }
}
