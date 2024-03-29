/*
 * Created by JFormDesigner on Sat Apr 07 20:53:19 MDT 2018
 */

package ClientPack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import SharedDataObjects.*;

/**
 *  * Creates the student's homepage with all their courses listed, including the ability to activate/deactivate, add, delete and open course page.
 * @author Aysha Panatch, Natalia Pavlovic, Eddy Gu
 * @version 1.0
 * @since April 11, 2018
 */

public class StudentGUI extends JFrame implements ActionListener, ListSelectionListener {
    /**
     * Constructs a Student object with the specified values for in, out and student.
     * The values for the fields are supplied by the given parameters.
     * @param in the ObjectInputStream used to read objects from the socket
     * @param out the ObjectOutputStream used to write objects to the socket
     * @param student the Student whose GUI is constructed
     */
    StudentGUI(ObjectInputStream in, ObjectOutputStream out, User student) {
        this.in = in;
        this.out = out;
        this.student = student;
        initComponents();
        openCourse.setEnabled(false);

        try {
            //MODIFY COMMAND BASED ON THE FUNCTION DESIRED
            student.setCommand("GETCOURSES");
            out.writeObject(student);
            Course[] received = (Course[])(in.readObject());
            if(received!=null) {
                courseList.setListData(received);
            }
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        courseList.addListSelectionListener(this);
        logout.addActionListener(this);
        openCourse.addActionListener(this);
        frame1.setSize(700, 700);
        frame1.setVisible(true);
    }

    /**
     * Intialises and creates the GUI.
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Edward Gu
        frame1 = new JFrame();
        panel1 = new JPanel();
        panel7 = new JPanel();
        hSpacer3 = new JPanel(null);
        hSpacer4 = new JPanel(null);
        hSpacer6 = new JPanel(null);
        hSpacer8 = new JPanel(null);
        hSpacer7 = new JPanel(null);
        hSpacer5 = new JPanel(null);
        hSpacer2 = new JPanel(null);
        logout = new JButton();
        panel8 = new JPanel();
        panel9 = new JPanel();
        label2 = new JLabel();
        panel10 = new JPanel();
        label3 = new JLabel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        openCourse = new JButton();
        panel6 = new JPanel();
        scrollPane2 = new JScrollPane();
        courseList = new JList<>();

        //======== frame1 ========
        {
            frame1.setTitle("My Courses");
            frame1.setBackground(new Color(0, 153, 255));
            frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(new BorderLayout());

            //======== panel1 ========
            {
                panel1.setBackground(new Color(115, 194, 251));

                panel1.setLayout(new GridLayout(4, 1));

                //======== panel7 ========
                {
                    panel7.setBackground(new Color(115, 194, 251));
                    panel7.setPreferredSize(new Dimension(1200, 34));
                    panel7.setMinimumSize(new Dimension(1200, 34));
                    panel7.setLayout(new GridLayout(1, 10));

                    //---- hSpacer3 ----
                    hSpacer3.setBackground(new Color(115, 194, 251));
                    panel7.add(hSpacer3);

                    //---- hSpacer4 ----
                    hSpacer4.setBackground(new Color(115, 194, 251));
                    panel7.add(hSpacer4);

                    //---- hSpacer6 ----
                    hSpacer6.setBackground(new Color(115, 194, 251));
                    panel7.add(hSpacer6);

                    //---- hSpacer8 ----
                    hSpacer8.setBackground(new Color(115, 194, 251));
                    panel7.add(hSpacer8);

                    //---- hSpacer7 ----
                    hSpacer7.setBackground(new Color(115, 194, 251));
                    panel7.add(hSpacer7);

                    //---- hSpacer5 ----
                    hSpacer5.setBackground(new Color(115, 194, 251));
                    panel7.add(hSpacer5);

                    //---- hSpacer2 ----
                    hSpacer2.setBackground(new Color(115, 194, 251));
                    panel7.add(hSpacer2);

                    //---- logout ----
                    logout.setText("Logout");
                    logout.setForeground(Color.black);
                    logout.setBackground(Color.white);
                    logout.setMinimumSize(new Dimension(100, 32));
                    panel7.add(logout);
                }
                panel1.add(panel7);

                //======== panel8 ========
                {
                    panel8.setBackground(new Color(115, 194, 251));
                    panel8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 1));
                }
                panel1.add(panel8);

                //======== panel9 ========
                {
                    panel9.setBackground(new Color(115, 194, 251));
                    panel9.setLayout(new FlowLayout());

                    //---- label2 ----
                    label2.setText("Welcome to !D2L");
                    label2.setFont(new Font(".SF NS Text", Font.BOLD, 24));
                    label2.setForeground(Color.black);
                    panel9.add(label2);
                }
                panel1.add(panel9);

                //======== panel10 ========
                {
                    panel10.setForeground(new Color(115, 194, 251));
                    panel10.setBackground(new Color(115, 194, 251));
                    panel10.setLayout(new FlowLayout());

                    //---- label3 ----
                    label3.setText("Courses");
                    label3.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
                    label3.setForeground(Color.black);
                    panel10.add(label3);
                }
                panel1.add(panel10);
            }
            frame1ContentPane.add(panel1, BorderLayout.NORTH);

            //======== panel4 ========
            {
                panel4.setBackground(new Color(115, 194, 251));
                panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
            }
            frame1ContentPane.add(panel4, BorderLayout.WEST);

            //======== panel5 ========
            {
                panel5.setBackground(new Color(115, 194, 251));
                panel5.setMaximumSize(new Dimension(500, 30));
                panel5.setMinimumSize(new Dimension(500, 30));
                panel5.setPreferredSize(new Dimension(700, 70));
                panel5.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));

                //---- openCourse ----
                openCourse.setText("Open Course");
                openCourse.setBackground(Color.white);
                openCourse.setForeground(Color.black);
                panel5.add(openCourse);
            }
            frame1ContentPane.add(panel5, BorderLayout.SOUTH);

            //======== panel6 ========
            {
                panel6.setBackground(new Color(115, 194, 251));
                panel6.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
            }
            frame1ContentPane.add(panel6, BorderLayout.EAST);

            //======== scrollPane2 ========
            {

                //---- courseList ----
                courseList.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
                courseList.setBackground(Color.white);
                courseList.setForeground(Color.black);
                scrollPane2.setViewportView(courseList);
            }
            frame1ContentPane.add(scrollPane2, BorderLayout.CENTER);
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Edward Gu
    private JFrame frame1;
    private JPanel panel1;
    private JPanel panel7;
    private JPanel hSpacer3;
    private JPanel hSpacer4;
    private JPanel hSpacer6;
    private JPanel hSpacer8;
    private JPanel hSpacer7;
    private JPanel hSpacer5;
    private JPanel hSpacer2;
    private JButton logout;
    private JPanel panel8;
    private JPanel panel9;
    private JLabel label2;
    private JPanel panel10;
    private JLabel label3;
    private JPanel panel4;
    private JPanel panel5;
    private JButton openCourse;
    private JPanel panel6;
    private JScrollPane scrollPane2;
    private JList<Course> courseList;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private User student;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private ViewCourses manager;
    /**
     * The frame is the main frame of the GUI.
     * The panel, scrollpanes, labels and spacers fields help with the formatting of the GUI.
     * courseList is the JList that displays all the professor's courses.
     * Each JButton is named the action that executed when they are pressed.
     * User stores the professor using the GUI.
     * in and out are ObjectStreams used to help send data to the server from the client.
     * manager is a ViewCourses manager to help modify/create/delete data regarding courses in this GUI.
     */

    /**
     * Generates the correct response/actions depending on what buttons the professor clicks.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == logout) {
            System.exit(0);
        }
        else if(e.getSource() == openCourse) {
            Course current = courseList.getSelectedValue();
            manager = new ViewCourses(in, out, current, student);
        }
    }
    /**
     * Enables certain buttons when the list is clicked.
     */
    public void valueChanged (ListSelectionEvent e){
        if(e.getSource() == courseList) {
            openCourse.setEnabled(true);
        }
    }
}
