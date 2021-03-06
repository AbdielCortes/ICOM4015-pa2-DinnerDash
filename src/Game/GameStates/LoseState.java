package Game.GameStates;


import Main.Handler;
import Resources.Images;
import Display.UI.ClickListlener;
import Display.UI.UIImageButton;
import Display.UI.UIManager;
import Game.World.Restaurant_1;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class LoseState extends State {

    private UIManager uiManager;

    public LoseState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);


        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+70, 190, 186, 66, Images.BTitle, new ClickListlener() {
            @Override
            public void onClick() {
                State.setState(handler.getGame().menuState);
            }
        }));
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+70, 290, 186, 66, Images.Restart, new ClickListlener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUimanager(null);
                handler.getGame().reStart();
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.darkGray);
		g.fillRect(0,0,handler.getWidth(),handler.getHeight());
        g.drawImage(Images.lose,0,0,handler.getWidth(),handler.getHeight(),null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("ComicSans", Font.BOLD, 32));
        String moneyFormated = String.format("%.2f", handler.getPlayer().money);
        g.drawString("Money made: " + moneyFormated, handler.getWidth()/2, handler.getHeight()/2-350);
        g.drawString("Clients served: " + handler.getPlayer().servedCustomers, handler.getWidth()/2, handler.getHeight()/2-300);
        g.drawString("Clients left: " + Restaurant_1.getLeftClients(), handler.getWidth()/2, handler.getHeight()/2-250);
        uiManager.Render(g);

    }


}
