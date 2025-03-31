package examples.node;

public class PlayerNode {
    // PlayerNode

    String[] name;
    PlayerNode nextPlayer;

    PlayerNode(String[] name){
        this.name = name;
        this.nextPlayer = null;
    }
}
