import javax.swing.*;
import api.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JLabel;
import javax.swing.event.AncestorListener;

import static java.awt.Color.black;
import static java.awt.Color.yellow;
import static java.awt.SystemColor.window;
public class Panelmain extends JPanel {
    public static class algopanel implements ActionListener {
        JButton alg;
        JButton chan;
        JButton load_file;
        JButton save_file;
        JTextField load_file_text;
        JButton Tsp_b;
        JTextField Tsp_b_text;
        JButton isConnected;
        JButton center_node;
        JButton shorted_dis;
        JTextField shorted_dis_text;
        JButton shorted_path;
        JTextField shorted_path_text;

        public algopanel(JButton algo, JButton changes, JButton load_file, JTextField load_file_text, JButton save_file, JButton tsp_b, JTextField tsp_b_text, JButton isConnected, JButton center_node, JButton shorted_dis, JTextField shorted_dis_text, JButton shorted_path, JTextField shorted_path_text) {
            this.shorted_path = shorted_path;
            this.shorted_path_text = shorted_path_text;
            this.shorted_dis = shorted_dis;
            this.shorted_dis_text = shorted_dis_text;
            this.alg = algo;
            this.chan = changes;
            this.save_file = save_file;
            this.load_file = load_file;
            this.load_file_text = load_file_text;
            this.Tsp_b = tsp_b;
            this.Tsp_b_text = tsp_b_text;
            this.isConnected = isConnected;
            this.center_node = center_node;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            this.alg.setLocation(2000, 2000);
            this.chan.setLocation(3000, 3000);
            this.shorted_path.setLocation(1230, 180);
            this.shorted_path_text.setLocation(1230, 210);
            this.shorted_dis.setLocation(1230, 240);
            this.shorted_dis_text.setLocation(1230, 270);
            this.center_node.setLocation(1230, 300);
            this.isConnected.setLocation(1230, 330);
            this.Tsp_b.setLocation(1230, 120);
            this.Tsp_b_text.setLocation(1230, 150);
            this.load_file.setLocation(1230, 60);
            this.load_file_text.setLocation(1230, 90);
            this.save_file.setLocation(1230, 360);
        }

    }

    public static class changepanel implements ActionListener {
        JButton alg;
        JButton chan;
        JButton remove_node;
        JTextField remove_node_text;
        JButton remove_edge;
        JTextField remove_edge_text;
        JButton add_node;
        JButton add_edge;
        JTextField add_edge_text;
        JTextField add_node_text;
        JButton connect;
        JTextField connect_text;
        JLabel nodes_size;
        JLabel edges_size;
        JLabel mc_size;
        Frame frame;
        public changepanel(JButton algo, JButton changes, JButton remove_node, JTextField remove_node_text, JButton remove_edge, JTextField remove_edge_text, JButton add_node, JTextField add_node_text, JButton add_edge, JTextField add_edge_text, JButton connect, JTextField connect_text, JLabel nodes_size, JLabel edges_size, JLabel mc_size) {
            this.alg = algo;
            this.chan = changes;
            this.remove_node = remove_node;
            this.remove_node_text = remove_node_text;
            this.remove_edge = remove_edge;
            this.remove_edge_text = remove_edge_text;
            this.add_edge_text = add_edge_text;
            this.add_edge = add_edge;
            this.add_node_text = add_node_text;
            this.add_node = add_node;
            this.connect = connect;
            this.connect_text = connect_text;
            this.nodes_size = nodes_size;
            this.edges_size = edges_size;
            this.mc_size = mc_size;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            this.alg.setLocation(2000, 2000);
            this.chan.setLocation(3000, 3000);

            this.remove_node.setLocation(1230, 60);
            this.remove_node_text.setLocation(1230, 90);
            this.add_node.setLocation(1230, 120);
            this.add_node_text.setLocation(1230, 150);
            this.remove_edge.setLocation(1380, 60);
            this.remove_edge_text.setLocation(1380, 90);
            this.add_edge.setLocation(1380, 120);
            this.add_edge_text.setLocation(1380, 150);
            this.connect.setLocation(1300, 180);
            this.connect_text.setLocation(1300, 210);
            this.nodes_size.setLocation(1300, 240);
            this.edges_size.setLocation(1300, 270);
            this.mc_size.setLocation(1300, 300);
        }

    }

    public static class backpanel implements ActionListener {
        JButton alg;
        JButton chan;
        JButton remove_node;
        JTextField remove_node_text;
        JButton remove_edge;
        JTextField remove_edge_text;
        JButton add_node;
        JButton add_edge;
        JTextField add_edge_text;
        JTextField add_node_text;
        JButton connect;
        JTextField connect_text;
        JLabel nodes_size;
        JLabel edges_size;
        JLabel mc_size;
        JButton load_file;
        JButton save_file;
        JTextField load_file_text;
        JButton Tsp_b;
        JTextField Tsp_b_text;
        JButton isConnected;
        JButton center_node;
        JButton shorted_dis;
        JTextField shorted_dis_text;
        JButton shorted_path;
        JTextField shorted_path_text;

        public backpanel(JButton algo, JButton changes, JButton remove_node, JTextField remove_node_text, JButton remove_edge, JTextField remove_edge_text, JButton add_node, JTextField add_node_text, JButton add_edge, JTextField add_edge_text, JButton connect, JTextField connect_text, JLabel nodes_size, JLabel edges_size, JLabel mc_size, JButton load_file, JTextField load_file_text, JButton save_file, JButton tsp_b, JTextField tsp_b_text, JButton isConnected, JButton center_node, JButton shorted_dis, JTextField shorted_dis_text, JButton shorted_path, JTextField shorted_path_text) {
            this.shorted_path = shorted_path;
            this.shorted_path_text = shorted_path_text;
            this.shorted_dis = shorted_dis;
            this.shorted_dis_text = shorted_dis_text;
            this.alg = algo;
            this.chan = changes;
            this.remove_node = remove_node;
            this.remove_node_text = remove_node_text;
            this.remove_edge = remove_edge;
            this.remove_edge_text = remove_edge_text;
            this.add_edge_text = add_edge_text;
            this.add_edge = add_edge;
            this.add_node_text = add_node_text;
            this.add_node = add_node;
            this.connect = connect;
            this.connect_text = connect_text;
            this.nodes_size = nodes_size;
            this.edges_size = edges_size;
            this.mc_size = mc_size;
            this.save_file = save_file;
            this.load_file = load_file;
            this.load_file_text = load_file_text;
            this.Tsp_b = tsp_b;
            this.Tsp_b_text = tsp_b_text;
            this.isConnected = isConnected;
            this.center_node = center_node;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {

            this.alg.setLocation(1330, 10);
            this.chan.setLocation(1230, 10);
            this.shorted_path_text.setLocation(3000, 3000);
            this.shorted_path.setLocation(3000, 3000);
            this.shorted_dis.setLocation(3000, 3000);
            this.shorted_dis_text.setLocation(3000, 3000);
            this.center_node.setLocation(3000, 3000);
            this.isConnected.setLocation(3000, 3000);
            this.Tsp_b_text.setLocation(3000, 3000);
            this.Tsp_b.setLocation(3000, 3000);
            this.remove_node.setLocation(3000, 3000);
            this.remove_node_text.setLocation(3000, 3000);
            this.remove_edge_text.setLocation(3000, 3000);
            this.remove_edge.setLocation(3000, 3000);
            this.add_edge.setLocation(3000, 3000);
            this.add_edge_text.setLocation(3000, 3000);
            this.add_node.setLocation(3000, 3000);
            this.add_node_text.setLocation(3000, 3000);
            this.connect.setLocation(3000, 3000);
            this.connect_text.setLocation(3000, 3000);
            this.edges_size.setLocation(3000, 3000);
            this.nodes_size.setLocation(3000, 3000);
            this.mc_size.setLocation(3000, 3000);
            this.save_file.setLocation(3000, 3000);
            this.load_file_text.setLocation(3000, 3000);
            this.load_file.setLocation(3000, 3000);
        }

    }

    public Panelmain(){
    JButton remove_node = new JButton("Remove node");
            remove_node.setBounds(10, 80, 130, 25);
    JTextField remove_node_text = new JTextField();
            remove_node_text.setBounds(10, 80, 130, 25);
            add(remove_node);
            add(remove_node_text);
    JButton load_file = new JButton("Load file (full path)");
            load_file.setBounds(10, 80, 250, 25);
    JTextField load_file_text = new JTextField();
            load_file_text.setBounds(10, 80, 250, 25);
            add(load_file_text);
            add(load_file);
    JButton tsp_b = new JButton("Tsp anter list");
            tsp_b.setBounds(10, 80, 250, 25);
    JTextField tsp_b_text = new JTextField();
            tsp_b_text.setBounds(10, 80, 250, 25);
            add(tsp_b);
            add(tsp_b_text);
    JButton center_node = new JButton("center node");
            center_node.setBounds(10, 80, 250, 25);
            add(center_node);
    JButton is_connected = new JButton("is the graph Connected");
            is_connected.setBounds(10, 80, 250, 25);
            add(is_connected);
    JButton shorted_dis = new JButton("Shorted path distance src>dest");
            shorted_dis.setBounds(10, 80, 250, 25);
    JTextField shorted_dis_text = new JTextField();
            shorted_dis_text.setBounds(10, 80, 250, 25);
            add(shorted_dis);
            add(shorted_dis_text);
    JButton shorted_path = new JButton("Shorted path List src>dest");
            shorted_path.setBounds(10, 80, 250, 25);
    JTextField shorted_path_text = new JTextField();
            shorted_path_text.setBounds(10, 80, 250, 25);
            add(shorted_path_text);
            add(shorted_path);
    JButton save_file = new JButton("Save file ");
            save_file.setBounds(10, 80, 250, 25);
            add(save_file);

    int nodesize, edgesize, mc;
            if (Ex2.alg == null) {
        nodesize = 0;
        edgesize = 0;
        mc = 0;
    } else {
        nodesize = Ex2.alg.getGraph().nodeSize();
        edgesize = Ex2.alg.getGraph().edgeSize();
        mc = Ex2.alg.getGraph().getMC();
    }

    JLabel nodes_size = new JLabel("The nodes size is:" + nodesize);
            nodes_size.setBounds(10, 80, 130, 25);
            add(nodes_size);
    JLabel edegs_size = new JLabel("The edges size is:" + edgesize);
            edegs_size.setBounds(10, 80, 130, 25);
            add(edegs_size);
    JLabel mc_size = new JLabel("The mc size is:" + mc);
            mc_size.setBounds(10, 80, 130, 25);
            add(mc_size);

    JButton connect = new JButton("Connect nodes");
            connect.setBounds(10, 80, 130, 25);
    JTextField connect_text = new JTextField();
            connect_text.setBounds(10, 80, 130, 25);
            add(connect);
            add(connect_text);
    JButton add_node = new JButton("Add node");
            add_node.setBounds(10, 80, 130, 25);
    JTextField add_node_text = new JTextField();
            add_node_text.setBounds(10, 80, 130, 25);
            add(add_node);
            add(add_node_text);
    JButton add_edge = new JButton("Add edge");
            add_edge.setBounds(10, 80, 130, 25);
    JTextField add_edge_text = new JTextField();
            add_edge_text.setBounds(10, 80, 130, 25);
            add(add_edge);
            add(add_edge_text);
    JButton remove_edge = new JButton("Remove edge");
            remove_edge.setBounds(10, 80, 130, 25);
    JTextField remove_edge_text = new JTextField();
            remove_edge_text.setBounds(10, 80, 130, 25);
            add(remove_edge);
            add(remove_edge_text);
    JButton changes = new JButton("Changes");
            changes.setBounds(10, 80, 90, 25);
            add(changes);






    JButton algo = new JButton("Algorithms");
            algo.setBounds(10, 80, 100, 25);
          add(algo);


           algo.addActionListener(new algopanel(algo, changes, load_file, load_file_text, save_file, tsp_b, tsp_b_text, is_connected, center_node, shorted_dis, shorted_dis_text, shorted_path, shorted_path_text));
           changes.addActionListener(new changepanel(algo, changes, remove_node, remove_node_text, remove_edge, remove_edge_text, add_node, add_node_text, add_edge, add_edge_text, connect, connect_text, nodes_size, edegs_size, mc_size));

            JButton back = new JButton("Back");
            back.setBounds(10, 80, 70, 25);
            add(back);
            back.setLocation(1450, 10);
            back.addActionListener(new backpanel(algo, changes, remove_node, remove_node_text, remove_edge, remove_edge_text, add_node, add_node_text, add_edge, add_edge_text, connect, connect_text, nodes_size, edegs_size, mc_size, load_file, load_file_text, save_file, tsp_b, tsp_b_text, is_connected, center_node, shorted_dis, shorted_dis_text, shorted_path, shorted_path_text));
            shorted_path_text.setLocation(3000, 3000);
            algo.setLocation(1330, 10);
            changes.setLocation(1230, 10);
            shorted_path.setLocation(3000, 3000);
            shorted_dis.setLocation(3000, 3000);
            shorted_dis_text.setLocation(3000, 3000);
            center_node.setLocation(3000, 3000);
            is_connected.setLocation(3000, 3000);
            tsp_b_text.setLocation(3000, 3000);
            tsp_b.setLocation(3000, 3000);
            remove_node.setLocation(3000, 3000);
            remove_node_text.setLocation(3000, 3000);
            remove_edge_text.setLocation(3000, 3000);
            remove_edge.setLocation(3000, 3000);
            add_edge.setLocation(3000, 3000);
            add_edge_text.setLocation(3000, 3000);
            add_node.setLocation(3000, 3000);
            add_node_text.setLocation(3000, 3000);
            connect.setLocation(3000, 3000);
            connect_text.setLocation(3000, 3000);
            edegs_size.setLocation(3000, 3000);
            nodes_size.setLocation(3000, 3000);
            mc_size.setLocation(3000, 3000);
            save_file.setLocation(3000, 3000);
            load_file_text.setLocation(3000, 3000);
            load_file.setLocation(3000, 3000);


}}
