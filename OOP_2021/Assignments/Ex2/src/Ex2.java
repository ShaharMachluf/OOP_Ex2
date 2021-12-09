import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.My_DirectedWeightedGraphAlgorithmsImpl;

import javax.swing.*;
import java.awt.*;

/**
 * This class is the main class for Ex2 - your implementation will be tested using this class.
 */
public class Ex2 {
    static final int WIDTH = 1080;
    static final int HEIGHT = (int) (WIDTH / 1.6);
    static String file;
    public  static   DirectedWeightedGraphAlgorithms alg ;
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraph getGrapg(String json_file) {
        file = json_file;
        DirectedWeightedGraph ans = null;
        DirectedWeightedGraphAlgorithms algo = getGrapgAlgo(json_file);
        ans = algo.getGraph();
        return ans;
    }
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraphAlgorithms getGrapgAlgo(String json_file) {
        file = json_file;
        DirectedWeightedGraphAlgorithms ans = null;
        ans = new My_DirectedWeightedGraphAlgorithmsImpl();
        ans.load(json_file);
        return ans;
    }
    /**
     * This static function will run your GUI using the json fime.
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     *
     */
    public static void runGUI(String json_file) {
        file = json_file;
        DirectedWeightedGraphAlgorithms alg = getGrapgAlgo(json_file);

    }

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PaintPanel paintPanel = new PaintPanel(file);
        Panelmain panelmain = new Panelmain();
        paintPanel.setPreferredSize(new Dimension(Ex2.WIDTH, (Ex2.HEIGHT * 3) / 4));
        mainFrame.getContentPane().add(paintPanel, BorderLayout.NORTH);
        mainFrame.add(panelmain,BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }
}