package bg.vfu.ucclock;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class UnitCirclePanel extends JPanel {
	private static final long serialVersionUID = -8050331790929532841L;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Image bgImage = Toolkit.getDefaultToolkit().getImage(Main.class.getResource(Settings.UNIT_CIRCLE_IMAGE));
		g.drawImage(bgImage, 0, 0, null);
	}
}
