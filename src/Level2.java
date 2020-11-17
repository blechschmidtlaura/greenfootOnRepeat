public class Level2 extends RabbitWorld{

    private PlayerRabbit player;

    public Level2(PlayerRabbit player){
        this.player = player;
        addObject(player, 0,player.getY());
    }
}
