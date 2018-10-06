import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Timestamp;
import javax.swing.Timer;

import javax.swing.JFrame;

public class Run {
	public static int height, width, gapSize, sqrSize;
	public static boolean drawRec = true;
	public static Timer timer;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {

		JFrame frame = new JFrame("Generator");
		frame.setLayout(new BorderLayout());
		testGenerator panel = new testGenerator();

		timer = new Timer(660, null);
		timer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (drawRec) {
					drawRec = false;
					panel.repaint();
				}
			}
		});
		timer.start();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
		frame.setLocationRelativeTo(null);

		height = frame.getHeight();
		width = frame.getWidth();
		gapSize = 50;// gapSize is the gap size
		sqrSize = 100;// sqrSize is the size of rectangle

		panel.setBackground(Color.BLACK);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);// add panel, set background, etc.

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());// generate time stamp
		PrintStream out = new PrintStream(new FileOutputStream("OutFile" + timestamp + ".txt"));// generate output txt
																								// file

		out.println(timestamp);// print time stamp at the first gapSize of txt file

		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_Y) {
					gapSize = (int) (gapSize * 0.95);
					drawRec = true;
					timer.restart();
					panel.repaint();
					out.println("The current length of gap is " + gapSize);

				} else if (e.getKeyCode() == KeyEvent.VK_N) {
					gapSize = (int) (gapSize * 1.1);
					drawRec = true;
					timer.restart();
					panel.repaint();
					out.println("The current length of gap is " + gapSize);
				}
			}
		});
		frame.setFocusable(true);// set keyListner focus on frame

	}

}
