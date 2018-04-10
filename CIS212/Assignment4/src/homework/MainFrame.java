package homework;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PaintPanel _paintPanel;
	
	public MainFrame() {
		super("Main");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());		
		_paintPanel = new PaintPanel();
		add(_paintPanel, BorderLayout.CENTER);
		
		
		JButton Button1 = new JButton("Black");
		Button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				_paintPanel.black();
			}
		});
		JButton Button2 = new JButton("Green");
		Button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				_paintPanel.green();
			}
		});
		
		JButton Button3 = new JButton("Yellow");
		Button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {				
				_paintPanel.yellow();
			}
		});
		
		JButton Button4 = new JButton("Gray");
		Button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				_paintPanel.gray();
			}
		});

		
		JButton sizeButton1 = new JButton("Small");		
		sizeButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {		
				_paintPanel.small();
			}
		});
		
		JButton sizeButton2 = new JButton("Medium");		
		sizeButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {			
				_paintPanel.medium();
			}
		});
		
		JButton sizeButton3 = new JButton("Large");		
		sizeButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {			
				_paintPanel.large();
			}
		});
		
		JButton clear = new JButton("Clear");		
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				_paintPanel.clear();
			}
		});
		
		
		
		
		
		JPanel buttonLeft = new JPanel();
		buttonLeft.setLayout(new GridLayout(4,0));
		buttonLeft.add(Button1);
		buttonLeft.add(Button2);
		buttonLeft.add(Button3);
		buttonLeft.add(Button4);
		add(buttonLeft, BorderLayout.WEST);	
		
		JPanel buttonRight = new JPanel();
		buttonRight.setLayout(new GridLayout(4,0));
		buttonRight.add(sizeButton1);
		buttonRight.add(sizeButton2);
		buttonRight.add(sizeButton3);
		buttonRight.add(clear);
		add(buttonRight, BorderLayout.EAST);	

		
		pack();
	}	
}
