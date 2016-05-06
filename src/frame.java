import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		int[][] framebuffer = new int[512][512];
		
		circle c = new circle(framebuffer, (framebuffer[0].length/2), (framebuffer.length/2), 200);
//		circle c = new circle(framebuffer, 200, 200, 30);
		c.fillBuffer();
		
//		circle d = new circle(framebuffer,100, 100, 30);
//		d.fillBuffer();
//		
		BufferedImage bi = new BufferedImage(framebuffer[0].length,
				framebuffer.length, BufferedImage.TYPE_INT_RGB);
				 for (int i = 0; i < bi.getHeight(); ++i) {
				 for (int j = 0; j < bi.getWidth(); ++j) {
				 int val = framebuffer[i][j];
				 int pixel = (val << 16) | (val << 8) | (val);
				 bi.setRGB(j, i, pixel);
				 }
				 }
				 // -- save BufferedImage to a PNG file
				File outfile = new File("C:/sphere.png");
				try {
				ImageIO.write(bi, "PNG", outfile);
				} catch (IOException e) {
				System.out.println("cannot open sphere.png");
				}

	}

}
