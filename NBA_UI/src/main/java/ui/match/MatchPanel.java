package ui.match;

import javax.swing.JPanel;

import ui.config.PanelConfig;
import ui.config.SystemConfig;
import ui.home.HomeUI;
import ui.live.LiveChoosePane;
import ui.util.MyLabel;

public class MatchPanel extends JPanel{

	private PanelConfig pcfg;
	private HomeUI frame;
	public  LiveChoosePane liveChoosePane;
	
	public MatchPanel(HomeUI frame){
		this.pcfg = SystemConfig.getHOME_CONFIG().getConfigMap()
				.get(this.getClass().getName());
		this.frame = frame;
		
		this.setLayout(null);
		this.setOpaque(false);
		this.setSize(pcfg.getW(), pcfg.getH());
		this.setLocation(pcfg.getX(),pcfg.getY());
		
		initComponent();
	}
	
	private void initComponent(){
		initPanels();
	}
	
	
	
	private void initPanels(){
		liveChoosePane = new LiveChoosePane(frame);
		liveChoosePane.setVisible(false);
		add(liveChoosePane);
	}
}
