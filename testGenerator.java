import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class testGenerator extends JPanel {

	public void paintComponent(Graphics g) {
		int height = Run.height, width = Run.width, gapSize = Run.gapSize, sqrSize = Run.sqrSize;
		boolean drawRec = Run.drawRec;

		super.paintComponent(g);
		g.setColor(Color.RED);
		Font font = g.getFont().deriveFont(40.0f);
		g.setFont(font);
		g.drawString("+", width / 2 - 10, height / 2 - 10);

		Font font2 = g.getFont().deriveFont(15.0f);
		g.setFont(font2);
		g.setColor(Color.WHITE);
		g.drawString(
				"The resolution of this monitor is " + height + "*" + width + "    " + "The current gapsize is " + gapSize,
				width / 8, height / 8 * 7);

		if (drawRec) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(6));
			g2.setColor(Color.WHITE);
			g2.drawRect((int) (0.076 * width) - sqrSize / 2, (int) (0.076 * height) - sqrSize / 2, sqrSize, sqrSize);
			g2.setColor(Color.BLACK);
			g2.drawLine((int) (0.076 * width) - sqrSize / 2 + (sqrSize / 2 - gapSize / 2),
					(int) (0.076 * height) - sqrSize / 2 + sqrSize,
					(int) (0.076 * width) - sqrSize / 2 + (sqrSize / 2 + gapSize / 2),
					(int) (0.076 * height) - sqrSize / 2 + sqrSize);
		}

	}

}
