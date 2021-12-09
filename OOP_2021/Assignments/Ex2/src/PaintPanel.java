import api.DirectedWeightedGraph;
import api.EdgeData;
import api.NodeData;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class PaintPanel extends JPanel {
    private final String file;
    public PaintPanel(String file_name){
        this.file = file_name;
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int width = getWidth();
        int hight = getHeight();
        DirectedWeightedGraph graph = Ex2.getGrapg(this.file);
        Iterator<NodeData> it = graph.nodeIter();
        g.setColor(Color.BLACK);
        while (it.hasNext()) {
            NodeData curr = it.next();
            g.fillOval((int)(curr.getLocation().x()*30000)%1000, (int)(curr.getLocation().y()*30000)%1000, 10, 10);
        }
        Iterator<EdgeData> ite = graph.edgeIter();
        g.setColor(Color.RED);
        while(ite.hasNext()){
            EdgeData e = ite.next();
            double srcX = graph.getNode(e.getSrc()).getLocation().x();
            double srcY = graph.getNode(e.getSrc()).getLocation().y();
            double destX = graph.getNode(e.getDest()).getLocation().x();
            double destY = graph.getNode(e.getDest()).getLocation().y();
            g.drawLine((int)(srcX*30000)%1000,(int)(srcY*30000)%1000, (int)(destX*30000)%1000, (int)(destY*30000)%1000);
        }
    }
}
