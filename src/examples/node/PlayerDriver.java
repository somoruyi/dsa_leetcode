package examples.node;

import java.util.Arrays;

public class PlayerDriver {

    public static void main(String[] args){
        PlayerNode p1 = new PlayerNode(new String[]{"Lebron", "Lakers"});
        PlayerNode p2 = new PlayerNode(new String[]{"Kyrie", "Mavs"});
//        PlayerNode p3 = new PlayerNode("Durant");

        p1.nextPlayer = p2; // this chains it together
//        p2.nextPlayer = p3; // this chains it together



        while(p1 != null){
            System.out.print(Arrays.toString(p1.name) + " -> ");
            p1 = p1.nextPlayer;
        }







    }

}
