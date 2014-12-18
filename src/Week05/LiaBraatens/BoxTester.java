package Week05.LiaBraatens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.GridBagLayout;



/**
 * 1011-071_Labs, Purpose: to test the class GreyDisabledComboBoxRenderer
 * Class:    Lab:
 * FHT VERSION: 1.1 9/17/2014
 *
 * @version 1.0 Created on 10/10/2014 at 8:21 PM.
 * @author: Seth
 */
public class BoxTester
{

    private static final int[] SELECTION_INTERVAL = { 0, 1 };

    private JComboBox comboBox;
    private DefaultListSelectionModel model = new DefaultListSelectionModel();
    private GreyDisabledComboBoxRenderer enableRenderer = new GreyDisabledComboBoxRenderer();
    private JCheckBox disabledCheckBox;
    private EnabledChecker enabledListener = new EnabledChecker();
    private DisabledChecker disabledListener = new DisabledChecker();

        public BoxTester()
        {
        comboBox = createComboBox();
        disabledCheckBox = createCheckBox();

        JFrame frame = new JFrame("Disabled Combo Box Items");
        frame.setLayout(new GridBagLayout());
        frame.add(comboBox);
        frame.add(disabledCheckBox);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        }

    private JComboBox createComboBox()
    {
        String[] list = { "Enter Point 1", "Enter Point 2", "Calculate Distance", "Calculate Heading"};
        JComboBox cbox = new JComboBox(list);
        model.addSelectionInterval(SELECTION_INTERVAL[0], SELECTION_INTERVAL[1]);
        enableRenderer.setEnabledItems(model);
        cbox.setRenderer(enableRenderer);
        return cbox;
    }

    private class EnabledChecker implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("entered enabled checker");
            System.out.println(((JComboBox) e.getSource()).getSelectedItem());
        }
    }

    private class DisabledChecker implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("entered disabled checker");
            if (((JComboBox) e.getSource()).getSelectedIndex() != SELECTION_INTERVAL[0] && ((JComboBox) e.getSource()).getSelectedIndex() != SELECTION_INTERVAL[1])
            {
                JOptionPane.showMessageDialog(null,"you have not entered all of the points", "ERROR",JOptionPane.ERROR_MESSAGE);
            } else
            {
                System.out.println(((JComboBox) e.getSource()).getSelectedItem());
            }
        }
    }

    protected void disableItemsInComboBox()
    {
        comboBox.removeActionListener(enabledListener);
        comboBox.addActionListener(disabledListener);
        model.setSelectionInterval(SELECTION_INTERVAL[0], SELECTION_INTERVAL[1]);
    }

    protected void enableItemsInComboBox()
    {
        comboBox.removeActionListener(disabledListener);
        comboBox.addActionListener(enabledListener);
        model.setSelectionInterval(SELECTION_INTERVAL[0], comboBox.getModel().getSize() - 1);
    }

    private JCheckBox createCheckBox() {
        JCheckBox checkBox = new JCheckBox("diabled");
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    disableItemsInComboBox();
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    enableItemsInComboBox();
                }
            }
        });
        return checkBox;
    }
/*                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    disableItemsInComboBox();
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED)
                {
                    enableItemsInComboBox();
                }
*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BoxTester();
            }
        });
    }
}
