package homework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;


public class PaintPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int Csmall = 5;
	private static final int Cmedium = 10;
	private static final int Clarge = 20;
	private static final int POINT_SIZE = 5;
	private ArrayList<Save> _save;
	private ArrayList<PaintPoint> _points;
	private Color _color;
	private int _size;
	
	public PaintPanel() {
		setPreferredSize(new Dimension(400, 400));
        _save = new ArrayList<Save>();
		_points = new ArrayList<PaintPoint>();
		_color = Color.BLACK;
		_size = POINT_SIZE;
		
		MousePaintAdapter mpa = new MousePaintAdapter();
		addMouseMotionListener(mpa);
		repaint();
	}

	public void clear(){
		_save = new ArrayList<Save>();
		_points = new ArrayList<PaintPoint>();
		repaint();
	}
	public void black(){
		if (_color != Color.black){
			_save.add(new Save(_points,_color,_size));
			_points = new ArrayList<PaintPoint>();
			repaint();
			_color = Color.black;			
		}		
	}
	public void green(){
		if (_color != Color.green){
			_save.add(new Save(_points,_color,_size));
			_points = new ArrayList<PaintPoint>();
			repaint();
			_color = Color.green;			
		}		
	}
	public void yellow(){
		if (_color != Color.yellow){
			_save.add(new Save(_points,_color,_size));
			_points = new ArrayList<PaintPoint>();
			repaint();
			_color = Color.yellow;			
		}		
	}
	public void gray(){
		if (_color != Color.gray){
			_save.add(new Save(_points,_color,_size));
			_points = new ArrayList<PaintPoint>();
			repaint();
			_color = Color.gray;			
		}		
	}
	public void small(){
		_save.add(new Save(_points,_color,_size));
		_points = new ArrayList<PaintPoint>();
		repaint();
		_size = Csmall;				
	}
	public void medium(){
		_save.add(new Save(_points,_color,_size));
		_points = new ArrayList<PaintPoint>();
		repaint();
		_size = Cmedium;				
	}
	public void large(){
		_save.add(new Save(_points,_color,_size));
		_points = new ArrayList<PaintPoint>();
		repaint();
		_size = Clarge;				
	}
	
	
	class Save{
		private ArrayList<PaintPoint> _save;
		private Color _color;
		private int _size;
		
		public Save(ArrayList<PaintPoint> save, Color color, int size){
			_save = save;
			_color = color;
			_size = size;
		}
		public ArrayList<PaintPoint> returnsave(){
			return _save;
		}
		public Color returnColor(){
			return _color;
		}
		public int returnSize(){
			return _size;
		}		
	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);	
		for (Save save : _save){
			graphics.setColor(save.returnColor());
			int tempSize = save.returnSize();
			for (PaintPoint point : save.returnsave()){
				graphics.fillOval(point.getX(), point.getY(), tempSize, tempSize);
			}
		}
		graphics.setColor(_color);
		for (PaintPoint point : _points) {
			graphics.fillOval(point.getX(), point.getY(), _size, _size);
		}
	}
	
	private class MousePaintAdapter extends MouseAdapter {
		@Override
		public void mouseDragged(MouseEvent ev) {
			_points.add(new PaintPoint(ev.getX(), ev.getY()));
			repaint();
		}
	}
	private class PaintPoint {
		private final int _x;
		private final int _y;
		
		public PaintPoint(int x, int y) {
			_x = x;
			_y = y;
		}
		
		public int getX() { return _x; }
		public int getY() { return _y; }
	}
}