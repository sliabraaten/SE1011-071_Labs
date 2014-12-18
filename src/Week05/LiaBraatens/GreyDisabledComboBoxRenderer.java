package Week05.LiaBraatens;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

/**
 * 1011-071_Labs, Purpose:
 * Class:    Lab:
 * FHT VERSION: 1.1 9/17/2014
 *
 * @version 1.0 Created on 10/10/2014 at 10:26 AM.
 * @author: Seth
 */
public class GreyDisabledComboBoxRenderer extends BasicComboBoxRenderer
{
    private Color greyedBox = Color.lightGray;
    private ListSelectionModel enabledItems;

    public GreyDisabledComboBoxRenderer()
    {

    }

    /**
     *
     * @param usable
     */
    public GreyDisabledComboBoxRenderer (ListSelectionModel usable)
    {
        super();
        this.enabledItems = usable;
    }

    public void setGreyedBox(Color greyedOption)
    {
        this.greyedBox = greyedOption;
    }

    public void setEnabledItems(ListSelectionModel enabledItems)
    {
        this.enabledItems = enabledItems;
    }

    public Component getListCellRendererComponent(JList list, Object value, int itemIndex, boolean isSelected, boolean cellHasFocus)
    {
        Component compnt = super.getListCellRendererComponent(list, value, itemIndex, isSelected, cellHasFocus);
        if (!enabledItems.isSelectedIndex(itemIndex))
        {
            if(isSelected)
                compnt.setBackground(UIManager.getColor("ComboBox.background"));
            else
                compnt.setBackground(super.getBackground());
            compnt.setForeground(greyedBox);
        }
        else
        {
            compnt.setBackground(super.getBackground());
            compnt.setForeground(super.getForeground());
        }
        return compnt;
    }


}
