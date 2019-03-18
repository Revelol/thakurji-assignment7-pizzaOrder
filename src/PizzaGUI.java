import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PizzaGUI extends JFrame{
    private JPanel mainPanel;
    private JPanel labelPanel;
    private JPanel receiptPanel;
    private JPanel optionPanel;
    private JPanel btnPanel;
    private JButton quitButton;
    private JButton clearButton;
    private JButton orderButton;
    private JPanel crustsPanel;
    private JPanel sizesPanel;
    private JPanel toppingsPanel;
    private JTextArea receiptTextArea;
    private JLabel appLabel;
    private ArrayList<JCheckBox> ingredientCheckboxes;
    private ArrayList<JRadioButton> crustsRadioButtons;
    private ButtonGroup crustsGroup;
    private JComboBox sizeCombo;
    private ArrayList<Crust> availableCrusts;
    private ArrayList<Size> availableSizes;
    private ArrayList<Ingredient> availableIngredients;

    public PizzaGUI(String title, ArrayList<Crust> crusts, ArrayList<Size> sizes, ArrayList<Ingredient> ingredients){
        super(title);
        appLabel.setText(title);
        availableCrusts = crusts;
        availableSizes = sizes;
        availableIngredients = ingredients;

        ingredientCheckboxes = new ArrayList<>();
        for(Ingredient i : ingredients){
            JCheckBox newObj = new JCheckBox(i.toString());
            newObj.putClientProperty("value", i);
            ingredientCheckboxes.add(newObj);
        }

        crustsRadioButtons = new ArrayList<>();
        for(Crust c: crusts){
            JRadioButton newObj = new JRadioButton(c.toString());
            newObj.putClientProperty("value", c);
            crustsRadioButtons.add(newObj);
        }
        crustsGroup = new ButtonGroup();


        sizeCombo = new JComboBox(sizes.toArray());

        updateUI();

        add(mainPanel);
        setSize(800,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        quitButton.addActionListener((ActionEvent e) -> {
            int selectedOption = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to quit?",
                    "Choose",
                    JOptionPane.YES_NO_OPTION);
            if(selectedOption == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        });

        orderButton.addActionListener((ActionEvent e) -> {
            Order order= new Order();

            //Selected Ingredients
            ArrayList<Ingredient> selectedIngredients = new ArrayList<Ingredient>();
            for(JCheckBox item : ingredientCheckboxes){
                if(item.isSelected()){
                    selectedIngredients.add((Ingredient)item.getClientProperty("value"));
                }
            }

            //Selected Crust
            Crust selectedCrust = null;
            for(JRadioButton item : crustsRadioButtons){
                if(item.isSelected()){
                    selectedCrust = (Crust) item.getClientProperty("value");
                }
            }

            Size selectedSize = null;
            selectedSize = (Size) sizeCombo.getSelectedItem();

            if (selectedCrust != null && selectedSize != null && selectedIngredients.size() > 0) {
                Pizza pizza = new Pizza(selectedCrust, selectedSize, selectedIngredients);

                order.addPizza(pizza);

                String receipt = order.getReceipt();
                receiptTextArea.setText(receipt);
            } else {
                JOptionPane.showMessageDialog(null, "Oops! Please select a Crust, Size and at least one ingredient");
            }

        });


        clearButton.addActionListener((ActionEvent e) -> {
            receiptTextArea.setText("");
            for(JCheckBox item : ingredientCheckboxes){
                item.setSelected(false);
            }
            for(JRadioButton item : crustsRadioButtons){
                crustsGroup.clearSelection();
            }
        });


    }

    private void updateUI(){
        GridLayout toppingPanelLayout = new GridLayout(ingredientCheckboxes.size(), 1);
        toppingsPanel.setLayout(toppingPanelLayout);
        for(JCheckBox item : ingredientCheckboxes){
            toppingsPanel.add(item);
        }

        GridLayout crustsPanelLayout = new GridLayout(crustsRadioButtons.size(),1);
        crustsPanel.setLayout((crustsPanelLayout));
        for(JRadioButton item : crustsRadioButtons){
            crustsPanel.add(item);
            crustsGroup.add(item);
        }

        GridLayout sizesPanelLayout = new GridLayout(1,1);
        sizesPanel.setLayout(sizesPanelLayout);
        sizesPanel.add(sizeCombo);
    }
}
