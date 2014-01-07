package trainingRoom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class IntersectPoint {

    public static void main(String[] args) {
        new IntersectPoint();
    }

    public IntersectPoint() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex){
                	
                } catch (InstantiationException ex){
                	
                } catch (IllegalAccessException ex){
                	
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                TestPane testPane=new TestPane();
                
                JPanel panel= new JPanel();
                panel.setBounds(25, 25, 120, 120);
                panel.setBackground(Color.YELLOW);
                testPane.add(panel);
                testPane.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(testPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        public void paint(Graphics g){
        	paintComponent(g);
        	paintBorder(g);
        	paintChildren(g);
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int x = (int) (getWidth() * 0.2f);
            int y = (int) (getHeight() * 0.2f);
            int width = (int) (getWidth() * 0.6f);
            int height = (int) (getHeight() * 0.6f);

            int x1 = x;
            int y1 = 0;
            int x2 = x + width;
            int y2 = getHeight();

            Line2D line1 = new Line2D.Double(x1, y1, x2, y2);
            Line2D line2 = new Line2D.Double(x1-30, y1, x2+30, y2);
            Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);

            Graphics2D g2d = (Graphics2D) g.create();
            g2d.draw(rect);
            g2d.draw(line1);
            g2d.draw(line2);

            g2d.setColor(Color.RED);
            Point2D[] ps = getIntersectionPoint(line1, rect);
            for (Point2D p : ps) System.out.println("point="+p);
            
            for (Point2D p : ps) {
                if (p != null) {
//                	if(rect.contains(p)) g2d.fill(new Ellipse2D.Double(p.getX() - 3, p.getY() - 3, 6, 6));
//                	else{
//                        g2d.setColor(Color.ORANGE);
                        g2d.fill(new Ellipse2D.Double(p.getX() - 3, p.getY() - 3, 6, 6));
//                        g2d.setColor(Color.RED);
//                	}
                }
            }

            g2d.setColor(Color.GREEN);
            ps = getIntersectionPoint(line2, rect);
            for (Point2D p : ps) {
                if (p != null) {
//                	if(rect.contains(p)) g2d.fill(new Ellipse2D.Double(p.getX() - 3, p.getY() - 3, 6, 6));
//                	else{
//                        g2d.setColor(Color.ORANGE);
                        g2d.fill(new Ellipse2D.Double(p.getX() - 3, p.getY() - 3, 6, 6));
//                        g2d.setColor(Color.GREEN);
//                	}
                }
            }

            
            g2d.dispose();

        }

        public Point2D[] getIntersectionPoint(Line2D line, Rectangle2D rectangle) {

        	Line2D top=null, bottom=null, left=null, right=null;
            Point2D[] p = new Point2D[4];

            
            // Top line
            top=new Line2D.Double(rectangle.getX(), rectangle.getY(),
            		rectangle.getX() + rectangle.getWidth(), rectangle.getY());
            
            // Bottom line
            bottom=new Line2D.Double(rectangle.getX(), rectangle.getY() + rectangle.getHeight(),
            		rectangle.getX() + rectangle.getWidth(), rectangle.getY() + rectangle.getHeight());

            //Left line
            left=new Line2D.Double(rectangle.getX(), rectangle.getY(),
            		rectangle.getX(), rectangle.getY() + rectangle.getHeight());

            // Right line
            right=new Line2D.Double(rectangle.getX() + rectangle.getWidth(), rectangle.getY(),
            		rectangle.getX() + rectangle.getWidth(), rectangle.getY() + rectangle.getHeight());
            
            p[0] = getIntersectionPoint(line, top);
            p[1] = getIntersectionPoint(line, bottom);
            p[2] = getIntersectionPoint(line, left);
            p[3] = getIntersectionPoint(line, right);

            
            //checking that point really are contained in the lines
            if(!top.intersectsLine(new Line2D.Double(p[0], p[0]) ) ) p[0]=null;
            if(!bottom.intersectsLine(new Line2D.Double(p[1], p[1]) ) ) p[1]=null;
            if(!left.intersectsLine(new Line2D.Double(p[2], p[2]) ) ) p[2]=null;
            if(!right.intersectsLine(new Line2D.Double(p[3], p[3]) ) ) p[3]=null;

//            if(!bottom.contains(p[1])) p[1]=null;
//            if(!left.contains(p[2])) p[2]=null;
//            if(!right.contains(p[3])) p[3]=null;
            
            return p;

        }

        public Point2D getIntersectionPoint(Line2D lineA, Line2D lineB) {

            double x1 = lineA.getX1();
            double y1 = lineA.getY1();
            double x2 = lineA.getX2();
            double y2 = lineA.getY2();

            double x3 = lineB.getX1();
            double y3 = lineB.getY1();
            double x4 = lineB.getX2();
            double y4 = lineB.getY2();

            Point2D p = null;

            double d = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
            if (d != 0) {//RETTE NON PARALLELE
                double xi = ((x3 - x4) * (x1 * y2 - y1 * x2) - (x1 - x2) * (x3 * y4 - y3 * x4)) / d;
                double yi = ((y3 - y4) * (x1 * y2 - y1 * x2) - (y1 - y2) * (x3 * y4 - y3 * x4)) / d;

                p = new Point2D.Double(xi, yi);

            }
            return p;
        }
    }
}

